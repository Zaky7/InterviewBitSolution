
# PseudoCode of Math Package Solution


1. Unique Grid Path[https://www.interviewbit.com/problems/grid-unique-paths/]

PseudoCode

Recursive:
Since robot can move either right(increment X) or down(increment Y)
so we can use recursion and iterate recursively or all possible solution.
Base case would be when we have X or Y greater than A, B;

See the Recursive Implementation it is illustrative.


Dp
Bottom Up Approach built and matrix and return the top left value.
Initialize the corner values with zero and destination with 1;

use below Formula
> `mat[i][j] = mat[i+1][j] + mat[i][j+1]`;


