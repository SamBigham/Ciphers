import java.io.PrintWriter;

public class Ciphers {
    public static void main(String[] args) throws Exception {

        // need to compare strings

        // Describe the two names of objects used in the program.
        java.io.PrintWriter pen;

        // Create objects and associate the names with those objects.
        pen = new java.io.PrintWriter(System.out, true);

        if (args.length != 2) {
            pen.println("Incorrect number of parameters");
            // add graceful exit
            System.exit(0);

        }

        if (args[0].equalsIgnoreCase("encode")) {
      //      pen.println("to be encoded");
            encode(args);
        } else if (args[0].equalsIgnoreCase("decode")) {
            decode(args);
            //pen.println("to be decoded");
        } else {
            pen.println("Valid options are \"encode\" or \"decode\"");
            System.exit(0);
        }

    }

    static int wrap(int x, int y) {

        return ((x + y) % 26);
    }

    static int negwrap(int x, int y) {

        return ((x - y + 26) % 26);
    }

    public static void encode(String[] args) {

        java.io.PrintWriter pen;

        pen = new java.io.PrintWriter(System.out, true);

        char[] ciparray = args[1].toCharArray();

        int[] normalarray = new int[ciparray.length];

        char[] chararray = new char[ciparray.length];

        for (int i = 0; i < ciparray.length; i++) {
            normalarray[i] = ciparray[i] - 'a';
        }

        for (int i = 0; i < 26; i++) {

            pen.print("n = " + i + ": ");

            for (int j = 0; j < ciparray.length; j++) {
                chararray[j] = (char) (wrap(normalarray[j], i) + 'a');
                pen.print(chararray[j]);
            }
            pen.println("");
        }

    }

    public static void decode(String[] args) {

        java.io.PrintWriter pen;

        pen = new java.io.PrintWriter(System.out, true);

        char[] ciparray = args[1].toCharArray();

        int[] normalarray = new int[ciparray.length];

        char[] chararray = new char[ciparray.length];

        for (int i = 0; i < ciparray.length; i++) {
            normalarray[i] = ciparray[i] - 'a';
        }

        for (int i = 0; i < 26; i++) {

            pen.print("n = " + i + ": ");

            for (int j = 0; j < ciparray.length; j++) {
                chararray[j] = (char) (negwrap(normalarray[j], i) + 'a');
                pen.print(chararray[j]);
            }
            pen.println("");
        }
    }

}