class RandomizedSet(object):
    randomized_set = None
    randomized_list = None
    list_top = None

    def __init__(self):
        self.randomized_set = {}
        self.randomized_list = []
        self.list_top = -1

    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.randomized_set:
            # print("{} already present".format(val))
            return False
        else:
            # print("Adding {}".format(val))
            self.list_top += 1
            if len(self.randomized_list) > self.list_top:
                self.randomized_list[self.list_top] = val
            else:
                self.randomized_list.append(val)
            self.randomized_set[val] = self.list_top
            # print("Now : {} {} {}".format(self.randomized_list, self.randomized_set, self.list_top))
            return True
        

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val not in self.randomized_set:
            # print("{} not present".format(val))
            return False
        else:
            # print("Removing {}".format(val))
            list_index = self.randomized_set[val]
            del self.randomized_set[val]
            if list_index != self.list_top:
                new_number_on_list_index = self.randomized_list[self.list_top]
                self.randomized_list[list_index] = new_number_on_list_index
                self.randomized_set[new_number_on_list_index] = list_index
            self.list_top -= 1
            # print("Now : {} {} {}".format(self.randomized_list, self.randomized_set, self.list_top))
            return True
        

    def getRandom(self):
        """
        :rtype: int
        """
        random_index = random.randint(0, self.list_top)
        # print("Returning from index {} - {} - {}".format(0, random_index, self.list_top))
        return self.randomized_list[random_index]

        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
