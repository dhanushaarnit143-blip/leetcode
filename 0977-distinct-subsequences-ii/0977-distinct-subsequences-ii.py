class Solution:
    def distinctSubseqII(self, s):
        MOD = 10**9 + 7
        dp = [0] * 26
        total = 0
        
        for char in s:
            idx = ord(char) - ord('a')
           
            new_val = (total + 1) % MOD
            
            total = (total + new_val - dp[idx]) % MOD
            
            dp[idx] = new_val
            
        return total % MOD