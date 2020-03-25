import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstName;
    private LocalDate hireDate;
    private double salary;


    // this is called a "clone"
    public Employee(Employee e) {
        this.firstName = e.firstName;
        this.hireDate = e.hireDate;
        this.salary = e.salary;
    }

    public Employee(String firstName, LocalDate hireDate, double salary) {
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    // note the use of "static"
    public static Employee randomEmployee() {
        Random rand = new Random();
        String[] names = {"Jamitha", "Tuan", "Mohib", "Ajene", "Brittany", "Symone"};

        String name = names[rand.nextInt(names.length)];
        LocalDate date = LocalDate.now();
        double salary = 50_000 + rand.nextDouble() * (100_000 - 20_000);

        return new Employee(name, date, salary);
    }


    @Override
    public String toString() {
        return String.format("%s/%s/%,.2f", firstName, hireDate, salary);
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(hireDate, employee.hireDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, hireDate, salary);
    }

    public Employee doubleSalary() {
        this.salary = this.salary * 2;

        return this;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getName() {
        return firstName;
    }

    public LocalDate getDate() {
        return hireDate;
    }
}
