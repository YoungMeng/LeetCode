class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) <= 1:
            return s
        res = ''
        for i in range(0, len(s)):
            palindrome = self.getPalindromicStr(s, i, i)
            if len(palindrome) > len(res):
                res = palindrome

            palindrome = self.getPalindromicStr(s, i, i + 1)
            if len(palindrome) > len(res):
                res = palindrome
        return res

    def getPalindromicStr(self, s, start, end):
        while(start >= 0 and end < len(s) and s[start] == s[end]):
            start -= 1
            end += 1
        return s[start + 1 : end]
