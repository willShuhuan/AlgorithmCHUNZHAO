package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/22
 * @description #88 合并两个有序数组
 */
public class MergeSortArray {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        int m = 3;
//        int n = 3;
//        merge(nums1,m,nums2,n);
//        int[] nums1 = {0,0,3,0,0,0,0,0,0};
//        int[] nums2 = {-1,1,1,1,2,3};
//        int m = 3;
//        int n = 6;
//        merge2(nums1,m,nums2,n);
        int[] nums1 = {2,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3;
        int n = 3;
        merge3(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    //方法1 System.arraycopy 这个太赖了
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    //方法2 先合并 再排序
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //方法3  临时数组加双指针 (最优解)
    private static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        int cur;
        int p1=0,p2=0;
        while (p1<m||p2<n){
            if (p1==m){
                cur = nums2[p2++];//当nums1数组到达边界时，从nums2数组中逐一取值
            }else if(p2==n){
                cur = nums1[p1++]; //当nums2数组到达边界时，从nums1数组中逐一取值
            } else if(nums1[p1]<nums2[p2]){//
                cur = nums1[p1++];
            }else{
                cur = nums2[p2++];
            }
            newArr[p1+p2-1]=cur;
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = newArr[i];
        }
    }

}
