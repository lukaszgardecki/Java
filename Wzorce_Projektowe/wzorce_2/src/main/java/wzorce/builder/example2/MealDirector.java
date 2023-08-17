package wzorce.builder.example2;

public class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal prepareMeal() {
        mealBuilder.addBread();
        mealBuilder.addBriyani();
        mealBuilder.addColdDrink();
        mealBuilder.addCurry();
        return mealBuilder.build();
    }
}
