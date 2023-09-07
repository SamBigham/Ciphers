import java.io.PrintWriter;

public class Vigenere {
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

        char[] ciparray = args[1].toCharArray(); //setting up variables to be used in arrays and to keep things understandable

        int[] normalarray = new int[ciparray.length];

        char[] chararray = new char[ciparray.length];

        char[] keyarray = keyword(args);


        for (int i = 0; i < ciparray.length; i++) {
            
            if(_encode){
            normalarray[i] = wrap((ciparray[i] - 'a'), (keyarray[i] - 'a'));
            }else {

                 normalarray[i] = negwrap((ciparray[i] - 'a'), (keyarray[i] - 'a'));
            }
            chararray[i] = (char)(normalarray[i] + 'a');
        }

        String str3 = new String(chararray);

        pen.println(str3);
                       
    }


    //pre : args
    //post : keyarray, which is an array of the exact length of the word that will be encoded
    public static char[] keyword(String[] args){

        int plainlength = args[1].length();
        char[] shortkey = args[2].toCharArray(); 
        int modnum = args[2].length();
        char[] keyarray = new char[plainlength];
        for(int i = 0; i< plainlength; i++){

            keyarray[i] = shortkey[(i % modnum)];
        }
        return keyarray;
    }

//pre : int x
//pre : int y
//post : integer between 0 and 25 signifying which letter it will be transformed to
    static int wrap(int x, int y) { //wrap functioned to be used for ceaser cipher function

        return ((x + y) % 26);
    }

//pre : int x
//pre : int y
//post : integer between 0 and 25 signifying which letter it will be transformed to
    static int negwrap(int x, int y) { //same wrap but added 26 for when the numbers go into the negative

        return ((x - y + 26) % 26);
    }


}
