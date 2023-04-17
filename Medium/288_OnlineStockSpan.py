class StockSpanner(object):
    prices = None
    spans = None

    def __init__(self):
        self.prices = []
        self.spans = []
        

    def next(self, price):
        """
        :type price: int
        :rtype: int
        """
        span = 1
        price_index = len(self.prices) - 1
        while self.prices and price_index >=0 and self.prices[price_index]<= price:
            span += self.spans[price_index][0]
            price_index = self.spans[price_index][1]
        self.prices.append(price)
        self.spans.append([span,price_index])
        return span
            

        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
