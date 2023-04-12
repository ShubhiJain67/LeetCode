class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        secret_map = self.convert_string_into_index_map(secret)
        guess_map = self.convert_string_into_index_map(guess)
        bulls, cows = self.get_bulls_and_cows(secret_map, guess_map)
        hint = str(bulls)+"A"+str(cows)+"B"
        return hint

    def get_bulls_and_cows(self, secret_map, guess_map):
        bulls = 0
        cows = 0
        for character in secret_map.keys():
            target_indexes = secret_map[character]
            if character in guess_map:
                current_indexes = guess_map[character]
            else:
                current_indexes = set()
            correct_indexes = target_indexes & current_indexes
            incorrect_indexes = min(len(target_indexes) - len(correct_indexes), len(current_indexes) - len(correct_indexes))
            bulls += len(correct_indexes)
            cows += incorrect_indexes
        return bulls, cows
    
    def convert_string_into_index_map(self, target_string):
        target_map = {}
        for index in range(0, len(target_string)):
            character = target_string[index]
            if character not in target_map:
                target_map[character] = set()
            target_map[character].add(index)
        return target_map
