package String;

public class CountAndSay {

    public String countAndSay(int A) {
        if(A == 1) {
            return "1";
        } else if(A == 2) {
            return "11";
        } else {
            return computeString(countAndSay(A - 1));
        }
    }

    public String countAndSayDp(int A) {
        String [] cache = new String[A];
        return countAndSayWrapperDp(A, cache);
    }


    public String countAndSayWrapperDp(int A, String[] cache) {
        if(cache[A-1] != null) {
            System.out.println("Return from Cache");
            return cache[A-1];
        } else {
            if(A == 1) {
                cache[0] = "1";
                return "1";
            } else if(A == 2) {
                cache[1] = "11";
                return "11";
            } else {
                String result = computeString(countAndSayWrapperDp(A - 1, cache));
                cache[A-1] = result;
                return result;
            }
        }
    }


    public String computeString(String str) {
        StringBuilder result = new StringBuilder();
        String [] splitStr = str.split("");
        int currentElementCount = 1;
    
        for(int i=0, n=splitStr.length; i<n-1; i++) {
            char currentElement = str.charAt(i);
            char nextElement = str.charAt(i+1);
    
            if(currentElement == nextElement) {
                currentElementCount++;
            } else {
                result.append(String.valueOf(currentElementCount));
                result.append(currentElement);
                currentElementCount = 1;
            }
        }
    
        result.append(String.valueOf(currentElementCount));
        result.append(str.charAt(str.length() - 1));
        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();

        // for(int i = 1 ; i <= 8; i++) {
        //     System.out.println("i: " + i + " Next Sequence: " + ans);
        // }

        int num = 4;
        long startTime = System.currentTimeMillis();
        String ans = cs.countAndSayDp(num);
        long timeDiff = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken Dp: " + timeDiff);

        startTime = System.currentTimeMillis();
        ans = cs.countAndSayDp(num);
        timeDiff = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken: " + timeDiff);

    }
}

//1113213211
//1113213211
//1113213211