/**
 * 344. Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * <p>
 * Created by Jiacheng on 2018/3/13.
 */
public class ReverseString {

    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        String s = "";
        String solution = new ReverseString().reverseString(s);
        System.out.println("Solution is " + solution);
    }
}
