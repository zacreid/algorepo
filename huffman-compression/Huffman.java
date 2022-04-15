public class Huffman {
    // alphabet size of extended ASCII
    private static final int R = 256;


    // Huffman trie node
    private record Node(char ch, int freq, Huffman.Node left, Huffman.Node right) implements Comparable<Node> {

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return left == null;
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // Get input bytes and convert to char arr.
        char[] data = BinaryStdIn.readString().toCharArray();

        // Count occurrence of diff. bytes
        int[] freq = new int[R];
        for(char c : data){
            freq[c]++;
        }

        // Create Huffman Trie and create lookup table
        Node trie = buildTrie(freq);
        String[] lookup = new String[R];
        getTrieCodes(lookup, trie, "");

        // Output compressed data

        // Write Huffman Trie and msg. size to output for decoding later
        writeTrie(trie);
        BinaryStdOut.write(data.length);

        // Convert to Huffman Code and write to output
        for (char c : data) {
            for (char bit : lookup[c].toCharArray()) {
                BinaryStdOut.write(bit == '1');
            }
        }

        // Terminate output
        BinaryStdOut.close();
    }

    public static Node buildTrie(int[] freq){
        MinPQ<Node> pq = new MinPQ<>();

        // Create starting nodes
        for (char i = 0; i < R; i++) {
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }
        }

        // Merge two smallest lists in priority queue until we
        // arrive at a tree of size less than or equal one
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            pq.insert(new Node('\0', left.freq + right.freq, left, right));
        }
        return pq.delMin();
    }

    public static void getTrieCodes(String[] lookup, Node node, String s) {
        // Make sure node is internal
        if(!node.isLeaf()) {
            getTrieCodes(lookup, node.left, s + '0');
            getTrieCodes(lookup, node.right, s + '1');
        } else {
        // Node is a leaf, so we reach the end of this branch
            lookup[node.ch] = s;
        }
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        // Lets us know if we are encoding a leaf or a branch
        // when decoding
        BinaryStdOut.write(x.isLeaf());

        if (x.isLeaf()){
            // This is a leaf node so output character and terminate
            BinaryStdOut.write(x.ch, 8);
        } else {
            // This is a branch for find left and right branch
            writeTrie(x.left);
            writeTrie(x.right);
        }
    }

    // read bitstring-encoding trie from std. input
    private static Node readTrie() {
        // Check if Node is a leaf
       boolean isLeaf = BinaryStdIn.readBoolean();

       if (isLeaf) {
           // Node is a leaf, so we return node with relevant character
           return new Node(BinaryStdIn.readChar(), 0, null, null);
       } else {
           // Node is a branch, so we find left and right branch from
           // bitstring-encoded trie
           return new Node('\0', 0, readTrie(), readTrie());
       }
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void expand() {
        Node trie = readTrie();
        int length = BinaryStdIn.readInt();

        for (int i = 0; i < length; i++) {
            // Our starting node
            Node s = trie;

            // Keep searching until we find a leaf
            while (!s.isLeaf()) {
                // Get branch of next node
                boolean nxtNode = BinaryStdIn.readBoolean();

                if (nxtNode) {
                    // if nxt_node == True we get the right node and visa versa
                    s = s.right;
                } else {
                    s = s.left;
                }
            }

            BinaryStdOut.write(s.ch, 8);
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
