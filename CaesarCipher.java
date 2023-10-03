import java.io.PrintWriter;

public class CaesarCipher {
    public static void main(String[] args) throws Exception {

        java.io.PrintWriter pen;
            //creates pen to be used for printing
        pen = new java.io.PrintWriter(System.out, true);
        boolean _encode = true;

        //checks whether there are only two command line arguments
        if (args.length != 2) {
            pen.println("Incorrect number of parameters");
            // graceful exit
            System.exit(0);
        }

        if (args[0].equalsIgnoreCase("encode")) { //checks whether it's encode or decode
            // pen.println("to be encoded");
            _encode = true;
            encode(args, _encode);
        } else if (args[0].equalsIgnoreCase("decode")) {
            _encode = false;
            encode(args, _encode);
            // pen.println("to be decoded");
        } else {
            pen.println("Valid options are \"encode\" or \"decode\""); //if user did not put encode/decode in the right place or spelled it wrong
            System.exit(0);
        }

    }
//pre : int x
//pre : int y
//post : integer between 0 and 25 signifying which letter it will be transformed to
static int wrap(int x, int y, boolean positive) { //wrap functioned to be used for ceaser cipher function
    if(positive){
    return ((x + y) % 26);
    }else{
        return ((x - y + 26) % 26);
    }
}



//pre : args
//pre : boolean _encode, which encodes the word when true and decodes when false
//post : void, but prints out all 26 combinations of encoding/decoding the word
    public static void encode(String[] args, boolean _encode) { //encode the function
        java.io.PrintWriter pen;
        pen = new java.io.PrintWriter(System.out, true);

        char[] messagearray = args[1].toCharArray();
        int messagelength = messagearray.length;

        int[] normalizedarray = new int[messagelength];

        char[] chararray = new char[messagelength];

        for (int i = 0; i < messagelength; i++) {
            normalizedarray[i] = messagearray[i] - 'a';
        }

        for (int i = 0; i < 26; i++) {
            pen.print("n = " + i + ": ");
            for (int j = 0; j < messagelength; j++) {
                if (_encode){
                chararray[j] = (char) (wrap(normalizedarray[j], i, true) + 'a');
                } else {
                     chararray[j] = (char) (wrap(normalizedarray[j], i, false) + 'a');
                }
                pen.print(chararray[j]);
            }
            pen.println("");
        }
    }//encode
}//end of file