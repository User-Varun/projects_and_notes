public class Student {
    
    // variables
    String name;
    String rollNo;
    int marks;



    // constructors
    Student(String name , String rollNo , int marks){
       this.marks = marks;
       this.rollNo = rollNo;
       this.name = name;
    }

    // methods
    void displayInfo(){
        System.out.println("Student Info :- " + this.name + " " + this.rollNo + " " + this.marks);
    }
    boolean isPass(){
        return this.marks > 40 ? true : false;
    }

    public static void main(String[] args){

        Student s1 = new Student("varun" , "stu-001" , 70);

        s1.displayInfo();
        System.out.println(s1.isPass());
    }
}
