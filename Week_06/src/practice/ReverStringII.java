package practice;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 541. 反转字符串ii
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

    //题解 https://leetcode-cn.com/problems/reverse-string-ii/solution/fan-zhuan-zi-fu-chuan-ii-by-leetcode/
    public static String reverseStr(String s,int k) {
        if (s==null||s.length()==0) return "";
        char[] cs = s.toCharArray();
        for (int start = 0; start < cs.length; start += 2*k) {
            int i = start,j = Math.min(start+k-1,cs.length-1);
            while (i<j){
                char tmp = cs[i];
                cs[i++] = cs[j];
                cs[j--] = tmp;
            }
        }
        return new String(cs);
    }
}
