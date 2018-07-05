/**
 * 1、获取两个字符串中最大相同子串
 * 2、对一个字符串的处理，将多余的空格去除；例如输入string data = "    a  bcd e     ffff     "，返回" a bcd e ffff "
 * <p>
 * Created by Jiacheng on 2018/7/4.
 */
public class MaxSubString {

    public static String getMaxsubstring(String s1, String s2) {
        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                String temp = min.substring(j, k);
                //System.out.println("temp--:"+temp);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }

    public static StringBuffer deleteBlank(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                stringBuffer.append(string.charAt(i));
                continue;
            }
            if (i + 1 < string.length() && string.charAt(i) == ' ' && string.charAt(i + 1) != ' ' && !"".equals(String.valueOf(stringBuffer))) {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer;
    }

    public static StringBuffer deleteBlank2(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        string = string.trim();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                stringBuffer.append(string.charAt(i));
                continue;
            }
            if (i + 1 < string.length() && string.charAt(i) == ' ' && string.charAt(i + 1) != ' ') {
                stringBuffer.append(' ');
            }

        }
        return stringBuffer;
    }

    public static void main(String[] args) {
        System.out.println(MaxSubString.getMaxsubstring("abcdefghij", "34cdefgff"));
        System.out.println(deleteBlank("   a  bcd e     ffff    "));
        System.out.println(deleteBlank2("   a  bcd e     ffff    "));
    }
}
