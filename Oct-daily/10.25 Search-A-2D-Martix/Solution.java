class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        // 找到之后直接返回
        if (matrix[i][j] == target)
          return true;
      }
    }
    return false;
  }
  public boolean searchMatrix2(int[][] matrix, int target) {
    //一行一行的使用二分法查找
    for (int[] row : matrix) {
        int index = search(row, target);
        //找到解返回
        if (index >= 0)
            return true;
    }
    return false;
  }
  //二分法查找
  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int num = nums[mid];
        if (num == target) {//找到直接返回
            return mid;
        } else if (num > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ~low;
  }

  public boolean searchMatrix3(int[][] matrix, int target) {
      //从矩阵右上角开始搜索
      int col = matrix[0].length - 1;//列
      int row = 0;//行

      while (col >= 0 && row <= matrix.length - 1) {
          if (target == matrix[row][col]) {
              //如果找到就直接返回
              return true;
          } else if (target < matrix[row][col]) {
              //如果查找的值大了，下一步往左找
              col--;
          } else if (target > matrix[row][col]) {
              //如果查找的值小了，下一步往下找
              row++;
          }
      }
      return false;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
  }
}

