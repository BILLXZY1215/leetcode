class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(nums1[i], i);
    }
    int[] ans = new int[n];
    for (int i = 0; i < m; i++) {
      if (map.containsKey(nums2[i])) {
        int j = i + 1;
        while (j < m && nums2[j] <= nums2[i]) {
          j++;
        }
        ans[map.get(nums2[i])] = j >= m ? -1 : nums2[j];
      }
    }
    return ans;
  }
}