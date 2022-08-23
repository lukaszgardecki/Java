package program.elements.panels.views;

import program.Main;
import program.elements.labels.TitleLabel;
import program.elements.text_fields.TextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class AddOrRemoveView extends View {
    public static TextField tf1;
    public static TextField tf2;

    //static ArrayList<String> list = new ArrayList<>(Main.createList());
    public static JList<String> list;

    public AddOrRemoveView() {
        TitleLabel addLabel = new TitleLabel("Dodaj fiszki");
        addLabel.setLocation(30, 30);
        add(addLabel);

        tf1 = new TextField("wpisz s³ówko");
        tf1.setLocation(30, 80);
        add(tf1);

        tf2 = new TextField("wpisz t³umaczenie");
        tf2.setLocation(30, 120);
        add(tf2);

        //listOfWords = new JList<>(new String[Main.createList().size()]);
        list = new JList<>(Main.getListModel());
        list.setLocation(30, 160);
        list.setSize(300, 150);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setForeground(Color.BLACK);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // listScroller.setViewportView(list);
        //list.setLayoutOrientation(JList.VERTICAL);
        add(listScroller);



        //listScroller.setLocation(10, 10);
        //listScroller.setPreferredSize(new Dimension(30, 150));

        //add(list);











        setVisible(false);
    }
}
