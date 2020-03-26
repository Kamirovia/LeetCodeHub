import java.util.Arrays;

public class Fun {
    public static void main(String[] args) {

        System.out.println(letterFrequency("123456780"));
        System.out.println(letterFrequency("12345678abcdefgokjjkkkkk0"));
        System.out.println(letterFrequency("12345678abcdefgokjjkkkkk0"));
        System.out.println(letterFrequency("12345678abcdefgokjjkkkkk0"));

    }

    public static int fun(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        return fun(n - 1) + fun(n - 2);
    }

    /**
     * 给定一个任意长度的字符串，计算出现最多字母的频次，区分大小写
     * 
     * @param src
     * @return 重复频次最高的字母的次数
     */
    public static int letterFrequency(String src) {
        // 依次记录每一个出现的字母的次数
        // 索引0 ~ 25 表示a-z出现的次数
        // 索引26 ~ 51 表示A-Z出现的次数
        int[] letterTable = new int[52];
        char ch;
        for (int i = 0; i < src.length(); i++) {
            ch = src.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                letterTable[(ch - 'a')]++;

            } else if ('A' <= ch && ch <= 'Z') {
                letterTable[(ch - 'A') + 26]++;
            }
        }

        // 搜索出频次最大值
        Arrays.sort(letterTable);

        return letterTable[51];
    }

    /**
     * 顺序求解
     * 
     * @param n
     * @return
     */
    public static int fun2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int result = 1;
        int pre = 1;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = result;
            result = pre + result;
            pre = temp;
        }
        return result;

    }

}