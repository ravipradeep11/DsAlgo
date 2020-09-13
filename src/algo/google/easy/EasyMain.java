package algo.google.easy;

import java.util.HashMap;
import java.util.List;

public class EasyMain {
    public static void main(String[] args){


    }
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        return getImp(map.get(id),map);

    }
     public static int getImp(Employee employee,HashMap<Integer,Employee> map){
        if(employee==null) return 0;
        if(employee.subordinates!=null&&!employee.subordinates.isEmpty())
            return employee.importance;
        int result=employee.importance;
        for(int empId:employee.subordinates){
            result+=getImp(map.get(empId),map);
        }
        return result;

     }
    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
