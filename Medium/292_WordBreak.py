class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # result = self.find_word_rec(wordDict, s, 0)
        # result = self.find_word_memo(wordDict, s, 0, [None]*(len(s)+1))
        result = self.find_word_iterative(wordDict, s)
        return result
    
    def find_word_rec(self, words, target, target_index):
        if target_index == len(target):
            return True
        index = 0
        while index < len(words):
            word = words[index]
            if target[target_index:].startswith(word) and self.find_word_rec(words, target, target_index+len(word)):
                return True
            index+=1
        return False
    
    def find_word_memo(self, words, target, target_index, subtargets):
        if target_index == len(target):
            subtargets[target_index] = True
        elif subtargets[target_index] != None:
            return subtargets[target_index]
        else:
            index = 0
            found = False
            while index < len(words):
                word = words[index]
                if target[target_index:].startswith(word) and self.find_word_memo(words, target, target_index+len(word), subtargets):
                    found = True
                    subtargets[target_index] = True
                    break
                index+=1
            if not found:
                subtargets[target_index] = False
        return subtargets[target_index]
    
    def find_word_iterative(self, words, target):
        subtargets = [None]*(len(target)+1)
        target_index = len(target)
        for target_index in range(len(target), -1, -1):
            if target_index == len(target):
                subtargets[target_index] = True
            else:
                index = 0
                found = False
                while index < len(words):
                    word = words[index]
                    if target[target_index:].startswith(word) and subtargets[target_index+len(word)]:
                        found = True
                        subtargets[target_index] = True
                        break
                    index+=1
                if not found:
                    subtargets[target_index] = False
            print(subtargets)
        return subtargets[target_index]
