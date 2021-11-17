package ru.imit.omsu;

import java.util.Stack;

public class StringProcessor {
    public static String copystring(String s, int N) {
        if (N < 0) throw new IllegalArgumentException("number of copies  can't be negative");

        StringBuilder str = new StringBuilder("");

        if (N == 0) return ("");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < s.length(); j++) {
                str.append(s.charAt(j));
            }
        }
        return new String(str);
    }

    public static int stringinsideanother(String n, String m) {
        if (m.isEmpty()) throw new IllegalArgumentException("second string is empty");
        if (m.length() == 0) throw new IllegalArgumentException("second string is null");
        String p = n.replace(m, "");
        int count = (n.length() - p.length()) / m.length();
        return count;
    }

    public static String stringrecreatenumbers(String s) {
        String a = s.replace("1", "один");
        String b = a.replace("2", "два");
        String c = b.replace("3", "три");

        return new String(c);
    }

    public static String deletesymbol2(StringBuilder s) {
        for (int i = 1; i <= s.length(); i += 1) {
            s.deleteCharAt(i);
        }
        return s.toString();

    }

    public static String swapWordsstring(String s) {
        if (s.isEmpty())
            return s;
        return swapWordsstring(s.substring(1)) + s.charAt(0);
    }

    public static long hexadecimalNumber(Stack<Character> number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        long result = 0;
        int rank = 0;
        char symbol = 0;
        while (!(number.isEmpty())) {
            symbol = number.pop();
            if (symbol >= 48 && symbol <= 57) {
                result += (symbol - 48) * Math.pow(16, rank);
            } else if (symbol >= 65 && symbol <= 70) {
                result += (symbol - 55) * Math.pow(16, rank);
            } else {
                throw new IllegalArgumentException("This stack hasn't a hexadecimal number");
            }
            rank++;
        }
        return result;
    }

    public static String replaceHexadecimalNumbers(String str) {
        if (str == null) {
            throw new NullPointerException("The string is null");
        }
        Stack<Character> number = new Stack<>();
        int i = 0;
        int left = 0;
        int right = 0;
        long result = 0;
        StringBuilder replacer = new StringBuilder(str);
        while (i < replacer.length()) {
            left = replacer.indexOf("0x");
            if (left == -1) {
                break;
            } else {
                left += 2;
                right = left;
                while (right != left + 8 && right != replacer.length()) {
                    number.push(replacer.charAt(right));
                    right++;
                }
                result = hexadecimalNumber(number);
                left -= 2;
                replacer.delete(left, right);
                replacer.insert(left, result);
                String letter = Long.toString(result);
                i = left + letter.length() - 1;
            }
            i++;
        }
        return new String(replacer);
    }

}