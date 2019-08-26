package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

    public boolean isPartitionFeasable(ArrayList<Integer> books, int students, int current_min) {
        int current_sum = 0;
        int student_cnt = 1;

        for (int i = 0, n = books.size(); i < n; i++) {
            // System.out.println("CurrentSum: " + current_sum + " Student Count " + student_cnt);

            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (books.get(i) > current_min) {
                return false;
            }

            if (current_sum + books.get(i) > current_min) {
                student_cnt++;
                current_sum = books.get(i);

                // if students required becomes greater 
                // than given no. of students,return false  
                if (student_cnt > students) {
                    return false;
                }

            } else {
                current_sum += books.get(i);
            }
        }

        return true;
    }

    public int books(ArrayList<Integer> books, int students) {
        // Find the Total Pages
        
        if(students > books.size()) {
            return -1;
        }
        
        long end = 0;
        for (Integer book : books) {
            end += book;
        }

        System.out.println(end);
        int start = 0;
        int result = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (int) ((start + end) / 2);
            // System.out.println("Start: " + start + " End: " + end + " Mid: " + mid);

            if (isPartitionFeasable(books, students, mid)) {
                // System.out.println("Feasable Start: " + start + " End: " + end + " Mid: " + mid);
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) result;
    }

    // Driver Method
    public static void main(String[] args) {
        AllocateBooks abooks = new AllocateBooks();
        Integer arr[] = { 12, 34, 67, 90 };
        int m = 2;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(arr));
        System.out.println("Minimum number of pages = " + abooks.books(list, m));
    }
}