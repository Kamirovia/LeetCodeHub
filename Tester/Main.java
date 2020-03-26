import java.util.*;

public class Main {
    public static void main(String[] args) {
        uniMap();
    }

    // 使用桶排序算法改良，完成去重、排序
    public static void BucketSort(int Max) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] nums = new int[Max + 1];
            int count = in.nextInt();
            for (int i = 0; i < count; i++) {
                nums[in.nextInt()] += 1;

            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0)
                    System.out.println(i);
            }
        }
        in.close();
    }

    /**
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 
     * 遍历前后，Hash去重
     * 
     * @param Max
     */
    public static void getUniNum() {
        Scanner in = new Scanner(System.in);
        String rawStr = in.nextLine();

        // 从低位高位获取每一个位的数字。
        String result = "";
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.keySet().toArray();
        int t;
        for (int i = rawStr.length() - 1; i > -1; i--) {
            t = Integer.valueOf(rawStr.charAt(i) + "");
            if (result.length() > 10)
                break;
            if (!map.containsKey(t) && 0 <= t && t <= 9) {
                result += t;
                map.put(t, i);
            }
        }

        System.out.println(Integer.valueOf(result));

        in.close();
    }

    public static void uniMap() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key, value;
        while (count > 0) {
            key = in.nextInt();
            value = in.nextInt();
            if (map.containsKey(key))
                value += map.get(key);
            map.put(key, value);
            count--;
        }
        in.close();

        List<Integer> keysList = new LinkedList<>(map.keySet());
        Collections.sort(keysList);

        for (int i = 0; i < keysList.size(); i++) {
            System.out.println(keysList.get(i) + " " + map.get(keysList.get(i)));
        }

    }



    void Encrypt (char aucPassword[], char aucResult[]){
        for (int i=0; i< aucPassword.length; i++)
        {
            if ('a'<= aucPassword[i] && aucPassword[i] < 'z') {
                aucResult[i] = (char)('B' -'a' + aucPassword[i]);
            } else if (aucPassword[i] == 'z') {
                aucResult[i] = 'A';              
            } else if ('A'<= aucPassword[i] && aucPassword[i] < 'Z') {
                aucResult[i] = (char)('B' -'a' + aucPassword[i]);

            }  else if (aucPassword[i] == 'Z') {
                aucResult[i] = 'a';              
            } else if ('0' <= aucPassword[i] && aucPassword[i] < '9') {
                aucResult[i] =(char)(aucPassword[i] + 1);

            } else if (aucPassword[i] == '9') {
                aucResult[i] = '0';
            }
        }
        
    }
    
    int unEncrypt (char result[], char password[]){
        return 0;
    }

}