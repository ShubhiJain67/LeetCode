class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        combinations = self.find_all_combinations(s, wordDict)
        return combinations
    
    def find_all_combinations(self, target, words):
        combinations = []
        subtargets = [None]*(len(target)+1)
        target_index = len(target)
        for target_index in range(len(target), -1, -1):
            if target_index == len(target):
                subtargets[target_index] = ['']
            else:
                index = 0
                found = False
                while index < len(words):
                    word = words[index]
                    if target[target_index:].startswith(word) and subtargets[target_index+len(word)]:
                        if not subtargets[target_index]:
                            subtargets[target_index]=[]
                        for substring in subtargets[target_index + len(word)]:
                            subtargets[target_index].append((word+' '+substring).strip())
                    index+=1
        return subtargets[0]

