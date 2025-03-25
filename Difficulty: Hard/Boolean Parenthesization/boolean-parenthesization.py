#User function Template for python3
class Solution:
    def countWays(self, s):
        # code here
        dp = [[[0, 0] for i in range(len(s))] for j in range(len(s))]
        
        for i in range(0, len(s), 2):
            ind = 1 if s[i] == 'T' else 0
            dp[i][i][ind] += 1 
        
        for i in range(2, len(s), 2):
            for j in range(0, len(s) - i, 2):
                st = j
                e = j + i
                for k in range(st + 1, e + 1, 2):
                    for l in range(2):
                        for m in range(2):
                            if s[k] == '&':
                                ind = l & m
                            elif s[k] == '^':
                                ind = l ^ m
                            elif s[k] == '|':
                                ind = l | m

                            dp[st][e][ind] += dp[st][k-1][l] * dp[k+1][e][m]
                            
        return dp[0][len(s)-1][1]

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        s = input().strip()
        print(Solution().countWays(s))
        print("~")

# } Driver Code Ends