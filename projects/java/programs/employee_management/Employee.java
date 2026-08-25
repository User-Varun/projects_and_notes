package employee_management;

abstract class Employee {
    abstract void calculateSalary();
    abstract void displayRole();


    public static void main(String[] args){

        Employee e = new Developer();

        e.calculateSalary();
        e.displayRole();
    }

}


class Developer extends Employee{
    void calculateSalary(){
        System.out.println("sallary");
    }
    void displayRole(){
        System.out.println("role");
    }
}