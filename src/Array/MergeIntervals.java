package Array;

import java.util.*;


public class MergeIntervals {

    public static void main(String args[]) {
        int[] X = {1, 8};
        int[] Y = {2, 10};

        int n = X.length;
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Interval interval = new Interval(X[i], Y[i]);
            intervals.add(interval);
        }

        print(intervals);
        ArrayList<Interval> result = insert((ArrayList<Interval>) intervals, new Interval(3, 6));
        print(result);
    }

    public static void print(List<Interval> intervals) {
        System.out.println();
        for (int i = 0, n = intervals.size(); i < n; i++) {
            System.out.print(intervals.get(i));
        }
        System.out.println();
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        // Add the new interval
        intervals.add(newInterval);

        // Sort the Intervals by Start Time
        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, intervalComparator);
        ArrayList<Interval> result = new ArrayList<Interval>();

        Stack<Interval> stack = new Stack<Interval>();
        int n = intervals.size();

        stack.push(intervals.get(0));

        for(int i=1; i<n; i++) {
            Interval stackTop = stack.peek();
            Interval currentInterval = intervals.get(i);

            if(stackTop.end >= currentInterval.start) {
                if(currentInterval.end > stackTop.end) {
                    stack.pop();
                    Interval mergeInterval = new Interval(stackTop.start, currentInterval.end);
                    stack.push(mergeInterval);
                }
            } else {
                stack.push(currentInterval);
            }
        }


        for(int i=0, stack_size=stack.size(); i< stack_size; i++) {
            result.add(stack.peek());
            stack.pop();
        }


        Collections.reverse(result);

//        print(result);
        return result;
    }
}
