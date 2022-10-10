package com.example.Testy_Cwiczenie3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcronymGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "'',''",
            "Tom, T",
            "£ukasz, £",
            "Martin Schmidt, MS",
            "Martin Hanaval Enty Calculator Main Suspicious, MHECMS",
            "Zuta Plate Tt Six Days For Man, ZPTSDFM",
            "this is my tomato bro, TIMTB",
            "return uppercase acronym, RUA",
            "o, O",
            "Jan-Erich Ham, JEH",
            "Don-Belt-Zygmunt-Max-Hans Maciejkowski, DBZMHM",
            "Paul Mayer-Schmidt, PMS",
            "Paul von Lahnstein, PvL",
            "Martin von Zigmuntinen-Mayernen-Poyernen Hans, MvZMPH"
    })
    void returnsAcronymOfPersonFullName(String fullName, String expectedAcronym) {
        AcronymGenerator acronymGenerator = new AcronymGenerator();
        String result = acronymGenerator.generate(fullName);
        Assertions.assertThat(result).isEqualTo(expectedAcronym);
    }

}
