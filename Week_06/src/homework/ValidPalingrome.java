package homework;

/**
 * @author DSH
 * @date 2021/3/12
 * @description #680 验证回文字符串2
 * facebook
 */
public class ValidPalingrome {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }

    //方法一 贪心求解  7ms
    public static boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if (s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else {
                return palindrome(s,low+1,high)||palindrome(s,low,high-1);
            }
        }
        return true;
    }

    private static boolean palindrome(String s, int low, int high) {
        for (int i = low,j=high; i < j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

}
