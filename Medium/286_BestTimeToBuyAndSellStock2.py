class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        profit = 0
        cost_price_index = 0
        selling_price_index = 0
        # print("Bought on {} at {}".format(cost_price_index, prices[cost_price_index]))
        for price_index in range(1, len(prices)):
            if prices[selling_price_index] > prices[price_index]:
                # print("Sold on {} at {}".format(selling_price_index, prices[selling_price_index]))
                profit += prices[selling_price_index] - prices[cost_price_index]
                cost_price_index = price_index
                # print("Bought on {} at {}".format(cost_price_index, prices[cost_price_index]))
                selling_price_index = price_index
            else:
                selling_price_index = price_index
        # print("Sold on {} at {}".format(selling_price_index, prices[selling_price_index]))
        profit += prices[selling_price_index] - prices[cost_price_index]
        return profit

            
