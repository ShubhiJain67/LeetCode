class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        expression_stack = []
        element_index = 0
        while element_index < len(s):
            if s[element_index].isnumeric():
                element_index = self.get_all_numbers_and_push_in_stack(element_index, s, expression_stack)
            elif s[element_index] == '[':
                element_index+=1
                continue
            elif self.is_element_an_alphabet(s[element_index]):
                element_index = self.get_all_alphabets_and_push_in_stack(element_index, s, expression_stack)
            elif s[element_index] == ']':
                element_index+=1
                self.evaluate_elements(expression_stack)
            print(expression_stack)
        final_expression = self.accumulate_all_strings(expression_stack)
        return final_expression
    
    def get_all_numbers_and_push_in_stack(self, element_index, s, expression_stack):
        partial_expression = ""
        while element_index < len(s) and s[element_index].isnumeric():
            partial_expression+=s[element_index]
            element_index+=1
        expression_stack.append(int(partial_expression))
        return element_index
    
    def get_all_alphabets_and_push_in_stack(self, element_index, s, expression_stack):
        partial_expression = ""
        while element_index < len(s) and self.is_element_an_alphabet(s[element_index]):
            partial_expression+=s[element_index]
            element_index+=1
        expression_stack.append(partial_expression)
        return element_index

    def evaluate_elements(self, expression_stack):
        character_string = self.accumulate_all_strings(expression_stack)
        if expression_stack:
            count = expression_stack.pop()
            character_string = character_string * count
        expression_stack.append(character_string)
    
    def is_element_an_alphabet(self, element):
        return (element >= 'a' and element <= 'z') or (element >= 'A' and element <= 'Z')
    
    def accumulate_all_strings(self, expression_stack):
        character_string = ""
        while expression_stack and type(expression_stack[len(expression_stack) - 1]) == unicode:
            element = expression_stack.pop()
            character_string = element + character_string
        return character_string
