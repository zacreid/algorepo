public class stringSearch {

    public static int bruteForce(String pat, String input) {
        /**
         *  Brute force string search
         *  Takes a pattern (String) and takes a input (String) and
         *  returns pos of substring, unless substring is not found
         *  then function returns -1
         */
        int m = pat.length();
        int n = input.length();

        char[] T = input.toCharArray();
        char[] patT = pat.toCharArray();

        for (int i = 0; i < n-m; i++) {

            int j = -1;
            while (++j < m) {
                if (input.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static int KMPSearch(final String pat, final String txt) {
        /**
         *  KMP string search
         *  Takes a pattern (String) and takes a input (String) and
         *  returns pos of substring, unless substring is not found
         *  then function returns -1
         */
        int M = pat.length();
        int N = txt.length();
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        for (int i = 0; i < N; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                if (j == M - 1) {
                    return i - j;
                }
                j++;
            } else if (j != 0) {
                j = lps[j - 1];
                i--;
            }
        }
        return -1;
    }
    public static void computeLPSArray(final String pat, final int M, final int lps[]) {
        /**
         *  Compute LPS Array
         *  Takes pattern (string), the length of the pattern M (int) and a int array lps for storing values
         */
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                        len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                // Also, note that we do not increment
                // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String p = "long";
        String t = "abba bob long";

        System.out.println("Search Text - 'abba bob long'  - - - Pattern Text - 'long'");

        System.out.print("Result from Brute - ");
        System.out.println(bruteForce(p, t));

        System.out.print("Result from KMP - ");
        System.out.println(KMPSearch(p, t));
    }

}
