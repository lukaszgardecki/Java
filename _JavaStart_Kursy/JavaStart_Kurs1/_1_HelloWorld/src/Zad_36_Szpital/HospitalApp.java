package Zad_36_Szpital;

class HospitalApp {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Doctor doctor = new Doctor("Maciek", "Prefeska", 7500.0, 1300);
        Nurse nurse1 = new Nurse("Ania", "Dobroszewska", 2200.0, 6.0);
        Nurse nurse2 = new Nurse("Marta", "Daielska", 2100.0, 3.0);

        hospital.add(doctor);
        hospital.add(nurse1);
        hospital.add(nurse2);

        System.out.println(hospital.getInfo());
    }
}
