/**
 * 058. Length of Last Word
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Created by Jiacheng on 2018/3/9.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s=s.trim();
        if ("".equals(s)) {
            return 0;
        }
        if ("".equals(s)) {
            return 0;
        }
        int index = s.lastIndexOf(" ");
        String lastWord = s.substring(index + 1);
        if ("".equals(lastWord)) {
            lastWord = s.substring(0, index);
        }
        return lastWord.length();
        //return s.trim().length()-s.trim().lastIndexOf(" ")-1; //excellent solution
    }

    public static void main(String[] args) {
        String s = "  ";
        int solution = new LengthOfLastWord().lengthOfLastWord(s);
        System.out.println("solution is " + solution);
    }
}
