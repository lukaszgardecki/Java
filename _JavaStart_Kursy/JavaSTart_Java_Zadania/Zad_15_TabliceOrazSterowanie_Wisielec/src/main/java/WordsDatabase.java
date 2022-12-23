import java.util.Random;

public class WordsDatabase {
    private final Random random = new Random();

    private final String[] words = {
            "java",
            "komputer",
            "kalkulator",
            "firanka",
            "na górze róże",
            "guzik"
    };

    public String getRandomWord() {
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
