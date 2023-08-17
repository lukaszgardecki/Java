package wzorce.composite;

class Main {
    public static void main(String[] args) {
        SalesDepartment salesDepartment = new SalesDepartment(1, "Sales Department");
        FinancialDepartment financialDepartment = new FinancialDepartment(2, "Financial Department");

        HeadDepartment headDepartment = new HeadDepartment(2, "Head Department");
        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);
        headDepartment.printDepartmentName();
    }
}
