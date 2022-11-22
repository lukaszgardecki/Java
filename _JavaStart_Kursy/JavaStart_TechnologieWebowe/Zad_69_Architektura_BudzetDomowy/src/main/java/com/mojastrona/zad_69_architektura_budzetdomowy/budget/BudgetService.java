package com.mojastrona.zad_69_architektura_budzetdomowy.budget;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetService {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();


    /**
     * Zwróć uwagę na to, że publiczne metody klasy BudgetService jako parametry oraz typy zwracane operują jedynie na obiektach DTO. Oprócz tego mogą one posługiwać się wartościami typów podstawowych Javy, czyli np. String, Double, BigDecimal itp., ale nie powinny przyjmować, ani zwracać obiektów bazodanowych. To właśnie w taki sposób stawiamy barierę, dzięki której obiekty bazodanowe nie wyciekną nam do warstwy kontrolera i widoku. W przypadku metod prywatnych zasady te oczywiście nie obowiązują.

     */

    public void addIncome(BudgetItemDto budgetItem) {
        addBudgetItem(budgetItem, BudgetItemType.INCOME);
    }

    public void addExpense(BudgetItemDto budgetItem) {
        addBudgetItem(budgetItem, BudgetItemType.EXPENSE);
    }

    private void addBudgetItem(BudgetItemDto budgetItemDto, BudgetItemType type) {
        BudgetItem budgetItem = BudgetItemMapper.toEntity(budgetItemDto, type);
        budgetItemDao.save(budgetItem);
    }

    public List<BudgetItemDto> findAllExpenses() {
        return findAllItemsByType(BudgetItemType.EXPENSE)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<BudgetItemDto> findAllIncomes() {
        return findAllItemsByType(BudgetItemType.INCOME)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .collect(Collectors.toList());
    }

    private List<BudgetItem> findAllItemsByType(BudgetItemType type) {
        return budgetItemDao.findAllItemsByType(type);
    }

    public BudgetSummaryDto getSummary() {
        BigDecimal incomesSum = getIncomesSum();
        BigDecimal expensesSum = getExpensesSum();
        BigDecimal balance = incomesSum.subtract(expensesSum);
        return new BudgetSummaryDto(incomesSum, expensesSum, balance);
    }

    private BigDecimal getIncomesSum() {
        return sumItemsValue(findAllItemsByType(BudgetItemType.INCOME));
    }

    private BigDecimal getExpensesSum() {
        return sumItemsValue(findAllItemsByType(BudgetItemType.EXPENSE));
    }

    private BigDecimal sumItemsValue(List<BudgetItem> items) {
        return items.stream()
                .map(BudgetItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
