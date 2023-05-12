package MethodReferences;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private String grade;
    private int salary;

    public Employee() {

    }

    public void getEmployeeInfo() {
        System.out.println("I am a method in Employee class");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

//    public Employee() {
//    }

    public Employee(int id, String name, String dept, String grade, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
