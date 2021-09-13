class Solution {
  public int maxNumberOfBalloons(String text) {
    int b = 0;
    int a = 0;
    int l = 0;
    int o = 0;
    int n = 0;
    String[] textList = text.split("");

    for (int i = 0; i < textList.length; i++) {
      if (textList[i].equals("b")) {
        b++;
      } else if (textList[i].equals("a")) {
        a++;
      } else if (textList[i].equals("l")) {
        l++;
      } else if (textList[i].equals("o")) {
        o++;
      } else if (textList[i].equals("n")) {
        n++;
      }

    }
    int maxNum = 0;
    while (b > 0 && a > 0 && l > 1 && o > 1 && n > 0) {
      maxNum++;
      b--;
      a--;
      l = l - 2;
      o = o - 2;
      n--;
    }
    return maxNum;

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("Solution: " + solution.maxNumberOfBalloons("nlaebolko"));
  }

}