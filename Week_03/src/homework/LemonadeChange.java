package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #860 柠檬水找零
 * 亚马逊
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }

    //贪心算法
    public static boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill==5){
                five++;
            }else if (bill==10){
                if (five<=0){
                    return false;
                }
                five--;
                ten++;
            }else {
                if(five==0) {
                    return false;
                } else if (ten>0){
                    ten--;
                    five--;
                } else if (five>=3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
