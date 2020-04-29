public class umask {
    /**
     * The name of this program. This is the program name that is used when
     * displaying error messages.
     */
    public static final String PROGRAM_NAME = "umask";

    private static void showUsage() throws Exception {
        System.out.println(ANSI.Red("Wrong \"")+ ANSI.Yellow(PROGRAM_NAME) + ANSI.Red("\" command signature!"));
        System.out.println(ANSI.Red("Usage: ") + "java " + ANSI.Yellow(PROGRAM_NAME) + ANSI.Blue(" <mask>"));
        System.out.println(ANSI.Blue("\t<mask>") + " :\n\tNew mask in [000, 777]");
        Kernel.exit(1);
    }

    /**
     * Change umask
     *
     * @exception java.lang.Exception if an exception is thrown by an underlying
     *                                operation
     */
    public static void main(String[] argv) throws Exception {
        // initialize the file system simulator kernel
        Kernel.initialize();

        // make sure we got the correct number of parameters
        if (argv.length != 1) {
            showUsage();
        }

        String umask = argv[0];
        if (!umask.matches("[0-7]+")) {
            showUsage();
        }

        int intUmask = Integer.parseInt(umask, 8);

        intUmask &= 511; // &0777 see man umask for detailed description

        Kernel.umask((short) intUmask);

        Kernel.exit(0);
    }
}