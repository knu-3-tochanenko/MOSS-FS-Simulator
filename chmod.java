public class chmod {
    private static String PROGRAM_NAME = "chmod";

    public static void main(String[] args) throws Exception {
        Kernel.initialize();

        if (args.length < 2) {
            System.out.println(ANSI.Red("Wrong \"")+ ANSI.Yellow(PROGRAM_NAME) + ANSI.Red("\" command signature!"));
            System.out.println(ANSI.Red("Usage: ") + "java " + ANSI.Yellow(PROGRAM_NAME) + ANSI.Blue(" <mode> <entry_names>"));
            System.out.println(ANSI.Blue("\t<mode>") + " :\n\tNew mode in [000, 777]");
            System.out.println(ANSI.Blue("\t<entry_names>") + " :\n\tOne or more paths to files\n\tChages file's mode");
            Kernel.exit(1);
        }

        int value = Integer.parseInt(args[0], 8);
        short mode = (short) value;

        if (mode < 00 || mode > 0777) {
            Kernel.perror(PROGRAM_NAME);
            System.out.println(ANSI.Yellow(PROGRAM_NAME) + ANSI.Red(": wrong mode. Mode should be from 000 to 777"));
            // Kernel.perror(PROGRAM_NAME + ": wrong mode. Mode should be from 000 to 777");
            Kernel.exit(1);
        }

        short status;
        for (int i = 1; i < args.length; i++) {
            status = (short) Kernel.chmod(args[i], mode);

            if (status < 0) {
                Kernel.perror(PROGRAM_NAME);
                System.out.println(ANSI.Yellow(PROGRAM_NAME) + ANSI.Red(": can't find inode"));
                // Kernel.perror(PROGRAM_NAME + ": can't find inode");
                Kernel.exit(1);
            }

            if (status != mode) {
                Kernel.perror(PROGRAM_NAME);
                System.out.println(ANSI.Yellow(PROGRAM_NAME) + ANSI.Red(": mode is not changed"));
                // Kernel.perror(PROGRAM_NAME + ": mode is not changed");
                Kernel.exit(1);
            }
        }

        Kernel.exit(0);
    }
}