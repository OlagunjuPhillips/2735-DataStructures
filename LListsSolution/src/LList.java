import java.time.LocalDate;
import java.util.Date;

public class LList {

    private Employee employee;
    private LList next;

    public LList(String name, LocalDate date, double salary) {
        employee = new Employee(name, date, salary);
        next = null;
    }

    @Override
    public String toString() {
        return employee + "  -->  " + next;
    }

    public LList prepend(String name, LocalDate date, double salary) {
        LList head = new LList(name, date, salary);
        head.next = this;
        return head;
    }

    public Employee get(int index) {
        LList temp = this;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.employee;
    }

    public LList append(String name, LocalDate date, double salary) {
        LList temp = this;
        while(temp.next != null)
            temp = temp.next;

        temp.next = new LList(name, date, salary);
        return this;
    }

    public void setSalary(int index, double salary) {
        if(index == 0) {
            employee.setSalary(salary);
        } else {
            this.next.setSalary(index-1, salary);
        }
    }
}
