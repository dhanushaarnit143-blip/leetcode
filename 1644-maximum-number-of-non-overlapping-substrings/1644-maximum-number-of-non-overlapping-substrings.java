class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        java.util.Arrays.fill(first, -1);
        java.util.Arrays.fill(last, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        
        java.util.List<int[]> validSubstrings = new java.util.ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            int L = first[i];
            int R = last[i];
            int j = L;
            while (j <= R) {
                int c = s.charAt(j) - 'a';
                if (first[c] < L || last[c] > R) {
                    L = Math.min(L, first[c]);
                    R = Math.max(R, last[c]);
                    j = L; 
                } else {
                    j++;
                }
            }
            validSubstrings.add(new int[]{L, R});
        }
        
        validSubstrings.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });
        
        java.util.List<String> ans = new java.util.ArrayList<>();
        int lastEnd = -1;
        for (int[] sub : validSubstrings) {
            if (sub[0] > lastEnd) {
                ans.add(s.substring(sub[0], sub[1] + 1));
                lastEnd = sub[1];
            }
        }
        
        return ans;
    }
}