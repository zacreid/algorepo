import java.lang.reflect.Array;
import java.util.*;

public class Sorting {

    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {
        /**
         * bogoSort List by Zac Reid 20470592 16/02/2022
         * @param list the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided list with bogoSort method
         *
         * The time complexity of this algorithm is
         *      Best Case - O(n) This is if elements are already sorted by chance
         *             N + (N + 1) + Constant = O(n)
         *
         *      Avg Case - O((N+1)!) This is because we are creating random permutations of objects and testing if they
         *          are in order which is very inefficient
         *              N + (N + 1)! + Constant = O((N + 1)!)
         *
         *      Worst case - Infinite This is because in theory we could randomly shuffle all the elements and never
         *          fully sort them.
         *
         * This algorithm has a space complexity of 1
         */
        while (true) {
            Collections.shuffle(list);

            Iterator<T> it = list.iterator();
            T prev = it.next();
            T curr;
            boolean success = true;

            while (it.hasNext()) {
                curr = it.next();

                if (comparator.compare(prev, curr) == 1) {
                    success = false;
                    continue;
                }

                prev = curr;
            }

            if (success) {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        /**
         * bogoSort Array by Zac Reid 20470592 16/02/2022
         * @param array the array of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided array with bogoSort method
         */
        List<T> tmp = Arrays.asList(array);

        bogoSort(tmp, comparator);

        tmp.toArray(array);
    }

    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        /**
         * bubbleSort List by Zac Reid 20470592 16/02/2022
         * @param list the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided list with bubbleSort method
         *
         * The time complexity of this algorithm is
         *      Best case - O(n) This is because elements are already sorted and we just run through the elements to check
         *
         *      Avg case - O(n^2) We get this from our nested loops as we are constantly re-looping through elements
         *          (N + Constants)(N + Constants) + Constants = O(n^2)
         *
         * This algorithm has a space complexity of 1
         */
        while (true) {
            boolean sorted = true;
            for(int i = 1; i < list.size(); i++){
                if (comparator.compare(list.get(i - 1), list.get(i)) == 1) {
                    sorted = false;
                    T tmp = list.get(i - 1);

                    list.set(i - 1, list.get(i));
                    list.set(i, tmp);
                }
            }

            if (sorted) {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        /**
         * bubbleSort Array by Zac Reid 20470592 16/02/2022
         * @param array the array of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided array with bubbleSort method
         */
        while (true) {
            boolean sorted = true;
            for(int i = 1; i < array.length; i++){
                if (comparator.compare(array[i - 1], array[i]) == 1) {
                    sorted = false;
                    T tmp = array[i - 1];

                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }

            if (sorted) {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        /**
         * selectionSort List by Zac Reid 20470592 16/02/2022
         * @param list the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided list with selectionSort method
         *
         * The time complexity of this algorithm is
         *      Best Case - O(n^2) as we have nested loops
         *              (N + Constants)(N + Constants) + Constants = O(n^2)
         *
         *      Avg Case - O(n^2) as we have nested loops
         *              (N + Constants)(N + Constants) + Constants = O(n^2)
         *
         * This has a space complexity of 1
         */
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;

            int z;
            for (z = i + 1; z < list.size(); z++) {
                if (comparator.compare(list.get(min), list.get(z)) == 1) {
                    min = z;
                }
            }

            T tmp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, tmp);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {
        /**
         * selectionSort Array by Zac Reid 20470592 16/02/2022
         * @param array the array of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided array with selectionSort method
         */
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int z = i + 1; z < array.length; z++) {
                if(comparator.compare(array[min], array[z]) == 1) {
                    min = z;
                }
            }

            T tmp = array[i];

            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static <T extends Comparable<T>> void merge(
            final List<T> list, final List<T> left, final List<T> right, final Comparator<T> comparator) {

        int lsize = left.size(), rsize = right.size();

        int i = 0, j = 0, k = 0;

        while (i < lsize && j < rsize) {
            if(comparator.compare(left.get(i), right.get(j)) == -1) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
    }

    public static <T extends Comparable<T>> void merge(
            final T[] array, final T[] left, final T[] right, final Comparator<T> comparator) {
        int lsize = left.length, rsize = right.length;

        int i = 0, j = 0, k = 0;

        while (i < lsize && j < rsize) {
            if(comparator.compare(left[i], right[j]) == -1) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < lsize) {
            array[k++] = left[i++];
        }

        while (j < rsize) {
            array[k++] = right[j++];
        }
    }

    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        /**
         * mergeSort Array by Zac Reid 20470592 16/02/2022
         * @param list the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided list with mergeSort method
         *
         * The time complexity of this algorithm is
         *      Divide elements - 2N
         *      Comparison - 2^logn (This is because we get N with logN sections)
         *      Total = 2N * 2^logN = O(N log N)
         *
         * This has a space complexity of N
         */

        if (list.size() < 2) return;

        int midpoint = list.size() / 2;
        List<T> left = list.subList(0, midpoint);
        List<T> right = list.subList(midpoint, list.size());

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        /**
         * mergeSort Array by Zac Reid 20470592 16/02/2022
         * @param array the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided array with mergeSort method
         */

        if (array.length < 2) return;

        int midpoint = array.length / 2;

        @SuppressWarnings("unchecked")
        T[] left = ( T[] ) new Comparable[midpoint];
        @SuppressWarnings("unchecked")
        T[] right = ( T[] ) new Comparable[array.length - midpoint];

        System.arraycopy(array, 0, left, 0, midpoint);

        if (array.length - midpoint >= 0) {
            System.arraycopy(array, 0 + midpoint, right, 0, array.length - midpoint);
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(array, left, right, comparator);
    }
    public static <T extends Comparable<T>> int partition(final List<T> list, int l, int h, final Comparator<T> comparator) {
        int i = l, j = h + 1;

        while (true) {
            while (comparator.compare(list.get(++i), list.get(l)) == -1) {
                if (i == h) break;
            }
            while (comparator.compare(list.get(l), list.get(--j)) == -1) {
                if (j == l) break;
            }

            if (i >= j) break;

            T tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }

        T tmp = list.get(l);
        list.set(l, list.get(j));
        list.set(j, tmp);

        return j;
    }

    public static <T extends Comparable<T>> void Sort(final List<T> list, int l, int h, final Comparator<T> comparator) {
        if (h <= l) return;

        int j = partition(list, l, h, comparator);

        Sort(list, l, j - 1, comparator);
        Sort(list, j + 1, h, comparator);
    }

    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        /**
         * quickSort List by Zac Reid 20470592 16/02/2022
         * @param list the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided list with quickSort method
         *
         * The time complexity of this algorithm is
         *      Divide elements - 2N
         *      Comparison - 2^logn (This is because we get N with logN sections)
         *      Total = 2N * 2^logN = O(N log N)
         * This has a space complexity of N
         *
         * This approach could be improved using the following methods
         *      Increase sub-array size as this reduces the overheads of many small arrays
         *
         *      Picking a better pivot point can improve sorting speeds (pick median value as pivot (middle point))
         *
         *      When sub arrays (or main array) is of a small size use an alternative sorting algorithm to improve speed
         *          as quickSort has some added overhead for small arrays
         *
         *      If many elements are equal to the pivot point this can mess up the partitioning of the elements
         *          a workaround for this is to partition elements into 3 sub arrays, less that, equal too and greater than
         */
        Collections.shuffle(list);

        Sort(list, 0, list.size() - 1, comparator);
    }

    public static <T extends Comparable<T>> int partition(final T[] array, int l, int h, final Comparator<T> comparator) {
        int i = l, j = h + 1;

        while (true) {
            while (comparator.compare(array[++i], array[l]) == -1) {
                if (i == h) break;
            }
            while (comparator.compare(array[l], array[--j]) == -1) {
                if (j == l) break;
            }

            if (i >= j) break;

            T tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        T tmp = array[l];
        array[l] = array[j];
        array[j] = tmp;

        return j;
    }

    public static <T extends Comparable<T>> void Sort(final T[] array, int l, int h, final Comparator<T> comparator) {
        if (h <= l) return;

        int j = partition(array, l, h, comparator);

        Sort(array, l, j - 1, comparator);
        Sort(array, j + 1, h, comparator);
    }

    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        /**
         * quickSort Array by Zac Reid 20470592 16/02/2022
         * @param array the list of objects to be sorted
         * @param comparator comparison object for sorting
         * @return void
         *
         * Function sorts provided array with quickSort method
         */
        List<T> tmp = Arrays.asList(array);
        Collections.shuffle(tmp);
        tmp.toArray(array);

        Sort(array, 0, array.length - 1, comparator);
    }
}
