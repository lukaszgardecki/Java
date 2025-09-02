public class SalaryAdjustmentVisitor implements Visitor {

    @Override
    public void visit(Manager manager) {
        manager.setSalary(65000);
    }

    @Override
    public void visit(SalesPerson salesPerson) {
        salesPerson.setSalary(57000);
    }

    @Override
    public void visit(StaffList staffList) {
        System.out.println("Salary adjustments have been applied to all staff.");
    }
}
