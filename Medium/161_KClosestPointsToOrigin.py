import heapq
import math
class Solution(object):
    def kClosest(self, points, k):
        """
        :type points: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        distance = []
        for point in points:
            distance.append((math.sqrt(point[0]*point[0]+point[1]*point[1]), point))

        heapq.heapify(distance)
        closest_points = []
        while k>0:
            closest_points.append(heapq.heappop(distance)[1])
            k-=1
        return closest_points

