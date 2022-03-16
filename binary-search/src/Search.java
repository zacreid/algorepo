import java.util.*;

public class Search {
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T
            elem, final Comparator<T> comparator) {
        /** binarySearch by Zac Reid 20470592 28/02/2022
         * @param array - the array of objects to be searched
         * @param elem - the element to be found
         * @param comparator - comparison for search
         * @return position of element in array (int)
         *
         *
         *  This function uses the binary search algorithm to return the position of the element you are searching for
         *
         */

        int l = 0;
        int r = array.length - 1;

        while (r >= l) {
            int m = (l + r) / 2; // find midpoint of array
            int state = comparator.compare(array[m], elem); // get comparison for mid elem

            if (state == 0) {
                return m; // found elem so return m (pos)
            } else if (state == -1) {
                l = m + 1;  // divide search area since item not found
            } else {
                r = m - 1;  // divide search area since item not found
            }
        }

        return -1; // item not found so return -1
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T
            elem, final Comparator<T> comparator) {
        /** binarySearchRecursive by Zac Reid 20470592 28/02/2022
         * @param array - the array of objects to be searched
         * @param elem - the element to be found
         * @param comparator - comparison for search
         * @return position of element in array (int)
         *
         *  This function uses a recursive version of the binary search algorithm to return the position of the element
         *      you are searching for
         */

        return binarySearchRecursive(array, elem, comparator, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T
            elem, final Comparator<T> comparator, final int l, final int r) {
        /** binarySearchRecursive by Zac Reid 20470592 28/02/2022
         * @param array - the array of objects to be searched
         * @param elem - the element to be found
         * @param comparator - comparison for search
         * @param l - left side of search area
         * @param r - right side of search area
         * @return position of element in array (int)
         *
         *  This function uses a recursive version of the binary search algorithm to return the position of the element
         *      you are searching for
         */

        if (r >= l) {
            int m = (l + r) / 2; // find midpoint of array
            int state = comparator.compare(array[m], elem); // get comparison for mid elem

            if (state == 0) {
                return m; // found elem so return m (pos)
            } else if (state == -1) {

                return binarySearchRecursive(
                        array, elem, comparator, m + 1, r);  // divide search area since item not found
            } else {

                return binarySearchRecursive(
                        array, elem, comparator, l, m - 1);  // divide search area since item not found
            }
        }

        return -1; // item not found so return -1
    }

    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem,
                                                             final Comparator<T> comparator) {
        /** binarySearch (using lists) by Zac Reid 20470592 28/02/2022
         * @param list - list of objects to be searched
         * @param elem - the element to be found
         * @param comparator - comparison for search
         * @return position of element in list (int)
         *
         * This function uses the binary search algorithm to return the position of the element you are searching for
         */

        int l = 0;
        int r = list.size() - 1;

        while (r >= l) {
            int m = (l + r) / 2; // find midpoint of array
            int state = comparator.compare(list.get(m), elem); // get comparison for mid elem

            if (state == 0) {
                return m; // found elem so return m (pos)
            } else if (state == -1) {
                l = m + 1;  // divide search area since item not found
            } else {
                r = m - 1;  // divide search area since item not found
            }
        }

        return -1; // item not found so return -1
    }

    public static void main(String[] args) {
        Integer[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        List<Integer> lst = Arrays.asList(arr);
        Comparator<Integer> c = Comparator.comparing(Integer::intValue);

        System.out.println(binarySearch(arr, 9, c));
        System.out.println(binarySearchRecursive(arr, 9, c));
        System.out.println(binarySearch(lst, 9, c));
    }
}
