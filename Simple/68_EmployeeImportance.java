/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        int sum=0;
        LinkedList<Employee> queue=new LinkedList<>();
        ArrayList<Integer> employeeVisited=new ArrayList<>();
        
        
        //------------Mapping the Employees information to their ID----------------------
        HashMap<Integer,Employee> EmpMap=new HashMap<>();
        for(Employee e: employees){
            EmpMap.put(e.id,e);
        }
        
        //--------------------------------Pushing the employee with the given id---------------------
        queue.addLast(EmpMap.get(id));
        //-------------------------------Marking the employee Visited--------------------------------
        employeeVisited.add(id);
        
        
        
        while(queue.size()!=0){
            int size=queue.size();
            //------------------------------------For Every level----------------------------------
            while(size-->0){
                Employee e=queue.removeFirst();
                
                //---------------Summing up the importance for the the employees--------------------
                sum+=e.importance;
                for(Integer i:e.subordinates){
                    Employee ie=EmpMap.get(i);
                    
                    //--------Add subordiates only ifthey are not already visited-------------------
                    if(employeeVisited.contains(i)==false){
                        queue.addLast(ie);
                        employeeVisited.add(i);
                    }
                }
                
            }
        }
        return sum;
    }
}