class MinStack(object):
    number_stack = None
    min_stack = None
    stack_top = None

    def __init__(self):
        self.number_stack = []
        self.min_stack = []
        self.stack_top = -1
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack_top += 1
        if len(self.number_stack) > self.stack_top:
            self.number_stack[self.stack_top] = val
            prev_min = self.min_stack[self.stack_top - 1] if self.stack_top > 0 else val
            self.min_stack[self.stack_top] = min(val, prev_min)
        else:
            self.number_stack.append(val)
            prev_min = self.min_stack[self.stack_top - 1] if self.stack_top > 0 else val
            self.min_stack.append(min(val, prev_min))


    def pop(self):
        """
        :rtype: None
        """
        self.stack_top = self.stack_top - 1
        

    def top(self):
        """
        :rtype: int
        """
        return self.number_stack[self.stack_top]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[self.stack_top]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
