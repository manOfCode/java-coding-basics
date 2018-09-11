package com.shreeda.example.javabasiccoding;

public class RemoveDuplicates {

    public static void removeDuplicates(char[] str) {
        if (str == null) {
            return;
        }
        int len = str.length;
        if (len < 2) {
            return;
        }
        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j)
                if (str[i] == str[j]) {
                    break;
                }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    public static void removeDuplicatesEff(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; ++i) {
            hit[i] = false;
        }
        hit[str[0]] = true;

        for (int i = 1; i < len; ++i) {
            if (!hit[str[i]]) {
                hit[str[i]] = true;
                continue;
            }
            str[i] = 0;
        }

    }

    public static void main(String[] args) {
        String s = "helloiloveyou";
        char[] arr = s.toCharArray();
        removeDuplicatesEff(arr);
        System.out.println(String.valueOf(arr));
    }

}
