package EmpManager;

public class Employee {
    int id;
    String name;
    int age;
    String department;
    String designation;
    String reporting;

    public Employee(int id, String name, int age, String department, String designation, String reporting) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.reporting = reporting;
    }

    public void print(){
        System.out.printf("%-3d %-18s %-3s %-20s %-18s %-18s\n", id, name, age, department, designation, reporting);
    }

    public String get(String s) {
        switch (s) {
            case "name":
                return name;
            case "age":
                return Integer.toString(age);
            case "designation":
                return designation;
            case "department":
                return department;
            case "reporting":
                return this.reporting;
            case "id":
                return Integer.toString(id);
            default:
                System.out.println("Enter Valid field");
        }
        return "";
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setReporting(String reporting) {
        this.reporting = reporting;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
