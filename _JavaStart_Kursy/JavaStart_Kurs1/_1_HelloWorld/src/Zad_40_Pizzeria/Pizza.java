package Zad_40_Pizzeria;

enum Pizza {

    MARGHERITA(new String[] {"sos pomidorowy", "ser"}),
    CAPRICIOSA(new String[] {"sos pomidorowy", "ser", "szynka"}),
    PROSCIUTTO(new String[] {"sos pomidorowy", "ser", "pieczarki"});

    private String[] ingredients;

    Pizza(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        String menu = "";
        String ing = "";

        for (String ingredient : this.ingredients) {
            ing += (ingredient + " + ");
        }
        ing = ing.substring(0, ing.length() - 3);
        menu += String.format("%s. %s (%s)", this.ordinal(), this.name(), ing);

        return menu;
    }
}
