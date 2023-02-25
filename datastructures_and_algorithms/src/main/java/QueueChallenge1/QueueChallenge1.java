package QueueChallenge1;
import java.util.LinkedList;

public class QueueChallenge1 {

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

        String lowerCase = string.toLowerCase();
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        // build a string with no spaces or other symbols
        for (int i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) >= 'a' && lowerCase.charAt(i) <= 'z') {
                // get the character
                char c = lowerCase.charAt(i);
                // push it onto the stack
                stack.push(c);
                // add to queue
                queue.addLast(c);
            }
        }
        while (!stack.isEmpty()) {
            // stack iterates the string from end to start and queue from start to end
            if (stack.pop() != queue.removeFirst()) {
                return false;
            }
        }
        return true;
    }
}
