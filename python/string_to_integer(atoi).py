class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        if len(str) == 0:
            return 0

        INT_MAX = 2147483647
        INT_MIN = -2147483648
        i = 0
        sign = 1
        sum = 0
        while i < len(str) and str[i].isspace():
            i += 1
        if i < len(str) and str[i] == "-":
            sign = -1
            i += 1
        elif i < len(str) and str[i] == "+":
            i += 1

        while i < len(str) and str[i].isdigit():
            digit = int(str[i])
            if INT_MAX / 10 >= sum:
                sum *= 10
            else:
                if sign == 1:
                    return INT_MAX
                else:
                    return INT_MIN
            if INT_MAX - digit >= sum:
                sum += digit
            else:
                if sign == 1:
                    return INT_MAX
                else:
                    return INT_MIN

            i += 1

        return sum * sign
