/**
 * 125. Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,"A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:Have you consider that the string might be empty?
 * This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Created by Jiacheng on 2018/3/11.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean solution = new ValidPalindrome().isPalindrome(s);
        System.out.println("solution is " + solution);
    }
}
