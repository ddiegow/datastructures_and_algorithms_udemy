package StackChallenge1;

import java.util.LinkedList;

public class StackChallenge1 {
    private static class Stack {
        private LinkedList<Character> stack;

        public Stack() {
            stack = new LinkedList<>();
        }

        public void push(Character s) {
            stack.push(s);
        }
        public Character pop() {
            return stack.pop();
        }
        public int size() {
            return stack.size();
        }
        public boolean isEmpty() { return stack.isEmpty(); }
    }
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        int i;
        Stack stack = new Stack();
        String lowerCase = string.toLowerCase();
        StringBuilder noSymbols = new StringBuilder();
        // build a string with no spaces or other symbols
        for (i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) >= 'a' && lowerCase.charAt(i) <= 'z') {
                noSymbols.append(lowerCase.charAt(i));
                stack.push(lowerCase.charAt(i));
            }
        }
        // create a reversed string
        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        // if the original string and its reverse are equal, it's a palindrome
        return noSymbols.toString().equals(reversedString.toString());
    }
}
