package wzorce.composite;

public class FinancialDepartment implements Department {
    private Integer id;
    private String name;

    public FinancialDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println("Department name: " + name);
    }
}
