package Practice_9;

import java.time.LocalDate;
import java.util.Random;

public class MainProgram {

    public static void main(String[] args) {
        Company sony = new Company();
        Random r = new Random(1337);
        for (int i = 0; i < 50; i++) {
            sony.hire(new Employee("Homo",
                    "Sapiens",
                    LocalDate.of(r.nextInt(50) + 1950, r.nextInt(11) + 1, r.nextInt(27) + 1),
                    "Moscow,Vernadskogo sq," + r.nextInt(100),
                    "892124455" + (r.nextInt(89) + 10),
                    r.nextInt(100_000) + 10_000));
        }
        sony.HandleEmlpoyees(new Selector() {
                                 @Override
                                 public boolean mayBeHandled(Employee employee) {
                                     return employee.getBaseSalary() < 15_000;
                                 }
                             },
                employee -> employee.addBaseSalary(employee.getBaseSalary()));
        System.out.println("=============================");
        sony.HandleEmlpoyees(new YearSelector(65), emp -> emp.addBaseSalary(12_000));
    }
}