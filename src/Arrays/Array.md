# PseudoCode of Array Package Solution


## Flip[https://www.interviewbit.com/problems/flip/]

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
    maxSum < 0:
       return [];

    else:
      return [leftAns+1, rightAns+1];



