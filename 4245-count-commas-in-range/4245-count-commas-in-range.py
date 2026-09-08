class Solution(object):
    def countCommas(self, n):
        ans = 0
        limit = 999
        while limit <= n:
            ans += n - limit
            limit = limit * 1000 + 999
            
        return ans