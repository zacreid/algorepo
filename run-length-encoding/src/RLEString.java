public class RLEString {

    public static void printRLE(final String input) {
        /**
         *  Prints an RLE string provided an input string
         */

        if (input.length() > 0) {
            int i = 0;
            char[] carr = input.toCharArray();
            char prev = carr[0];

            for (char c : carr) {
                if (prev == c) {
                    i++;
                } else {
                    System.out.print(prev);
                    System.out.print(i);

                    prev = c;
                    i = 1;
                }
            }

            System.out.print(carr[carr.length - 1]);
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        String input = BinaryStdIn.readString();
        printRLE(input);
    }
}
