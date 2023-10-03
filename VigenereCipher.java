import java.io.PrintWriter;

public class VigenereCipher {
    public static void main(String[] args) throws Exception {
        java.io.PrintWriter pen;

            //creates pen to be used for printing
        pen = new java.io.PrintWriter(System.out, true);
        boolean _encode = true;

        //checks whether there are 3 command line arguments
        if (args.length != 3) {
            pen.println("Incorrect number of parameters");
            // graceful exit
            System.exit(0);
        }

        if((args[2].length()) == 0){
            pen.println(args[1]);
            System.exit(0);
        }

        if (args[0].equalsIgnoreCase("encode")) { //checks whether it's encode or decode
            _encode = true;
            vigencode(args, _encode);
        } else if (args[0].equalsIgnoreCase("decode")) {
            _encode = false;
            vigencode(args, _encode);
        } else {
            pen.println("Valid options are \"encode\" or \"decode\""); //if user did not put encode/decode in the right place or spelled it wrong
            System.exit(0);

        }
    }


    //pre : args
    //pre : boolean _encode, which encodes the word when true and decodes when false
    //post : void, but will print out the encoded/decoded array
    public static void vigencode (String[] args, boolean _encode){

        java.io.PrintWriter pen;

        pen = new java.io.PrintWriter(System.out, true);

        char[] messagearray = args[1].toCharArray(); //setting up variables to be used in arrays and to keep things understandable
        int messagelength = messagearray.length;
        int[] normalizedarray = new int[messagelength];
        char[] chararray = new char[messagelength];
        char[] keyarray = keyword(args);


        for (int i = 0; i < messagelength; i++) {
            
            if(_encode){
            normalizedarray[i] = wrap((messagearray[i] - 'a'), (keyarray[i] - 'a'), true);
            }else {

                 normalizedarray[i] = wrap((messagearray[i] - 'a'), (keyarray[i] - 'a'), false);
            }
            chararray[i] = (char)(normalizedarray[i] + 'a');
        }

        String str3 = new String(chararray);

        pen.println(str3);
                       
    }


    //pre : args
    //post : keyarray, which is an array of the exact length of the word that will be encoded
    public static char[] keyword(String[] args){

        int messagelength = args[1].length();
        char[] shortkey = args[2].toCharArray(); 
        int modnum = args[2].length();
        char[] keyarray = new char[messagelength];
        for(int i = 0; i< messagelength; i++){

            keyarray[i] = shortkey[(i % modnum)];
        }
        return keyarray;
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
    }//wrap
}//end of file
