"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        employee_map = self.get_employee_map(employees)
        employee_importance = self.calculate_employee_importance(employee_map, id, [])
        return employee_importance
    
    def get_employee_map(self, employees):
        employee_map = {}
        for employee in employees:
            employee_map[employee.id] = employee
        return employee_map
    
    def calculate_employee_importance(self, employee_map, id, visited_subordinates):
        employee_importance = employee_map[id].importance
        for subordinate in employee_map[id].subordinates:
            if subordinate not in visited_subordinates:
                visited_subordinates.append(subordinate)
                employee_importance += self.calculate_employee_importance(employee_map, subordinate, visited_subordinates)
        return employee_importance
