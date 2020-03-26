import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxNum = 10000;
        BigDecimal targetPrice = in.nextBigDecimal();
        int num = 0;
        BigDecimal sum;
        // 用于存取结果，key：台数， Value为总价
        HashMap<Integer, Double> map = new HashMap<Integer,Double>();
        for (int i = 1; i < maxNum + 1; i++) {
            sum = targetPrice.multiply(new BigDecimal(i));
            sum.
            if (sum % 1 == 0) {
                map.put(i, sum);
            }
        }
        // 获取小数部分
        double tail = targetPrice % 1;
        if (tail * 10000)

        if()
        {

        }
        in.close();

    }
}