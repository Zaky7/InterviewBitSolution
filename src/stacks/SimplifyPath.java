package stacks;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String simplifiedPath = simplifyPath("/a/./b/../../c/");
        System.out.println(simplifiedPath);
    }

    public static boolean isAlphabet(String name) {
        if (name.trim().equals("")) {
            return false;
        }
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static String simplifyPath(String str) {
        String[] strArray = str.split("/");
        Stack<String> s = new Stack<String>();

        for (String st : strArray) {
            if (st.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else if (isAlphabet(st)) {
                s.push(st);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            String temp = s.pop();
            sb.insert(0, temp);
            sb.insert(0, "/");
        }

        if (sb.toString().equals("")) {
            sb.append("/");
        }

        return sb.toString();
    }
}