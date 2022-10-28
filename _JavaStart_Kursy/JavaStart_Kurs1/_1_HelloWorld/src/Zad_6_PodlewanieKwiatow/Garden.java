package Zad_6_PodlewanieKwiatow;

class Garden {
    public static void main(String[] args) {
        Plant p1 = new Plant("Kaktus", "Opis kaktusa.", 0.3475);
        Plant p2 = new Plant("Petunia", "Opis petuni.", 9.43242);
        Plant p3 = new Plant("Bratki", "Opis bratków.", 5.00067);

        double waterPerDayForAllPlants = p1.waterPerDay + p2.waterPerDay + p3.waterPerDay;
        double waterPerWeekForAllPlants = 7 * waterPerDayForAllPlants;
        double waterPerYearForAllPlants = 365 * waterPerWeekForAllPlants;

        System.out.printf("Roœliny zu¿ywaj¹ %.2f litra wody dziennie.\n", waterPerDayForAllPlants);
        System.out.printf("Roœliny zu¿ywaj¹ %.2f litra wody tygodniowo.\n", waterPerWeekForAllPlants);
        System.out.printf("Roœliny zu¿ywaj¹ %.2f litra wody rocznie.\n", waterPerYearForAllPlants);
    }
}
