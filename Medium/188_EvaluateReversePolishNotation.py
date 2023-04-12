class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        equation = []
        for token in tokens:
            if token.lstrip("-").isnumeric():
                number = int(token.lstrip("-"))
                if token[0] == '-':
                    number = number * -1
                equation.append(number)
            else:
                number1 = equation.pop()
                number2 = equation.pop()
                evaluated_number = self.evaluate(number2, token, number1)
                equation.append(evaluated_number)
            # print("After {} - {}".format(token, equation))
        return equation[0]

    def evaluate(self, number1, token, number2):
        # print("{} {} {}".format(number1, token, number2))
        if token == '+':
            return number1 + number2
        elif token == '-':
            return number1 - number2
        elif token == '*':
            return number1 * number2
        elif token == '/':
            number = abs(number1)/abs(number2)
            if (number1 < 0 and number2 > 0) or (number1 > 0 and number2 < 0):
                number = number * -1
            return number
