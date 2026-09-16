class Solution:
    def numberOfSets(self, n, k):
        MOD = 10**9 + 7
        N = n + k - 1
        R = 2 * k
        
        num = 1
        den = 1
        for i in range(R):
            num = (num * (N - i)) % MOD
            den = (den * (i + 1)) % MOD
            
        return (num * pow(den, MOD - 2, MOD)) % MOD