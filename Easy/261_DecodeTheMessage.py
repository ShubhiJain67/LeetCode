class Solution(object):
    def decodeMessage(self, key, message):
        """
        :type key: str
        :type message: str
        :rtype: str
        """
        char = 'a'
        character_map = {}
        for character in key:
            if character != ' ' and character not in character_map:
                character_map[character] = char
                char = chr(ord(char)+1)
        
        result = ""
        for character in message:
            if character == ' ':
                result = result + ' '
            else: 
                result = result + character_map[character]
        return result

