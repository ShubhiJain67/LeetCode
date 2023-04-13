import math
class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        # count = self.get_number_of_boomerangs_approach_1(points)
        # count = self.get_number_of_boomerangs_approach_2(points)
        count = self.get_number_of_boomerangs_approach_3(points)
        return count
    
    def get_number_of_boomerangs_approach_3(self, points):
        count = 0
        for first_point_index in range(0, len(points)):
            # In this loop we assume that first_point_index is the ith element (which has to be equidistant from j and k)distance_map = {}
            distance_map = {}
            for second_point_index in range(0, len(points)):
                # In this loop we are figuring out all the number of coordinates which canbe j or k
                first_point = points[first_point_index]
                second_point = points[second_point_index]
                distance = self.get_distance_netween_two_points(first_point, second_point)
                if distance not in distance_map:
                    distance_map[distance] = 0
                count += distance_map[distance]
                distance_map[distance] +=1
                    
        return count*2
        
    def get_number_of_boomerangs_approach_2(self, points):
        count = 0
        for first_point_index in range(0, len(points)):
            # In this loop we assume that first_point_index is the ith element (which has to be equidistant from j and k)distance_map = {}
            distance_map = {}
            for second_point_index in range(0, len(points)):
                # In this loop we are figuring out all the number of coordinates which canbe j or k
                first_point = points[first_point_index]
                second_point = points[second_point_index]
                distance = self.get_distance_netween_two_points(first_point, second_point)
                if distance not in distance_map:
                    distance_map[distance] = 0
                distance_map[distance] +=1
            
            for distance in distance_map.keys():
                count += (distance_map[distance] * (distance_map[distance] - 1))
        return count
    
    def get_number_of_boomerangs_approach_1(self, points):
        distance_map = self.get_distance_map(points)
        count = self.get_all_equidistant_combination_count(distance_map)
        return count
    
    def get_all_equidistant_combination_count(self, distance_map):
        count = 0
        for key in distance_map.keys():
            equidistant_coordinates = len(distance_map[key])
            possible_combinations = equidistant_coordinates * (equidistant_coordinates - 1)
            count += possible_combinations
        return count

    def get_distance_map(self, points):
        distance_map = {}
        for first_point_index in range(0, len(points)):
            for second_point_index in range(first_point_index+1, len(points)):
                first_point = points[first_point_index]
                second_point = points[second_point_index]
                distance = self.get_distance_netween_two_points(first_point, second_point)
                
                distance_identifier = "{}-{}-{}".format(first_point[0], first_point[1], distance)
                if distance_identifier not in distance_map:
                    distance_map[distance_identifier] = []
                distance_map[distance_identifier].append(second_point)
                
                distance_identifier = "{}-{}-{}".format(second_point[0], second_point[1], distance)
                if distance_identifier not in distance_map:
                    distance_map[distance_identifier] = []
                distance_map[distance_identifier].append(first_point)
        return distance_map
    
    def get_distance_netween_two_points(self, first_point, second_point):
        return math.sqrt((first_point[0]-second_point[0])**2 + (first_point[1]-second_point[1])**2)
