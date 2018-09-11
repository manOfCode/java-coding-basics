package com.shreeda.example.javabasiccoding;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MyTrie {
    TrieNode root;
    private class TrieNode {
        public TrieNode[] children = new TrieNode[26];

        public boolean isEndOfAWord = false;

        public TrieNode(char a) {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public MyTrie() {
        this.root = new TrieNode(' ');
    }

    public void add(String s) {
        TrieNode iter = root;
        TrieNode lastNode = null;
        for (char ch : s.toCharArray()) {
            if (iter.children[ch-'a'] == null) {
                iter.children[ch-'a'] = new TrieNode(ch);
                System.out.println("creating node for " + ch);
            }
            lastNode = iter;
            iter = iter.children[ch-'a'];
        }
        iter.isEndOfAWord = true;

    }

    public int getCount(String s) {
        TrieNode iter = root;
        for (char ch : s.toCharArray()) {
            if (iter.children[ch-'a'] == null) {
                return 0;
            }
            iter = iter.children[ch-'a'];
        }
        int counter = 0;
        if (iter.isEndOfAWord) {
            counter++;
        }

        counter+=countWords(iter);
        return counter;
    }

    private int countWords(TrieNode iter) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (iter.children[i] == null) {
                continue;
            } else {
                if (iter.children[i].isEndOfAWord) {
                    count++;
                }
                count+=countWords(iter.children[i]);
            }
        }
        return count;
    }
}

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        MyTrie myTrie = new MyTrie();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            if (op.equals("add")) {
                myTrie.add(contact);
            } else if (op.equals("find")) {
                System.out.println(myTrie.getCount(contact));
            }
        }

        scanner.close();
    }
}
