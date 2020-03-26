import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 获取输入参数；
            String s = in.nextLine();
            if (s != null && s.length() > 0 && s.length() < 101) {
                String[] strs = s.split(",");
                if (strs.length == 0) {
                    System.out.println(s);
                    return;
                }
                int[] weight = new int[strs.length];
                // 解析获取最后一个字符作为
                for (int i = 0; i < strs.length; i++) {
                    char c = strs[i].charAt(strs[i].length() - 1);
                    weight[i] = (int) c;
                }

                // 找一个稳定排序，比如冒泡排序
                int temp = -1;
                String ts = "";
                for (int i = 0; i < weight.length - 1; i++) {
                    for (int j = 0; j < weight.length - 1 - i; j++) {
                        if (weight[j] > weight[j + 1]) {
                            temp = weight[j];
                            weight[j] = weight[j + 1];
                            weight[j + 1] = temp;

                            // strs 同时做替换
                            ts = strs[j];
                            strs[j] = strs[j + 1];
                            strs[j + 1] = ts;

                        }
                    }
                }

                String result = "";
                for (int i = strs.length - 1; i > 0; i--) {
                    result += strs[i] + ',';
                }
                result += strs[0];
                System.out.println(result);

            } 
            break;
        }

        in.close();

    }
}