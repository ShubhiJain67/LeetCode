class Solution(object):
    def maxScore(self, card_points, k):
        """
        :type cardPoints: List[int]
        :type k: int
        :rtype: int
        """
        total_cards = len(card_points)
        prefix = self.get_all_prefix_sum(card_points)
        total_sum = prefix[total_cards]
        array_len = total_cards - k
        min_sum = self.get_minimum_sub_array(prefix, array_len)
        return total_sum - min_sum
    
    def get_all_prefix_sum(self, card_points):
        prefix = []
        prefix_sum = 0
        for card_point in card_points:
            prefix.append(prefix_sum)
            prefix_sum += card_point
        prefix.append(prefix_sum)
        return prefix
    
    def get_minimum_sub_array(self, prefix, array_len):
        start_index = 0
        end_index = array_len
        min_sum = prefix[len(prefix) - 1]
        while(end_index < len(prefix)):
            min_sum = min(min_sum, (prefix[end_index] - prefix[start_index]))
            end_index += 1 
            start_index += 1
        return min_sum
