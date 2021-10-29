class Solution {
  static Set<Integer> set = new HashSet<>();
  static {
    for (int i = 1; i < (int) 1e9 + 10; i *= 2)
      set.add(i);
  }
  int m;
  int[] cnts = new int[10];

  public boolean reorderedPowerOf2(int n) {
    while (n != 0) {
      cnts[n % 10]++;
      n /= 10;
      m++;
    }
    return dfs(0, 0);
  }

  boolean dfs(int u, int cur) {
    if (u == m)
      return set.contains(cur);
    for (int i = 0; i < 10; i++) {
      if (cnts[i] != 0) {
        cnts[i]--;
        if ((i != 0 || cur != 0) && dfs(u + 1, cur * 10 + i))
          return true;
        cnts[i]++;
      }
    }
    return false;
  }
}