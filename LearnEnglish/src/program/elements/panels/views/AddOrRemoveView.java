package program.elements.panels.views;

import program.Main;
import program.elements.buttons.Button;
import program.elements.labels.TitleLabel;
import program.elements.text_fields.TextField;
import program.settings.Click;
import program.settings.KeyPress;
import program.settings.MouseClick;
import program.settings.MyColor;

import javax.swing.*;

public class AddOrRemoveView extends View {
    public static TextField tf1;
    public static TextField tf2;
    public static JList<String> list;
    public static JScrollPane listScroller;
    public static Button addBtn;
    public static Button removeBtn;

    public AddOrRemoveView() {

        TitleLabel addLabel = new TitleLabel("Dodaj fiszki");
        addLabel.setLocation(30, 30);

        tf1 = new TextField("wpisz s³ówko");
        tf1.setLocation(30, 80);
        tf1.addKeyListener(new KeyPress());

        tf2 = new TextField("wpisz t³umaczenie");
        tf2.setLocation(30, 120);
        tf2.addKeyListener(new KeyPress());

        list = new JList<>(Main.getListModel());
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(-1);
        list.setBackground(MyColor.BLUE_LIGHT);
        list.addMouseListener(new MouseClick());


        listScroller = new JScrollPane(list);
        listScroller.setBounds(30, 160, 450, 180);


        addBtn = new Button("DODAJ");
        addBtn.setBackground(MyColor.GREEN);
        addBtn.setLocation(350, 80);
        addBtn.setActionCommand("add");

        removeBtn = new Button("USUÑ");
        removeBtn.setBackground(MyColor.RED);
        removeBtn.setLocation(350, 120);
        removeBtn.setActionCommand("remove");

        add(addLabel);
        add(tf1);
        add(tf2);
        add(addBtn);
        add(removeBtn);
        add(listScroller);

        setVisible(false);
    }

}
