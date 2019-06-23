package Arrays;

/*
* PseudoCode
1. Take a number num = 2
2. Increment num till it is less than square root of the A(given)

for num = 2 ; num < sqrt(A); num++:
	if(A % num) == 0:
	   Then check if num when repeatedly divides A lead to 1
	   and store the value in a counter name iterator
	   if Iterator value is greater than 1 then:
	   	return True
	   else check for another value
/* Indicating no number Found
return false;
*
* */

public class PowerOfTwoInteger {

    public int isPower(int A) {


        if(A == 1) { return 1; }

        if(A>1 && A <= 3) {
            return 0;
        }

        int squareRoot = (int) Math.sqrt(A);

        for(int i=2; i<=squareRoot; i++) {
            int num = i;
            if(A % num == 0) {
                int power = 0;
                int temp  = A;

                while(temp > 1 && (temp % num == 0)) {
                    // System.out.println("Temp: " + temp + " Num: " + num);
                    temp/=num;
                    ++power;
                }

                if(power > 1 && temp == 1) {
                    // System.out.println("Num: " + num + " Power: " + power);
                    return 1;
                }
            }
        }

        return 0;
    }
}
