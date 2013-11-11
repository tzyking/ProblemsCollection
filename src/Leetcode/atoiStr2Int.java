package Leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: JT026354
 * Date: 11/10/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class atoiStr2Int {
    public static int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (str.equals("")) return 0;

        char[] arrStr = str.toCharArray();
        int i = 0;
        int ret = 0;
        boolean isNegative = false;
        while(arrStr[i] == ' ')
            i++;

        if(arrStr[i] == '-') {
            isNegative = true;
            i++;
        } else if (arrStr[i] == '+') {
            isNegative = false;
            i++;
        }

        while (i < arrStr.length && arrStr[i] >= 48 && arrStr[i] <= 57) {
            if (Integer.MAX_VALUE / 10 < ret)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ret = ret * 10;

            if(Integer.MAX_VALUE - (arrStr[i] - '0') < ret)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ret = ret + arrStr[i] - '0';
            i++;
        }

        return isNegative ? ret * -1 : ret;
    }

    public static void main(String[] args) {
        System.out.println(atoiStr2Int.atoi("1"));

    }
}
