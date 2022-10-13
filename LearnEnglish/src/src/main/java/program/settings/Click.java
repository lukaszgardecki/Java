package program.settings;

import program.Main;
import program.elements.panels.MainPanel;
import program.elements.panels.MenuPanel;
import program.elements.panels.views.AddOrRemoveView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static program.Main.*;
import static program.elements.panels.MenuPanel.statBtn;
import static program.elements.panels.views.MainView.*;

public class Click implements ActionListener{
    JPanel mainView = MainPanel.mainView;
    JPanel editView = MainPanel.addRemoveView;
    JPanel statsView = MainPanel.statsView;

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        boolean isPressedExitBtn = a.equals("end");
        boolean isPressedStatsBtn = a.equals("stats") && statBtn.getText().equals("STATYSTYKI");
        boolean isPressedReturnBtn = a.equals("stats") && statBtn.getText().equals("WRÓÆ");
        boolean isPressedNextBtn = a.equals("check") && check.getText().equals("Dalej");
        boolean isPressedCheckBtn = a.equals("check") && check.getText().equals("SprawdŸ");
        boolean isInputNotEmpty = !inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T³umaczenie");
        boolean isGoodAnswer = (inputTextF.getText().toLowerCase()).equals(loadWord().get(5).toLowerCase());
        boolean isPressedAddOrRemoveBtn = a.equals("addRemove");
        boolean isPressedAddBtn = a.equals("add") && AddOrRemoveView.addBtn.getText().equals("DODAJ");
        boolean isPressedChangeBtn = a.equals("add") && AddOrRemoveView.addBtn.getText().equals("ZMIEÑ");
        boolean isPressedRemoveBtn = a.equals("remove");
        boolean isCheckBoxSelected = a.equals("showHide") && MenuPanel.checkbox.isSelected();
        boolean isCheckBoxNotSelected = a.equals("showHide");
        boolean areBothAddTxtFldsNotEmpty = !AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") &&
                                            !AddOrRemoveView.tf1.getText().isBlank() &&
                                            !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") &&
                                            !AddOrRemoveView.tf2.getText().isBlank();

        if (isPressedExitBtn) {
            saveAndExit();
        } else if(isPressedStatsBtn) {
            showStatistics();
        } else if (isPressedReturnBtn) {
            returnToMainView();
        } else if(isPressedNextBtn) {
            goToNextWord();
        } else if (isPressedCheckBtn && isInputNotEmpty && isGoodAnswer) {
            changeLevel("up");
            setGoodAnsView();
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
            addWordToBase();
            updateAddTxtFlds();
            AddOrRemoveView.tf2.setText("");
        } else if (isPressedChangeBtn && areBothAddTxtFldsNotEmpty) {
            changeTheWordInBase();
            updateAddTxtFlds();
            showAddBtn();
            updateWordList();
        } else if (isPressedRemoveBtn && areBothAddTxtFldsNotEmpty) {
            removeFromBase();
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
            AddOrRemoveView.tf1.setText("wpisz s³ówko");
            AddOrRemoveView.tf2.setForeground(Color.GRAY);
            AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
            showAddBtn();
            updateWordList();
        }
        changeToMainView();
    }

    private void goToNextWord() {
        wordLabel.setText(loadWord().get(4));
        wordLabel.setForeground(MyColor.BLACK);
        dateLabel.setText("Ostatnia powtórka: " + getDate());
        correctAnswer.setText("");
        inputTextF.requestFocusInWindow();
        inputTextF.setEditable(true);
        inputTextF.setForeground(MyColor.BLACK);
        inputTextF.setText("");
        check.setText("SprawdŸ");
    }

    private void showUnderscores() {
        underscores.setVisible(true);
        inputTextF.requestFocusInWindow();
    }

    private void hideUnderscores() {
        underscores.setVisible(false);
        inputTextF.requestFocusInWindow();
    }

    private void setGoodAnsView() {
        wordLabel.setText(loadWord().get(4));
        dateLabel.setText("Ostatnia powtórka: " + getDate());
        inputTextF.setText("");
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
        AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
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
        MenuPanel.addRemoveBtn.setVisible(true);
        MenuPanel.endBtn.setVisible(true);
        MenuPanel.checkbox.setVisible(true);
        MenuPanel.checkboxLabel.setVisible(true);
        statBtn.setText("STATYSTYKI");
    }

    private void showBackBtn() {
        MenuPanel.addRemoveBtn.setVisible(false);
        MenuPanel.endBtn.setVisible(false);
        MenuPanel.checkbox.setVisible(false);
        MenuPanel.checkboxLabel.setVisible(false);
        statBtn.setText("WRÓÆ");
    }

    private void changeDefaultFocus() {
        AddOrRemoveView.tf1.transferFocus();
        AddOrRemoveView.tf2.transferFocus();
    }

    private void showAddBtn() {
        AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
        AddOrRemoveView.addBtn.setText("DODAJ");
    }






//      TEN KOD NA PEWNO DZIA£A (PIERWSZA WERSJA KODU)!
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String a = e.getActionCommand();
//
//
//        if (a.equals("end")) {
//            saveAndExit();
//        } else if(a.equals("stats") && statBtn.getText().equals("STATYSTYKI")) {
//            showStatistics();
//        } else if (a.equals("stats") && statBtn.getText().equals("WRÓÆ")) {
//            returnToMainView();
//        } else if(a.equals("check")) {
//            if (check.getText().equals("Dalej")) {
//                wordLabel.setText(Main.loadWord().get(4));
//                wordLabel.setForeground(MyColor.BLACK);
//                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
//                correctAnswer.setText("");
//                inputTextF.requestFocusInWindow();
//                inputTextF.setEditable(true);
//                inputTextF.setForeground(MyColor.BLACK);
//                inputTextF.setText("");
//                check.setText("SprawdŸ");
//            } else if (check.getText().equals("SprawdŸ") && !inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T³umaczenie")) {
//                /* ----- if answer is good ----- */
//                if ((inputTextF.getText().toLowerCase()).equals(Main.loadWord().get(5))) {
//                    Main.changeLevel("up");
//                    wordLabel.setText(Main.loadWord().get(4));
//                    dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
//                    inputTextF.setText("");
//                    inputTextF.requestFocusInWindow();
//                }
//                /* ----- if answer is bad ----- */
//                else {
//                    wordLabel.setForeground(MyColor.RED);
//                    correctAnswer.setText(Main.getCorrectAnswer());
//                    inputTextF.setForeground(Color.GRAY);
//                    inputTextF.setEditable(false);
//                    check.setText("Dalej");
//                    Main.changeLevel("down");
//                }
//                Main.updateStatistics();
//            }
//        } else if (a.equals("addRemove")) {
//            mainView.setVisible(false);
//            statsView.setVisible(false);
//            editView.setVisible(true);
//            AddOrRemoveView.tf1.transferFocus();
//            AddOrRemoveView.tf2.transferFocus();
//
//            MenuPanel.addRemoveBtn.setVisible(false);
//            MenuPanel.endBtn.setVisible(false);
//            MenuPanel.checkbox.setVisible(false);
//            MenuPanel.checkboxLabel.setVisible(false);
//            statBtn.setText("WRÓÆ");
//        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("DODAJ")) {
//            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
//                    !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
//                Main.addWordToBase();
//
//                AddOrRemoveView.tf1.setText("");
//                AddOrRemoveView.tf1.requestFocusInWindow();
//                AddOrRemoveView.tf2.setText("");
//                AddOrRemoveView.tf2.setForeground(Color.GRAY);
//                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
//            }
//
//        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("ZMIEÑ")) {
//            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
//                    !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
//                Main.changeTheWordInBase();
//
//                AddOrRemoveView.tf1.setText("");
//                AddOrRemoveView.tf1.requestFocusInWindow();
//                AddOrRemoveView.tf2.setForeground(Color.GRAY);
//                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
//                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
//                AddOrRemoveView.addBtn.setText("DODAJ");
//                AddOrRemoveView.list.clearSelection();
//            }
//        }
//
//        else if (a.equals("remove")) {
//            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
//                    !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
//                Main.removeFromBase();
//
//                AddOrRemoveView.tf1.setText("");
//                AddOrRemoveView.tf1.requestFocusInWindow();
//                AddOrRemoveView.tf2.setForeground(Color.GRAY);
//                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
//                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
//                AddOrRemoveView.addBtn.setText("DODAJ");
//                AddOrRemoveView.list.clearSelection();
//            }
//        } else if (a.equals("showHide") && MenuPanel.checkbox.isSelected()) {
//            correctAnswer.setVisible(true);
//            underscores.setVisible(true);
//            inputTextF.requestFocusInWindow();
//        } else if (a.equals("showHide")) {
//            correctAnswer.setVisible(false);
//            underscores.setVisible(false);
//            inputTextF.requestFocusInWindow();
//        }
//
//    }

}
