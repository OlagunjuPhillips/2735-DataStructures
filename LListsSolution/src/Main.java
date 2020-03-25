import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n=====  Welcome, Recursion!  =====\n");

        Company xula = new Company("Xavier");
        for (int i = 0; i < 11; i++) {
            xula.add(Employee.randomEmployee());
        }
        System.out.println(xula);

        System.out.println("\nAnyone making more than $100k?\t" + xula.salaryMoreThan(100_000, 0));

        System.out.println("How many " + xula.get(0).getName() + "'s?\t" + xula.countName(xula.get(0).getName(), 0));




        System.out.println("\n\n=====  Welcome, Linked Lists!  =====\n");

        LList ll = new LList("aaa", LocalDate.now(), 111);
        System.out.println("aaa:\n" + ll);

        ll = ll.prepend("bbb", LocalDate.of(2000, 12, 25), 222);
        System.out.println("\nbbb-aaa:\n" + ll);

        ll = ll.append("ccc", ll.get(0).getDate(), 222);
        System.out.println("\nbbb-aaa-ccc:\n" + ll);

        ll.setSalary(1, -333);
        System.out.println("\nchanged 2nd salary to -333:\n" + ll);

        ll.setSalary(2, -444);
        System.out.println("\nchanged 3rd salary to -444:\n" + ll);


    }
}
