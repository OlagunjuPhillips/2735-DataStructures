import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Employee> employees;


    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }


    public void add(Employee e) {
        employees.add(e);
    }


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(name + ":\n");
        for (int i = 0; i < employees.size(); i++) {
            result.append(i + "\t" + employees.get(i) + "\n");
        }
        return result.toString();
    }

    public Employee get(int index) {
        return employees.get((index > 0 && index < employees.size() ? index : 0));
    }


    // not recursive
//    public boolean salaryMoreThan(int amount) {
//        for (Employee e : employees) {
//            if(e.getSalary() > amount)
//                return true;
//        }
//        return false;
//    }


    // recursive
    public boolean salaryMoreThan(int amount, int index) {
        // base case
        if (index >= employees.size() || index < 0) {
            return false;
        }

        // use it
        if (employees.get(index).getSalary() > amount)
            return true;

        // lose it
        return salaryMoreThan(amount, index + 1);
    }

    public int countName(String name, int index) {
        // base case
        if (index >= employees.size() || index < 0) {
            return 0;
        }

        // use it
        if (employees.get(index).getName().equals(name))
            return countName(name, index + 1) + 1;

        // lose it
        return countName(name, index + 1);
    }

}
