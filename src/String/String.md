

# Count And 

* For a Value of n Recursively move to n - 1 till n = 3
* Now 
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


       