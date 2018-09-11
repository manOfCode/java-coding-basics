package com.shreeda.example.javabasiccoding;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isSplPalindrome("as"));

    }

    static boolean isSplPalindrome(String s) {
        int n = s.length();
        char ch = s.charAt(0);
        for (int i = 0; i < n/2+1; i++) {
            if (!((s.charAt(i) == ch) && (s.charAt(n-1-i) == s.charAt(i)))) {
                if (i == n-1-i) {
                    continue;
                }
                System.out.println("False");
                return false;
            }
        }
        System.out.println("True");
        return true;
    }
}
