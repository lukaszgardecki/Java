public class PaymentCalculator {
    public static final double ZUS = 1000;
    public static final double INCOME_TAX = 0.2;

    static double nettoYearPayment(Employee employee) {
        return employee.getSalary() * 12;
    }

    static double bruttoYearPayment(Employee employee) {
        return 12 * (employee.getSalary() + ZUS + INCOME_TAX * employee.getSalary());
    }
}
