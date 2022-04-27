import java.util.Arrays;

// Zac Reid 20470592

public class main {
    // Fibonacci -- -- -- -- -- -- -- -- -- -- -- -- -- --

    public static int fib(final int n) {
        /**
         *  Recursive Fibonacci method - -
         *
         * Time-complexity - 2^n
         * Space-complexity - 1
         */
        if (n < 2) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    public static int fibDYN(final int n) {
        /**
         *  Dynamic Prog. Fibonacci method - -
         *
         * Time-complexity - n
         * Space-complexity - n
         */
        int[] F = new int[n+1];

        F[0] = 0;

        if(n > 0) {
            F[1] = 1;

            for (int i = 2; i <= n; i++) {
                F[i] = F[i - 1] + F[i - 2];
            }
        }

        return F[n];
    }


    // LCM -- -- -- -- -- -- -- -- -- -- -- -- -- --

    public static int largestT(final int[][] T ){
        int x = T.length;
        int y = T[0].length;

        int l = 0;
        for (int j = 0; j < x; j++) {

            for (int k = 0; k < y; k++) {

                if (T[j][k] > l) {
                    l = T[j][k];
                }
            }
        }

        return l;
    }

    public static int LCS(final String sOne, final String sTwo) {
        /**
         *  Longest Common Substring method - -
         *
         *  Time-complexity - len(x) * len(y)
         *  Space-complextiy - len(x) * len(y)
         */
        int[][] T = new int[sOne.length() + 1][sTwo.length() + 1];
        char[] X = sOne.toCharArray();
        char[] Y = sTwo.toCharArray();

        for (int j = 0; j < X.length; j++) {

            for (int k = 0; k < Y.length; k++) {

                if (X[j] == Y[k]) {
                    T[j+1][k+1] = T[j][k] + 1;
                } else {
                    T[j+1][k+1] =  Math.max(T[j+1][k], T[j][k+1]);
                }
            }
        }

        return largestT(T);
    }

    // Knapsack Problem -- -- -- -- -- -- -- -- -- -- -- -- -- --

    public static int knapsackDYN(final int W, final int[] w, final int[] vals) {
        /**
         *  Dynamic knapsack method - -
         *
         *  Time-complexity -  nC
         *  Space-complexity -  n^2
         */
        int n = w.length;
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] T = new int[n+1][W+1];

        for (int i = 0; i <= W; i++) {
            T[0][i] = 0;
        }

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= W; k++) {
                if (w[j - 1] > k) {
                    T[j][k] = T[j - 1][k];
                } else {
                    T[j][k] = Math.max(
                            T[j - 1][k],
                            T[j - 1][k - w[j - 1]] + vals[j - 1]);
                }
            }
        }
        return T[n][W];
    }

    public static int knapsackBRUTE(final int W, final int[] w, final int[] vals) {
        /**
         *  Brute Knapsack method - -
         *
         * Time-complexity -  2^n
         * Space-complexity - 1
         */
        int n = w.length;
        if (n <= 0) {
            return 0;
        }

        if (w[n - 1] > W) {
            return knapsackBRUTE(W, Arrays.copyOf(w, n - 1), Arrays.copyOf(vals, n - 1));
        } else {
            return Math.max(
                    knapsackBRUTE(W, Arrays.copyOf(w, n - 1), Arrays.copyOf(vals, n - 1)),
                    vals[n - 1] + knapsackBRUTE(W - w[n - 1], Arrays.copyOf(w, n - 1), Arrays.copyOf(vals, n - 1))
            );
        }
    }

    public static void main(String[] args) {
        System.out.print("The Fib. of 12 - ");
        System.out.println(fibDYN(12));

        System.out.println("A Knapsack with a limit of 50 and the following parameters");
        System.out.println("W - V");
        System.out.println("10 - 50");
        System.out.println("60 - 300");
        System.out.println("30 - 10");
        System.out.println("20 - 80");
        System.out.println("40 - 20");

        int[] w = {10,60,30,20,40};
        int[] v = {50,300,10,80,20};
        System.out.println("Knapsack table value");
        System.out.println(knapsackDYN(50, w, v));
    }
}
