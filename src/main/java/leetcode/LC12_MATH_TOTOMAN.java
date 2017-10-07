package leetcode;

/**
 * Created by yu on 17-10-1.
 */
public class LC12_MATH_TOTOMAN {

    public String intToRoman(int num) {
        //***很直接得想法，把3999内的千位数，百位数、十位数、个位数分别表达出来，参考自九章
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];

    }
}
