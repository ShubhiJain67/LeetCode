class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        processed_s = self.process_string(s)
        # print(processed_s)
        processed_t = self.process_string(t)
        # print(processed_t)
        return processed_s == processed_t
    
    def process_string(self, target_string):
        character_stack = ['']*len(target_string)
        top = -1
        for character in target_string:
            if character == "#":
                top = max(-1, top - 1)
            else:
                top += 1
                character_stack[top] = character
        processed_string = ""   
        while top >= 0:
            processed_string = character_stack[top] + processed_string
            top -= 1
        return processed_string
