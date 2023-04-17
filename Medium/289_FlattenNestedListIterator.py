# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):
    num_list = None
    top = None

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.num_list = []
        self._flatten_list(nestedList)
        self.top = 0 if len(self.num_list) > 0 else -1

    def _flatten_list(self,nestedList):
        for element in nestedList:
            if element.isInteger():
                integer_value = element.getInteger()
                self.num_list.append(integer_value)
            else:
                self._flatten_list(element.getList())

    def next(self):
        """
        :rtype: int
        """
        next_value = self.num_list[self.top]
        self.top += 1
        return next_value

    def hasNext(self):
        """
        :rtype: bool
        """
        has_next = self.top < len(self.num_list) and self.top >=0
        return has_next
        

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
