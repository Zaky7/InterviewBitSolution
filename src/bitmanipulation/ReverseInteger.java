import java.io.*;

// Run cmd: javac .\ReverseInteger.java ; java ReverseInteger
class ReverseInteger {

  public static boolean isCurrentBitSet(int n) {
    return (n & 1) != 0;
  }

  public static int setCurrentBit(int n, int pos) {
    return n | (1 << pos);
  }

  public static String toBinaryString(int n) {
    return String.format("%32s", Integer.toBinaryString(n)).replaceAll(" ", "0");
  }

  public static int reverseBits(int n) {
    int pos = Integer.SIZE - 1;
    int reverse = 0;

    while (pos >= 0 && n != 0) {
      // if current bit is 1, then set corresponding bit in result
      if (isCurrentBitSet(n)) {
        reverse = setCurrentBit(reverse, pos);
      }

      n >>= 1; // drop current bit (divide by 2)
      pos--; // decrement shift by 1
    }

    return reverse;
  }

  public static void main(String[] args) {
    int n = 4;
    System.out.println(n + " in binary is " + toBinaryString(n));
    System.out.println("On reversing bits " + toBinaryString(reverseBits(n)));
  }
}