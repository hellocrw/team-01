package my.study.demo.leetcode;

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划
// 👍 1189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(arr);
        System.out.println("result"+i);
    }
    public static int lengthOfLIS(int[] nums) {
        int[][] arr = new int[nums.length+1][nums.length+1];
        if (nums.length == 1){
            return 1;
        }
        for (int i = 0; i <= nums.length; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = nums[i-1] > nums[j-1] ? arr[j][j] + 1 : Math.max(arr[i][j-1], arr[i-1][j]);
                System.out.println(arr[i][j]);
            }
        }
        return arr[nums.length][nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

