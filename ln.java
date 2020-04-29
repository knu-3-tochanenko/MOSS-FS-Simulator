public class ln {

    /**
     * The name of this program. This is the program name that is used when
     * displaying error messages.
     */
    public static final String PROGRAM_NAME = "ln";

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
        if (argv.length != 2) {
            System.out.println(ANSI.Red("Wrong \"")+ ANSI.Yellow(PROGRAM_NAME) + ANSI.Red("\" command signature!"));
            System.out.println(ANSI.Red("Usage: ") + "java " + ANSI.Yellow(PROGRAM_NAME) + ANSI.Blue(" <path-1> <path-2>"));
            System.out.println(ANSI.Blue("\t<path-1>") + " :\n\tPath to be copied");
            System.out.println(ANSI.Blue("\t<path-2>") + " :\n\tWhere to copy");
            Kernel.exit(1);
        }

        System.out.println(ANSI.Blue("Path 1: ") + argv[0]);
        System.out.println(ANSI.Blue("Path 2: ") + argv[1]);
        int result = Kernel.link(argv[0], argv[1]);

        if (result < 0) {
            Kernel.perror(PROGRAM_NAME);
            Kernel.exit(1);
        }

        // exit with success if we read all the files without error
        Kernel.exit(0);
    }
}