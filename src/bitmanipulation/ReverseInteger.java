package bitmanipulation;



// Explaination [https://stackoverflow.com/questions/38670747/reverse-bits-in-java-on]

class ReverseInteger {

  public static String toBinaryString(long n) {
    return String.format("%64s", Long.toBinaryString(n)).replaceAll(" ", "0");
  }

  public static void main(String[] args) {
    long n = 3;
    long result = reverse(n);
    System.out.println(n + " in binary is " + toBinaryString(result) + " Value: " + result);
  }

  public static long reverse(long a) {
    long result = 0;
    int i = 31;

    while (a > 0) {
      // Calculating the last bit
      long remainder = (a % 2);
      // Now left shift by i position
      remainder = remainder << i;
      // Add to the result thus shifting the rightmost bit to i postion left
      result += remainder;
      // Decrement the i
      i--;
      // Right shift 1 for new bit
      a = a >> 1;
    }

    return result;
  }

}