class Solution(object):
    def numberOfWeakCharacters(self, properties):
        """
        :type properties: List[List[int]]
        :rtype: int
        """
        # weak_characters = self.get_week_character_count_approach_1(properties)
        weak_characters = self.get_week_character_count_approach_2(properties)
        return weak_characters

    def get_week_character_count_approach_2(self, properties):
        weak_characters = 0
        properties = sorted(properties, key=lambda x: (x[0], -x[1]))
        max_defense = 0
        for character_property_id in range(len(properties) -1 , -1 , -1):
            # Here we know that all the attacks on the left are eithe less or equal.
            # The equal attacks would not matter as we start with the smallest defense
            attack, defense = properties[character_property_id]
            if defense > max_defense:
                max_defense = defense
            elif defense < max_defense:
                weak_characters += 1
        return weak_characters


    def get_week_character_count_approach_1(self, properties):
        properties = sorted(properties, key=lambda x: x[0])
        weak_characters = 0
        for target_character_id in range(0,len(properties)):
            for other_character_id in range(target_character_id + 1, len(properties)):
                target_attack, target_defense = properties[target_character_id]
                other_attack, other_defense = properties[other_character_id]
                if target_attack < other_attack and target_defense < other_defense:
                    weak_characters +=1
                    break
        return weak_characters
