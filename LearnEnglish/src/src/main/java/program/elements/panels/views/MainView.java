package program.elements.panels.views;

import program.elements.buttons.CheckButton;
import program.elements.checkboxes.UnderscoreCheckbox;
import program.elements.labels.DateLabel;
import program.elements.text_fields.EnglishWordTextArea;
import program.elements.text_fields.CorrectAnswerTextArea;
import program.elements.text_fields.TranslateTextField;
import program.elements.text_fields.UnderscoresTextArea;
import program.settings.KeyPress;


public class MainView extends View {
    public static EnglishWordTextArea wordLabel;
    public static CorrectAnswerTextArea correctAnswer;
    public static UnderscoresTextArea underscores;
    public static TranslateTextField inputTextF;
    public static DateLabel dateLabel;
    public static CheckButton check;

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
