package string;

import java.util.ArrayList;

public class ValidIP {

  static boolean debug = true;

  public static void print2DList(ArrayList<ArrayList<String>> IP_List, boolean debug) {
    for (ArrayList<String> IP : IP_List) {
      if (debug == true) {
        System.out.println(IP.toString());
      }
    }
  }

  public static ArrayList<ArrayList<String>> getAllIPsFromString(String str, int start, int end) {

    if (str.length() == 2) {
      ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(2);
      ArrayList<String> tempList = new ArrayList<String>(2);
      String temp = "" + str.charAt(0);
      String temp2 = "" + str.charAt(1);

      tempList.add(temp);
      tempList.add(temp2);

      // Add [3,4]
      result.add(new ArrayList<String>(tempList));

      // Add [34]
      tempList = new ArrayList<String>();
      tempList.add(str);
      result.add(new ArrayList<String>(tempList));

      return result;
    }

    String substr = str.substring(start + 1, end);

    ArrayList<ArrayList<String>> IPList = getAllIPsFromString(substr, start, substr.length());
    String firstCharacter = "" + str.charAt(start);
    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>(2);

    // Add String in front of List
    for (ArrayList<String> IP : IPList) {
      ArrayList<String> temp = new ArrayList<String>(IP);
      temp.add(0, firstCharacter);
      ans.add(temp);
    }

    // At char to first element
    for (ArrayList<String> IP : IPList) {
      String address = IP.get(0);
      String concatenatedAddress = firstCharacter + address;
      IP.set(0, concatenatedAddress);
      ans.add(new ArrayList<String>(IP));
    }

    return ans;
  }

  public static int digits(int num) {
    int digits = 0;

    if (num == 0) {
      return 1;
    }

    while (num > 0) {
      ++digits;
      num = num / 10;
    }

    return digits;
  }

  public static boolean isAddressValid(String address) {
    boolean isValid = true;

    if (address.length() < 4) {
      int add = Integer.parseInt(address);

      // Padded with zero are invalid
      if (address.length() > digits(add)) {
        isValid = false;
      }

      // Not in Range
      if (add < 0 || add > 255) {
        isValid = false;
      }

    } else {
      isValid = false;
    }

    return isValid;
  }

  public static ArrayList<ArrayList<String>> filterValidIPs(ArrayList<ArrayList<String>> allIPS) {
    ArrayList<ArrayList<String>> filteredIPs = new ArrayList<ArrayList<String>>();

    for (ArrayList<String> IP : allIPS) {
      if (IP.size() == 4) {
        boolean isIPValid = true;

        for (String address : IP) {
          if (!isAddressValid(address)) {
            isIPValid = false;
            break;
          }
        }

        if (isIPValid) {
          filteredIPs.add(new ArrayList<String>(IP));
        }
      }
    }

    return filteredIPs;
  }

  public static ArrayList<String> restoreIpAddresses(String str) {
    ArrayList<String> result = new ArrayList<String>();
    int start = 0;
    int n = str.length();

    if (n > 3 && n < 13) {
      ArrayList<ArrayList<String>> allIPS = getAllIPsFromString(str, start, n);
      ArrayList<ArrayList<String>> validIps = filterValidIPs(allIPS);
      result = formatIPAddress(validIps);
    }

    return result;
  }

  public static ArrayList<String> formatIPAddress(ArrayList<ArrayList<String>> IPS) {
    ArrayList<String> ipList = new ArrayList<String>();

    for (ArrayList<String> IP : IPS) {
      String ipAddress = IP.get(0) + "." + IP.get(1) + "." + IP.get(2) + "." + IP.get(3);
      ipList.add(ipAddress);
    }

    return ipList;
  }

  public static void main(String args[]) {
    String str = "0002";
    System.out.print(restoreIpAddresses(str));
  }
}
