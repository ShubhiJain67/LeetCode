import copy
class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        phone_keypad = self.get_phone_keypad()
        combinations = self.get_combinations(phone_keypad, digits)
        return combinations
    
    def get_phone_keypad(self):
        phone_keypad = {
            "2":["a","b","c"],
            "3":["d","e","f"],
            "4":["g","h","i"],
            "5":["j","k","l"],
            "6":["m","n","o"],
            "7":["p","q","r","s"],
            "8":["t","u","v"],
            "9":["w","x","y","z"]
        }
        return phone_keypad
    
    def get_combinations(self, phone_keypad, digits):
        combinations = []
        for index in range(len(digits) - 1, -1, -1):
            digit = digits[index]
            new_combinations = []
            if combinations:
                for combination in combinations:
                    for letter in phone_keypad[digit]:
                        new_combinations.append("{}{}".format(letter, combination))
            else:
                new_combinations = phone_keypad[digit]
            combinations = copy.deepcopy(new_combinations)
        return combinations
