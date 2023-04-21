package wzorce.polecenie.klient;

import wzorce.polecenie.obiektyRealizujące.DrzwiGarażowe;
import wzorce.polecenie.obiektyRealizujące.WentylatorSufitowy;
import wzorce.polecenie.obiektyRealizujące.WieżaStereo;
import wzorce.polecenie.obiektyRealizujące.Światło;
import wzorce.polecenie.obiektyWywołujące.SuperPilot;
import wzorce.polecenie.polecenia.*;

/**
 * Tworzy szereg obiektów-poleceń, które są następnie
 * ładowane do poszczególnych slotów SuperPilota.
 * Każdy obiekt-polecenie hermetyzuje żądanie wykonania
 * określonej operacji przez dane urządzenie gospodarstwa domowego.
 */
public class ProgramowaniePilota {
    public static void main(String[] args) {
        SuperPilot pilot = new SuperPilot();

        Światło jadalniaŚwiatło = new Światło("Jadalnia");
        Światło kuchniaŚwiatło = new Światło("Kuchnia");
        WentylatorSufitowy wentylatorSufitowy = new WentylatorSufitowy("Jadalnia");
        DrzwiGarażowe drzwiGarażowe = new DrzwiGarażowe();
        WieżaStereo wieżaStereo = new WieżaStereo("Jadalnia");

        PolecenieWłączŚwiatło jadalniaWłączŚwiatło = new PolecenieWłączŚwiatło(jadalniaŚwiatło);
        PolecenieWyłączŚwiatło jadalniaWyłączŚwiatło = new PolecenieWyłączŚwiatło(jadalniaŚwiatło);

        PolecenieWłączŚwiatło kuchniaWłączŚwiatło = new PolecenieWłączŚwiatło(kuchniaŚwiatło);
        PolecenieWyłączŚwiatło kuchniaWyłączŚwiatło = new PolecenieWyłączŚwiatło(kuchniaŚwiatło);

        PolecenieWłączWentylatorSufitowy włączWentylatorSufitowy = new PolecenieWłączWentylatorSufitowy(wentylatorSufitowy);
        PolecenieWłączWentylatorSufitowySzybko włączWentylatorSufitowySzybko = new PolecenieWłączWentylatorSufitowySzybko(wentylatorSufitowy);
        PolecenieWyłączWentylatorSufitowy wyłączWentylatorSufitowy = new PolecenieWyłączWentylatorSufitowy(wentylatorSufitowy);

        PolecenieWieżaStereoWłączCD wieżaStereoWłączCD = new PolecenieWieżaStereoWłączCD(wieżaStereo);
        PolecenieWyłączWieżaStereo wyłączWieżaStereo = new PolecenieWyłączWieżaStereo(wieżaStereo);

        PolecenieOtwórzDrzwiGarażowe otwórzDrzwiGarażowe = new PolecenieOtwórzDrzwiGarażowe(drzwiGarażowe);
        PolecenieZamknijDrzwiGarażowe zamknijDrzwiGarażowe = new PolecenieZamknijDrzwiGarażowe(drzwiGarażowe);

        pilot.ustawPolecenie(0, jadalniaWłączŚwiatło, jadalniaWyłączŚwiatło);
        pilot.ustawPolecenie(1, kuchniaWłączŚwiatło, kuchniaWyłączŚwiatło);
        pilot.ustawPolecenie(2, włączWentylatorSufitowy, wyłączWentylatorSufitowy);
        pilot.ustawPolecenie(3, włączWentylatorSufitowySzybko, wyłączWentylatorSufitowy);

        pilot.ustawPolecenie(4, wieżaStereoWłączCD, wyłączWieżaStereo);
        pilot.ustawPolecenie(5, otwórzDrzwiGarażowe, zamknijDrzwiGarażowe);

        System.out.println(pilot);

        pilot.wciśniętoPrzyciskWłącz(0);
        pilot.wciśniętoPrzyciskWyłącz(0);
        pilot.wciśniętoPrzyciskWłącz(1);
        pilot.wciśniętoPrzyciskWyłącz(1);
        pilot.wciśniętoPrzyciskWłącz(2);
        pilot.wciśniętoPrzyciskWyłącz(2);
        pilot.wciśniętoPrzyciskWłącz(3);
        pilot.wciśniętoPrzyciskWyłącz(3);
        pilot.wciśniętoPrzyciskWłącz(4);
        pilot.wciśniętoPrzyciskWyłącz(4);
        pilot.wciśniętoPrzyciskWłącz(5);
        pilot.wciśniętoPrzyciskWyłącz(5);


        System.out.println("--------------------------------------------------");

        Światło światłoGaraż = new Światło("Garaż");
        WieżaStereo wieżaGaraż = new WieżaStereo("Garaż");
        WentylatorSufitowy wentylatorGaraż = new WentylatorSufitowy("Garaż");

        PolecenieWłączŚwiatło włączŚwiatłoGaraż = new PolecenieWłączŚwiatło(światłoGaraż);
        PolecenieWyłączŚwiatło wyłączŚwiatłoGaraż = new PolecenieWyłączŚwiatło(światłoGaraż);
        PolecenieWieżaStereoWłączCD włączWieżęCD = new PolecenieWieżaStereoWłączCD(wieżaGaraż);
        PolecenieWyłączWieżaStereo wyłączWieżęCD = new PolecenieWyłączWieżaStereo(wieżaGaraż);
        PolecenieWłączWentylatorSufitowySzybko włączWentylatorGarażSzybko = new PolecenieWłączWentylatorSufitowySzybko(wentylatorGaraż);
        PolecenieWyłączWentylatorSufitowy wyłączWentylatorSufitowyGaraż = new PolecenieWyłączWentylatorSufitowy(wentylatorSufitowy);

        Polecenie[] włączImprezę = {włączŚwiatłoGaraż, włączWieżęCD, włączWentylatorGarażSzybko};
        Polecenie[] wyłączImprezę = {wyłączŚwiatłoGaraż, wyłączWieżęCD, wyłączWentylatorSufitowyGaraż};

        MakroPolecenie makroWłączImprezę = new MakroPolecenie(włączImprezę);
        MakroPolecenie makroWyłączImprezę = new MakroPolecenie(wyłączImprezę);

        pilot.ustawPolecenie(6, makroWłączImprezę, makroWyłączImprezę);
        System.out.println(pilot);
        System.out.println("--- Włączamy imprezę ---");
        pilot.wciśniętoPrzyciskWłącz(6);
        System.out.println("--- Wyłączamy imprezę ---");
        pilot.wciśniętoPrzyciskWyłącz(6);
        System.out.println("--- Naciskamy cofnij ---");
        pilot.wciśniętoPrzyciskWycofaj();
    }
}
