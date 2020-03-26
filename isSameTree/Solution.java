import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        // 排序
        // 递归生成子集
        if (num.length < 2) return new ArrayList<>();
        if (num.length == 2) return List.of(nums[0], nums[1]);
        // 包含x。不包含x，x属于任意一个
        return  ;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> sub = findSubsequences(nums);
        for (List<Integer> s : sub) {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s.get(i) + " ");
            }
            System.out.println("");
        }
    }
    
}