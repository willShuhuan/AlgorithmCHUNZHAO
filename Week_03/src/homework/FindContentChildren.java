package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #455 分发饼干
 * 亚马逊
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2,3};//孩子胃口值
        int[] s = {1,1};//饼干
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0,j = 0; i < g.length&&j<s.length; i++,j++) {
            while (j<s.length && g[i]>s[j]){
                j++;
            }
            if (j<s.length){
                count++;
            }
        }
        return count;
    }
}
