# PseudoCode of Array Package Solution

## 1. Flip[https://www.interviewbit.com/problems/flip/]

## Problem

You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

```
S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
```

### Hint

Suppose the String is: 10010 => -111-11. Convert 1 to -1 and 0 to 1
The Sum of Largest continous SubArray is the Answer (use **Kadane Algorithm**).

##### Kadane Algorithm:

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

### Now iterate over the modified array and accumulate the value of elements in the

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

## 3. First Missing Integer [https://www.interviewbit.com/problems/first-missing-integer/]

### Pseudocode.

````java
Find the length of the list if it is 1
    then if first element is 1
            return 2;
    else:
            return 1;

Now iterate over the list element and find out the
bucketIndex for each Element

BucketIndex:
```java
    public int findBucketIndex(int num, int N) {
    if(num >= 1 && num <= N) {
        return num - 1;
    } else {
        return -1;
    }
}
````

```java
for(int currentIndex = 0; currentIndex < N; currentIndex++) {
    if bucketIndex == -1:
    // Element value outside the range (1 to N):
    arr[currentIndex] = 0;

    else if bucketIndex == currentIndex:
    // Element at right postion
    skip
    else if arr[currentIndex] == arr[bucketIndex]:
        arr[currentIndex] = 0;

    else
        while(currentIndex != bucketIndex && bucketIndex != -1): {
            swap(arr, bucketIndex, currentIndex);
            bucketIndex = findBucketIndex(arr[bucketIndex], N);
        }

        if(bucketIndex == -1) {
            arr[currentIndex] = 0;
        }
}

/* Last iterate over the arr Element
        if you find 0:
            return i+1

   return N + 1; // All element at the Right Position
*/

for(int i=0; i<N; i++) {
    if(list.get(i) == 0) {
        missingInteger = i+1;
        return missingInteger;
    }
}
return N + 1;
```
