
# PseudoCode of Array Package Solution

  
  

## 1. Flip[https://www.interviewbit.com/problems/flip/]

  

### Pseudocode

Suppose the String is: 10010 => -111-11. Convert 1 to -1 and 0 to 1
The Sum of Largest continous SubArray is the Answer.

Here we are going to use **Kadane Algorithm**.

#### Kadane Algorithm:

    Initialize:
    max_so_far = 0
    max_ending_here = 0
    Loop for each element of the array
    (a) max_ending_here = max_ending_here + a[i]
    (b) if(max_ending_here < 0)
    max_ending_here = 0
    (c) if(max_so_far < max_ending_here)
    max_so_far = max_ending_here
    return max_so_far

  
  

#### Code

Here we are going to take a variables left=0, right=0, leftAns=0, rightAns=0 and

cumulative (denoting current sum), maxSum= INT_MIN

  

## Now iterate over the modified array and accumulate the value of elements in the

cumulative variable

    for i =0; i<modifiedArray.length;i++:
    	cumulative += modifiedArray[i];
    	if cumulative < 0: (kadane Algo)
    	   cumulative = 0;
    		left = i+1;
        else if cumulative > maxSum:
    		leftAns = left;
    		rightAns = i;
    		maxSum = cumulative

  
  

## After loop Completion

    if maxSum < 0:
    	return [];
    else:
      return [leftAns+1, rightAns+1];

  


<br/> <br/>

## 2. Amazing SubArray [https://www.interviewbit.com/problems/amazing-subarrays/]

  

### Pseudocode
Suppose the String is: DANGER =>
First Vowel A => (A, AN, ANG, ANGE, ANGER) = (6-1) => (n - index)
Second Vowel B => (E, ER) = (6-4) => (n - index)
ans => 2 + 5 = 7

  

#### Code

     public int solve(String A) {
        char[] charArray = A.toCharArray();
        long ans = 0;
        long mod = 10003;
        
        for(int i=0, n=charArray.length; i<n; i++) {
            // System.out.println(isVowel(charArray[i]));
            if(isVowel(charArray[i])) {
                ans = (ans + (n-i)) % mod;
            }
        }
        
        return (int) (ans % mod);
    }
    
    public boolean isVowel(char ch) {
        switch(ch) {
            case 'A':
            case 'a':
            case 'e':
            case 'E':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                return true;
            default:
               return false;
        }
    } 
  

