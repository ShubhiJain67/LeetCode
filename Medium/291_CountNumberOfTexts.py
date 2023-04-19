class Solution(object):
    def countTexts(self, pressedKeys):
        """
        :type pressedKeys: str
        :rtype: int
        """
        frequency_map = self.get_frequency_map(pressedKeys)
        # print(frequency_map)
        tribo_max, quadro_max = self.get_max_tribo_an_quadro(frequency_map)
        # print(tribo_max)
        # print(quadro_max)
        tribos = self.get_all_tribos(tribo_max+1)
        # print(tribos)
        quadros = self.get_all_quadros(quadro_max+1)
        # print(quadros)
        combinations = self.get_all_combinations(tribos, quadros, frequency_map)
        # print(combinations)
        return combinations
    
    def get_frequency_map(self, pressedKeys):
        frequency_map = []
        index = 0
        while index < len(pressedKeys):
            curr_char = pressedKeys[index]
            curr_count = 0
            while index < len(pressedKeys) and pressedKeys[index] == curr_char:
                curr_count+=1
                index+=1
            frequency_map.append([ord(curr_char)-ord('0'), curr_count])
        
        return frequency_map
    
    def get_max_tribo_an_quadro(self, frequency_map):
        tribo_max = 3
        quadro_max = 4
        for key, freq in frequency_map:
            if key in [2,3,4,5,6,8]:
                tribo_max = max(tribo_max, freq)
            else:
               quadro_max = max(quadro_max, freq)
        return tribo_max, quadro_max
    
    def get_all_tribos(self, n):
        tribos = [0]*n
        tribos[0]=1
        tribos[1]=1
        tribos[2]=2
        for index in range(3, n):
            tribos[index] = self.add_all([tribos[index - 1],tribos[index - 2],tribos[index - 3]])
        return tribos
    
    def get_all_quadros(self, n):
        quadros=[0]*n
        quadros[0]=1
        quadros[1]=1
        quadros[2]=2
        quadros[3]=4
        for index in range(4, n):
            quadros[index] = self.add_all([quadros[index - 1],quadros[index - 2],quadros[index - 3],quadros[index - 4]])
        return quadros
    
    def get_all_combinations(self, tribos, quadros, frequency_map):
        combinations = 1
        for key, freq in frequency_map:
            if key in [2,3,4,5,6,8]:
                count = tribos[freq]
            else:
                count = quadros[freq]
            combinations = (combinations * count)%(1000000007)
        return combinations

    
    def add_all(self, numbers):
        result = 0
        for num in numbers:
            result = (result + num)%(1000000007)
        return result
