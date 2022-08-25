package program.elements.panels.views;

import program.elements.buttons.CheckButton;
import program.elements.labels.DateLabel;
import program.elements.text_fields.EnglishWordTextArea;
import program.elements.text_fields.CorrectAnswerTextArea;
import program.elements.text_fields.TranslateTextField;
import program.elements.text_fields.UnderscoresTextArea;


public class MainView extends View {
    public static EnglishWordTextArea wordLabel;
    public static CorrectAnswerTextArea correctAnswer;
    public static UnderscoresTextArea underscores;
    public static TranslateTextField inputTextF;
    public static DateLabel dateLabel;
    public static CheckButton check;
    public static boolean isAnswerWrong = false;

    public MainView() {
        underscores = new UnderscoresTextArea();
        wordLabel = new EnglishWordTextArea();
        correctAnswer = new CorrectAnswerTextArea();
        inputTextF = new TranslateTextField("T≥umaczenie");
        dateLabel = new DateLabel();
        check = new CheckButton("Sprawdü");

        add(check);
        add(underscores);
        add(wordLabel);
        add(dateLabel);
        add(correctAnswer);
        add(inputTextF);

        setVisible(true);
    }


}
