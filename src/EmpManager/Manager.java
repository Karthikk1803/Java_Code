package EmpManager;

import java.util.*;

public class Manager {
    List<Employee> tab = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void main(String[] args) {
        initialize();

        while(true){

            System.out.print("\n1.Show Records\n2.Search and Update\n3.Remove\n4. Exit\n");
            int c = sc.nextInt();
            switch (c){
                case 1:
                    System.out.printf("%-3s %-18s %-3s %-20s %-18s %-18s\n", "ID", "Name", "Age", "Department", "Designation", "Reporting To");
                    for(Employee e: tab) e.print(); break;
                case 2: searchUpdate(); break;
                case 3: remove(); break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }

    }

    private void initialize() {
        tab.add(new Employee(1, "Sriram", 45, "Management", "CEO", "-"));
        tab.add(new Employee(2, "Mukund", 42, "HR", "HR Manager", "Sriram"));
        tab.add(new Employee(3, "Sebastian", 38, "Finance", "Finance Manager", "Sriram"));
        tab.add(new Employee(4, "Aashritha", 32, "Product Management", "Dev Manager", "Sriram"));
        tab.add(new Employee(5, "Mohammad Rafi", 35, "HR", "HR Lead", "Mukund"));
        tab.add(new Employee(6, "Anjali Kumar", 29, "HR", "HR Associate", "Mohammad Rafi"));
        tab.add(new Employee(7, "Joseph", 40, "Finance", "Finance Associate", "Sebastian"));
        tab.add(new Employee(8, "Ramachandran", 27, "Product Development", "Tech Lead", "Aashritha"));
        tab.add(new Employee(9, "Abhinaya Shankar", 23, "Product Development", "System Developer", "Ramachandran"));
        tab.add(new Employee(10, "Imran Khan", 28, "Product Testing", "QA Lead", "Ramachandran"));
    }



    public void searchUpdate() {
        List<Employee> fil = new ArrayList<>(tab);
        boolean updateDone = false;

        while(true) {
            System.out.print("Enter Field to search [name, age, department, designation, reporting]: ");
            String f = sc.next().toLowerCase();

            if (f.equals("age") || f.equals("id")) System.out.print("Enter op [<, >, =, !=]: ");
            else System.out.print("Enter op [equals, not_equals, contains, not_contains, starts, ends]: ");
            String op = sc.next();

            System.out.print("Enter val: ");
            String val = sc.next();

            List<Employee> newlist = new ArrayList<>();

            for (Employee e : fil) {
                String fieldVal = e.get(f).toLowerCase();
                if (f.equals("age") || f.equals("id")) {
                    int fn = Integer.parseInt(fieldVal);
                    int n = Integer.parseInt(val);
                    if ((op.equals(">") && fn > n) ||
                            (op.equals("<") && fn < n) ||
                            (op.equals("=") && fn == n) ||
                            (op.equals("!=") && fn != n)) newlist.add(e);

                } else {
                    switch (op) {
                        case "equals":
                            if (fieldVal.equals(val.toLowerCase())) newlist.add(e);
                            break;
                        case "not_equals":
                            if (!fieldVal.equals(val.toLowerCase())) newlist.add(e);
                            break;
                        case "contains":
                            if (fieldVal.contains(val.toLowerCase())) newlist.add(e);
                            break;
                        case "not_contains":
                            if (!fieldVal.contains(val.toLowerCase())) newlist.add(e);
                            break;
                        case "starts":
                            if (fieldVal.startsWith(val.toLowerCase())) newlist.add(e);
                            break;
                        case "ends":
                            if (fieldVal.endsWith(val.toLowerCase())) newlist.add(e);
                            break;
                        default:
                            System.out.print("Enter valid op: ");
                            op = sc.next();
                    }
                }
            }
            fil = newlist;
            System.out.printf("%-3s %-18s %-3s %-20s %-18s %-18s\n", "ID", "Name", "Age", "Department", "Designation", "Reporting To");
            for (Employee e : fil) e.print();

            System.out.println("\n1. Add Conditions\n2.Update\n3.Exit\n");
            int c = sc.nextInt();

            switch (c) {
                case 1: continue;
                case 2: updateDone = true;
                case 3: break;
            }

            if(updateDone) {
                while (true) {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Field to update: ");
                    String inp = sc.next();

                    System.out.print("Enter new Value: ");
                    String nVal = sc.next();

                    for (Employee e : fil) {
                        if(e.id == id){
                            switch(inp){
                                case "name": e.setName(nVal); break;
                                case "age": e.setAge(Integer.parseInt(nVal)); break;
                                case "department": e.setDepartment(nVal); break;
                                case "designation": e.setDesignation(nVal); break;
                                case "reporting": e.setReporting(nVal); break;
                            }
                            break;
                        }
                    }

                    System.out.println("Do you want to update more?? (y/n) ");
                    if(sc.next().equals("y")) continue;
                    System.out.println();
                    for(Employee t: tab) t.print();
                    break;
                }
            }
            break;
        }
    }

    public void remove(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for(Employee e: tab){
            if(e.id == id){
                System.out.println("Who Manager?? ");
                String s = sc.next();

                boolean f = true;
                String tempMan = e.reporting;
                for(Employee t: tab){
                    //System.out.println(t.name.toLowerCase() + " "+ s.equalsIgnoreCase(t.name) + " " + s);
                    if(s.equalsIgnoreCase(t.name)){
                        f = false;
                        tempMan = t.name;
                    }
                }
                if(f){
                    System.out.println("No name found.");
                }
                for(Employee t: tab){
                    if(t.reporting.equalsIgnoreCase(e.name)) t.setReporting(tempMan);
                }

                tab.remove(e);
                System.out.println();
                for(Employee t: tab) t.print();
                break;
            }
        }
    }
}

