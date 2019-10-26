# 1. Count And Say

- For a Value of n Recursively move to n - 1 till n = 3
- Now
  if n == 1 return '1'
  elif n == 2 return '11'
  else

        Now Function would return '11' we need to Generate next Sequence from it
        and so on.

        Split the String into Characters
        Take a variable currentElementCount = 1;
        Now for splitted String Iterate over the Characters from i = 0 to n - 1
        Take two variable

            currentElement = str.charAt(i);
            nextElement = str.charAt(i+1);

            if currentElement == nextElement:
               increase the Count
            else:

              append CountVariable as String to result
              and also append the currentElement
              Also reset the Count Variable to 1 for next Element

        Now append the countVariable Value
        Also append the currentElement Value
        return Result


        ```java
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
        ```

## 2. Longest Pallindromic Substring

### 1. Naive Solution O(N^3)

Idea:
(We can reduce the problem into **finding the common substring between the original String and its reverseVersion**. If a substring is a Palindrome it must be present in both the strings.

There is one caveat!!!, there can be a **reverse copy of a non-Palindromic sub-string** in some other part of the Original String. Therefore To rectify this, each time we find a longest common substring candidate we check substring indices are same as reversed substring ORIGINAL Indices.(If don't understand no problem :) I will walk you through it)

for eg.

```
S = “abacdfgdcaba”
S’ = “abacdgfdcaba”
```

common substring is abacd which is not the Palindrome. How I know it?.

Substring="abacd" index in S => (0, 4) {start1Index: 0, end1Index: 4} <br>
Substring="abacd" index in S' => (0, 4) {start2Index: 0, end2Index: 4} <br>

Now index in reverse String: <br>
originalStart2Index = (n - 1) - end2Index => (12 - 1) - 4 => 7; <br>
originalEnd2Index = (n - 1) - start2Index => (12 - 1) - 0 => 11;

Clearly
start1Index != originalStart2Index && end1Index != originalEnd2Index:
therefore it is not the Pallindrome !!

### Pseudocode O(N^3):

```
- Generate all the Substring of a given string and check if it is present in
  the reverse Substring S'.
- If it present:
     then check the indices as described above:
        if they are same then:
            if substring.length() > longsubstring.length():
                 longestSubstring = substring;

```

### 2. Dynamic Programming Solution O(N^2) Space O(N^2)

Idea: if aba is a Palindrome and if we add a on both size then aabaa is also pallindrome.

[If you create an Array of Int it would consume more memory]

- Create a 2D Boolean table of size n \* n
- Now we have to fill the table in such a way
  that if element from Index 0 to 2 is a Palindrome
  then table[0][2] = true

- Since all the Elements of length 1 are Palindrome
  there for table[i][i] = true;

- For elements of length two if str[i]=str[i+1] then
  they are Palindrome.

- for all the elements of Length greater than 2
  if str[i]=str[j] and table[i+1][j-1] = true then
  it is Pallindrome. It happens because if aba is
  Palindrome then abaa is also a Palindrome.

## 3. Valid IP Address

### Pseudocode

- Generate all the IP Address using Recursion.
- Now Filter the IP Address which have number of
  Address not equal to 4.(for eg. 100.0.0.00.000)
- Also those address which have each address out
  of range (0-255) and having preceding zeros are
  not valid Address.

[We have refactor the code in order to use less variables and functions]
