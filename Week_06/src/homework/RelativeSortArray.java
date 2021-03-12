package homework;

import java.util.*;

/**
 * @author DSH
 * @date 2021/3/12
 * @description #1122 数组的相对排序
 * 谷歌
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    //方法1  自定义比较函数
    //todo  整明白咋回事
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (Integer num:arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1)||map.containsKey(o2)) return map.getOrDefault(o1,1001)-map.getOrDefault(o2,1001);
                return o1-o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

}
