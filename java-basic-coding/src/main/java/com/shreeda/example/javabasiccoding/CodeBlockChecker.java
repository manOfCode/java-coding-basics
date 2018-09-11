package com.shreeda.example.javabasiccoding;

import java.util.*;

class CodeBlockChecker {

    public static void main(String[] argh) {
        Map<Character, Character> mapper = new HashMap<Character, Character>();
        Scanner sc = new Scanner(System.in);
        mapper.put('{', '}');
        mapper.put('(', ')');
        mapper.put('[', ']');

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            int len = input.length();
            if (len % 2 != 0) {
                System.out.println("false");
                continue;
            }
            boolean notPrinted = true;
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < len; i++) {
                if (input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                } else if (input.charAt(i) == '}' || input.charAt(i) == ')' || input.charAt(i) == ']') {
                    //System.out.println(input.charAt(i) + " " + stack.peek());
                    if (stack.size() == 0) {
                        System.out.println("false");
                        notPrinted = false;
                        break;
                    }
                    char character = stack.pop();
                    if (mapper.get(character) != input.charAt(i)) {
                        System.out.println("false");
                        notPrinted = false;
                        break;
                    }
                }
            }
            if (notPrinted && stack.size() == 0) {
                System.out.println("true");
            } else if (notPrinted) {
                System.out.println("false");
            }
        }

    }
}




