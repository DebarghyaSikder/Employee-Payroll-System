import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    // User is not granted immediate access to name and id(Encapsulation). So using getter and setter methods

    public String getName(){
        return name;

    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();  // we give its implementation in those classes which inherits this class

    @Override
    public String toString(){
        return "Employee[name="+name+",id= "+id+" , Salary= "+ calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id, double monthlySalary ){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employeeList;
    public PayRollSystem(){  // when object of this class is created this constructor is called and a new ArrayList is created under this variable name
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee: employeeList){
             if(employee.getId()==id){
                 employeeToRemove=employee;
                 break;
             }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee:employeeList) {
            System.out.println(employee);
        }
    }

}



public class Main {
    public static void main(String[] args) {
        PayRollSystem payrollSystem= new PayRollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Vikas",123,70000);
        PartTimeEmployee emp2=new PartTimeEmployee("Raj",1234,40,100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details:");
        payrollSystem.displayEmployees();
        System.out.println("Removing employees");
        payrollSystem.removeEmployee(1234);
        System.out.println("Remaining employee details");
        payrollSystem.displayEmployees();
    }
}
