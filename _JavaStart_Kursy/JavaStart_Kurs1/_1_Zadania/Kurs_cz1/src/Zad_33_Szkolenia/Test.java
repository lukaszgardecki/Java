package Zad_33_Szkolenia;

class Test {
    public static void main(String[] args) {

        Course course = new Course("1", 999.99, "Kurs robienia ha�asu", "Przez ca�y kurs robimy ha�as");
        OnlineCourse onlineCourse = new OnlineCourse("2", 700.50, "Kurs online", "Najlepszy na �wiecie kurs online", 480, 450);
        FullTimeCourse fullTimeCourse = new FullTimeCourse("3", 1500.99, "Kurs stacjonarny", "Najlepszy kurs stacjonarny", "Katowice", 24);
        Bootcamp bootcamp = new Bootcamp("4", 4999.0, "Java Bootcamp", "Od zera do Pana programera", "Janusz", "Programmermaker", 10);


        System.out.println(course);
        System.out.println(onlineCourse);
        System.out.println(fullTimeCourse);
        System.out.println(bootcamp);
    }
}
