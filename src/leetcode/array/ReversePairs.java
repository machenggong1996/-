package leetcode.array;

/**
 * @author machenggong
 * @date 2020/04/24
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) >> 1;
        //将归并的所有结果汇总返回
        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        int res[] = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                count += mid - i + 1;//如果j位置小于i位置，那么j位置小于i位置后所有的左半边的数
            }
            res[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            res[k++] = nums[i++];
        }
        while (j <= right) {
            res[k++] = nums[j++];
        }
        for (int m = 0; m < res.length; m++) {
            nums[left + m] = res[m];
        }
        return count;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[] { 7, 5, 6, 4 }));
    }

}
