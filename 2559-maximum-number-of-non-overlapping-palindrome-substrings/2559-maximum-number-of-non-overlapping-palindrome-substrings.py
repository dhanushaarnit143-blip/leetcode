class Solution:
    def maxPalindromes(self, s, k):
        n = len(s)
        count = 0
        i = 0
        
        while i <= n - k:
            if s[i:i+k] == s[i:i+k][::-1]:
                count += 1
                i += k
                continue
                
            if i <= n - (k + 1) and s[i:i+k+1] == s[i:i+k+1][::-1]:
                count += 1
                i += k + 1
                continue
                
            i += 1
            
        return count