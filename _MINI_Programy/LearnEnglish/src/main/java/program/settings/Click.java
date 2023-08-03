package program.settings;

import program.Category;
import program.elements.panels.MainPanel;
import program.elements.panels.MenuPanel;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;
import program.elements.panels.views.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static program.Main.*;
import static program.elements.panels.MenuPanel.statBtn;
import static program.elements.panels.views.MainView.*;

public class Click implements ActionListener{
    View mainView = MainPanel.mainView;
    View editView = MainPanel.addRemoveView;
    View statsView = MainPanel.statsView;
    static String[] word;
    static String englishWord;
    static String polishWord;
    static String numOfGroup;

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();

        word = memoBox.getCurrentWord();
        englishWord = word[7];

        boolean isPressedExitBtn = a.equals("end");
        boolean isPressedStatsBtn = a.equals("stats") && statBtn.getText().equals("STATYSTYKI");
        boolean isPressedReturnBtn = a.equals("stats") && statBtn.getText().equals("WR��");
        boolean isPressedNextBtn = a.equals("check") && check.getText().equals("Dalej");
        boolean isPressedCheckBtn = a.equals("check") && check.getText().equals("Sprawd�");
        boolean isInputNotEmpty = !inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T�umaczenie");
        boolean isGoodAnswer = (inputTextF.getText().toLowerCase()).equals(englishWord.toLowerCase());
        boolean isPressedAddOrRemoveBtn = a.equals("addRemove");
        boolean isPressedAddBtn = a.equals("add") && AddOrRemoveView.addBtn.getText().equals("DODAJ");
        boolean isPressedChangeBtn = a.equals("add") && AddOrRemoveView.addBtn.getText().equals("ZMIE�");
        boolean isPressedRemoveBtn = a.equals("remove");
        boolean isCheckBoxSelected = a.equals("showHide") && MenuPanel.checkbox.isSelected();
        boolean isCheckBoxNotSelected = a.equals("showHide");
        boolean areBothAddTxtFldsNotEmpty = !AddOrRemoveView.tf1.getText().equals("wpisz s��wko") &&
                                            !AddOrRemoveView.tf1.getText().isBlank() &&
                                            !AddOrRemoveView.tf2.getText().equals("wpisz t�umaczenie") &&
                                            !AddOrRemoveView.tf2.getText().isBlank();



        if (isPressedExitBtn) saveAndExit();
        else if(isPressedStatsBtn) showStatistics();
        else if (isPressedReturnBtn) returnToMainView();
        else if(isPressedNextBtn) setNewWord();
        else if (isPressedCheckBtn && isInputNotEmpty && isGoodAnswer) {
            changeLevel("up");
            setNewWord();
            updateStatistics();
        } else if (isPressedCheckBtn && isInputNotEmpty) {
            changeLevel("down");
            setWrongAnsView();
            updateStatistics();
        } else if (isPressedAddOrRemoveBtn) {
            changeToEditView();
            changeDefaultFocus();
            showBackBtn();
        } else if (isPressedAddBtn && areBothAddTxtFldsNotEmpty) {
            doOperation("add");
            updateAddTxtFlds();
            AddOrRemoveView.tf2.setText("");
        } else if (isPressedChangeBtn && areBothAddTxtFldsNotEmpty) {
            doOperation("change");
            setNewWord();
            updateAddTxtFlds();
            showAddBtn();
            updateWordList();
        } else if (isPressedRemoveBtn && areBothAddTxtFldsNotEmpty) {
            doOperation("remove");
            updateAddTxtFlds();
            showAddBtn();
            updateWordList();
        } else if (isCheckBoxSelected) {
            showUnderscores();
        } else if (isCheckBoxNotSelected) {
            hideUnderscores();
        }
    }



    private void saveAndExit() {
        saveData();
        win.dispose();
    }

    private void showStatistics() {
        changeToStatsView();
        showBackBtn();
    }

    private void returnToMainView() {
        if (MainPanel.addRemoveView.isVisible()) {
            AddOrRemoveView.tf1.setForeground(Color.GRAY);
            AddOrRemoveView.tf1.setText("wpisz s��wko");
            AddOrRemoveView.tf2.setForeground(Color.GRAY);
            AddOrRemoveView.tf2.setText("wpisz t�umaczenie");
            AddOrRemoveView.levelCombo.setSelectedIndex(0);
            AddOrRemoveView.groupsCombo.setSelectedIndex(0);
            showAddBtn();
            updateWordList();
        }
        changeToMainView();
    }

    public static void setNewWord() {
        word = loadWord();
        englishWord = word[7];
        polishWord = word[6];
        numOfGroup = word[1];
        String category = word[2].equals("CAT0") ? "" : Category.valueOf(word[2]).getName();
        String level = word[3].equals("0") ? "" : "Poziom " + word[3];

        wordLabel.setText(polishWord);
        categoryLabel.setText(category);
        levelLabel.setText(level);
        underscores.setUnderscores(word);
        wordLabel.setForeground(MyColor.BLACK);
        wordLabel.setMyBorder(numOfGroup);
        MainView.setGroupColor(word);
        dateLabel.setText("Ostatnia powt�rka: " + getDate());
        correctAnswer.setText("");
        inputTextF.setText("");
        inputTextF.requestFocusInWindow();
        inputTextF.setEditable(true);
        inputTextF.setForeground(MyColor.BLACK);
        check.setText("Sprawd�");
    }

    private void showUnderscores() {
        underscores.setVisible(true);
        inputTextF.requestFocusInWindow();
    }

    private void hideUnderscores() {
        underscores.setVisible(false);
        inputTextF.requestFocusInWindow();
    }

    private void setWrongAnsView() {
        wordLabel.setForeground(MyColor.RED);
        correctAnswer.setText(getCorrectAnswer());
        inputTextF.setForeground(Color.GRAY);
        inputTextF.setEditable(false);
        check.setText("Dalej");
    }

    private void updateAddTxtFlds() {
        AddOrRemoveView.tf1.setText("");
        AddOrRemoveView.tf1.requestFocusInWindow();
        AddOrRemoveView.tf2.setForeground(Color.GRAY);
        AddOrRemoveView.tf2.setText("wpisz t�umaczenie");
    }

    private void updateWordList() {
        AddOrRemoveView.list.clearSelection();
    }

    private void changeToStatsView() {
        mainView.setVisible(false);
        editView.setVisible(false);
        statsView.setVisible(true);
    }

    private void changeToMainView() {
        editView.setVisible(false);
        statsView.setVisible(false);
        mainView.setVisible(true);
        showMainViewBtns();
    }

    private void changeToEditView() {
        mainView.setVisible(false);
        statsView.setVisible(false);
        editView.setVisible(true);
    }

    private void showMainViewBtns() {
        setVisibleOtherComponentsTo(true);
        statBtn.setText("STATYSTYKI");
    }

    private void showBackBtn() {
        setVisibleOtherComponentsTo(false);
        statBtn.setText("WR��");
    }

    private void setVisibleOtherComponentsTo(boolean TorF) {
        MenuPanel.addRemoveBtn.setVisible(TorF);
        MenuPanel.endBtn.setVisible(TorF);
        MenuPanel.checkbox.setVisible(TorF);
        MenuPanel.checkboxLabel.setVisible(TorF);
    }

    private void changeDefaultFocus() {
        AddOrRemoveView.tf1.transferFocus();
        AddOrRemoveView.tf2.transferFocus();
        AddOrRemoveView.levelCombo.transferFocus();
    }

    private void showAddBtn() {
        AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
        AddOrRemoveView.addBtn.setText("DODAJ");
    }
}
