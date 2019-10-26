package string;

import java.util.ArrayList;
import java.util.Collections;

class Stringoholics {

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("a");
        str.add("ababa");
        str.add("aba");
        Stringoholics sgh = new Stringoholics();
        int result  = sgh.solve(str);
        System.out.println(result);
    }


    public int solve(ArrayList<String> str) {
        int maxLengthString = 0;

        // Create 
        ArrayList<String> newStr = new ArrayList<>();
        for(String s: str) {
            newStr.add(s);  
        }
        
        // Find the Length of String Having Maximum Characters
        for(int i =0, n=newStr.size(); i < n; i++) {
            String individualString = newStr.get(i);
            if(individualString.length() > maxLengthString) {
                maxLengthString = Math.max(maxLengthString, individualString.length());
            }
        }

        int originalSelfCount = 0;
        int miniValueOfRotation = Integer.MAX_VALUE;
        for(int i=1; i <= maxLengthString ; i++) {
            int currentSelfCount = 0;

            for(int j=0; j < newStr.size(); j++) {
                String currentString = newStr.get(j);  
                int pos = i % (currentString.length());
                String rotatedString = circularRotate(newStr.get(j), pos);

                System.out.println("i " + i + " currentString: " + currentString + " RotatedString: " + rotatedString);

                if(rotatedString.equals(str.get(j))) {
                    currentSelfCount++;
                }

                newStr.set(j, rotatedString);
            }
            
            System.out.println("i: " +  i + " currentSelfCount: " + currentSelfCount);


            if(currentSelfCount > originalSelfCount) {
                miniValueOfRotation = Math.min(miniValueOfRotation, i);
                originalSelfCount = currentSelfCount;
            }
        }

        return miniValueOfRotation;
    }

    public static String circularRotate(String str, int position) {   
        StringBuilder sb = new StringBuilder();
        // System.out.println("String: " + str + " position: " + position);
        sb.append(str.substring(position, str.length()));
        sb.append(str.substring(0, position));
        return sb.toString();
    }
}