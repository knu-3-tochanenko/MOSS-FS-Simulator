public class chown {

    /**
     * The name of this program. This is the program name that is used when
     * displaying error messages.
     */
    public static final String PROGRAM_NAME = "chown";

    /**
     * Lists information about named files or directories.
     * 
     * @exception java.lang.Exception if an exception is thrown by an underlying
     *                                operation
     */

    public static void main(String[] argv) throws Exception {
        // initialize the file system simulator kernel
        Kernel.initialize();

        // if no paths to link
        if (argv.length < 2) {
            System.out.println(ANSI.Red("Wrong \"")+ ANSI.Yellow(PROGRAM_NAME) + ANSI.Red("\" command signature!"));
            System.out.println(ANSI.Red("Usage: ") + "java " + ANSI.Yellow(PROGRAM_NAME) + ANSI.Blue(" <uid_number> <entry_names>"));
            System.out.println(ANSI.Blue("\t<uid_number>") + " :\n\tNew UID");
            System.out.println(ANSI.Blue("\t<entry_names>") + " :\n\tOne or more paths to files\n\tChages file's UID");
            Kernel.exit(1);
        }

        short uid = Short.valueOf(argv[0]);
        for (int i = 1; i < argv.length; i++) {
            int status = Kernel.chown(argv[i], uid);
            if (status < 0) {
                Kernel.perror(PROGRAM_NAME);
                System.out.println(ANSI.Yellow(PROGRAM_NAME) + ANSI.Red(": unable to find inode"));
                Kernel.exit(1);
            }
        }

        // exit with success if we read all the files without error
        Kernel.exit(0);
    }
}