// Link: https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
          maxLen = Math.max(maxLen, ++f[s.charAt(end) - 'A']);
          if (end - start + 1 > maxLen + k) {
            f[s.charAt(start) - 'A']--;
            start++;
          }
        }
        return s.length() - start;
    }
}
