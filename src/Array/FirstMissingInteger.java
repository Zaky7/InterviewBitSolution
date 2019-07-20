package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {
    

    public int firstMissingPositive(ArrayList<Integer> list) {
        int n = list.size();
        Integer unknown =  Integer.MIN_VALUE;
        int missingInteger = 0;

        for(int i=0; i<n; i++) {
            if(list.get(i) > 0) {

                // Element at the Right Position skips
                if((i+1) == list.get(i)) {
                    continue;
                }

                int index = list.get(i) - 1;
    
                // Match the index to specific Position
                // And swap with original Element
                if(index < n) {
                    int prevValue = list.get(index);
                    list.set(index, list.get(i));

                    if(prevValue != unknown && prevValue < n) {
                        list.set(i, prevValue);
                    } else {
                        list.set(i, unknown);
                    }
                } else {
                    list.set(i, unknown);
                }

            } else {
                list.set(i, unknown);
            }
        }

        // printList(list);

        for(int i=0; i<n; i++) {
            if(list.get(i) == unknown) {
                missingInteger = i + 1;
                break;
            }
        }

        return missingInteger == 0 ? n + 1 : missingInteger;
    } 
       
    public void printList(ArrayList<Integer> list) {
        System.out.println();
        for(Integer a: list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {-4, -7, 4, 3, 2 ,1 , 6};
        
        ArrayList<Integer>  list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(arr));

        FirstMissingInteger fmp = new FirstMissingInteger();
        fmp.printList(list);


        fmp.printList(list);
        
    }

    public static void sout(Object msg) {
        System.out.println(msg.toString());
    }
}