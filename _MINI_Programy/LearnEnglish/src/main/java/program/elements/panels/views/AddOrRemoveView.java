package program.elements.panels.views;

import program.Category;
import program.Main;
import program.elements.buttons.Button;
import program.elements.labels.TitleLabel;
import program.elements.panels.MainPanel;
import program.elements.text_fields.TextField;
import program.settings.Click;
import program.settings.KeyPress;
import program.settings.MouseClick;
import program.settings.MyColor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.SwingConstants.RIGHT;
import static program.Main.*;

public class AddOrRemoveView extends View {
    public static TextField tf1;
    public static TextField tf2;
    public static JList<String> list;
    public static JScrollPane listScroller;
    public static Button addBtn;
    public static Button removeBtn;
    public static JComboBox<String> levelCombo;
    public static JComboBox<Object> groupsCombo;
    public static JPanel categoryPanel;


    public AddOrRemoveView() {
        Border border = new TitledBorder(new LineBorder(MyColor.BLUE_LIGHT, 1));

        TitleLabel addLabel = new TitleLabel("Dodaj fiszki");
        addLabel.setLocation(30, 30);

        JLabel cmbLabel1 = new JLabel("Kategoria");
        cmbLabel1.setHorizontalAlignment(RIGHT);
        cmbLabel1.setLocation(330, 25);
        cmbLabel1.setSize(60, 30);


        JLabel cmbLabel2 = new JLabel("Poziom");
        cmbLabel2.setHorizontalAlignment(RIGHT);
        cmbLabel2.setLocation(330, 70);
        cmbLabel2.setSize(60, 30);


        JPanel addWordPanel = new JPanel();
        addWordPanel.setBackground(null);
        addWordPanel.setLocation((MainPanel.WIDTH - 620)/2,100);
        addWordPanel.setSize(620,170);
        addWordPanel.setBorder(BorderFactory.createTitledBorder(border, "Edycja"));
        addWordPanel.setLayout(null);

        categoryPanel = new JPanel();
        categoryPanel.setBackground(null);
        categoryPanel.setLocation((MainPanel.WIDTH - 620)/2,300);
        categoryPanel.setSize(620,370);
        categoryPanel.setBorder(BorderFactory.createTitledBorder(border, "Dodaj kategorie do MemoBoxu"));
        categoryPanel.setLayout(new GridLayout(18, 3));


        for (Category cat : Category.values()) {
            String name = String.format("%s (%s)", cat.getName(), cat.getList().size());

            JCheckBox checkBox = cat.getCheckBox();
            checkBox.setText(name);
            checkBox.setBackground(null);
            checkBox.setActionCommand(cat.getName());
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        for(String[] word : cat.getList()) {
                            if (word[1].equals("6") || word[1].equals("7")) {

                                int index = cat.getList().indexOf(word);
                                word[1] = "0";
                                cat.getList().get(index)[1] = "0";
                            }
                            memoBox.add(word);
                        }
                    }

                    else {
                        for(String[] word : cat.getList()) {
                            int index = cat.getList().indexOf(word);
                            memoBox.remove(word);
                            cat.getList().get(index)[1] = "7";
                        }
                    }
                    Click.setNewWord();
                    list.setModel(getListModel());
                    updateStatistics();
                }
            });

            categoryPanel.add(checkBox);
        }


        tf1 = new TextField("wpisz s��wko");
        tf1.setLocation(15, 25);
        tf1.addKeyListener(new KeyPress());

        tf2 = new TextField("wpisz t�umaczenie");
        tf2.setLocation(15, 70);
        tf2.addKeyListener(new KeyPress());


        ComboBoxModel<Object> model = new DefaultComboBoxModel<>(Arrays.stream(Category.values()).map(Category::getName).toArray());
        groupsCombo = new JComboBox<>(model);
        groupsCombo.setLocation(400, 25);
        groupsCombo.setSize(190, 30);



        levelCombo = new JComboBox<>();
        levelCombo.setLocation(400, 70);
        levelCombo.setSize(50, 30);
        levelCombo.addItem("1");
        levelCombo.addItem("2");
        levelCombo.addItem("3");
        levelCombo.addItem("4");
        levelCombo.addItem("5");
        levelCombo.addItem("6");





        list = new JList<>();
        list.setModel(Main.getListModel());
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(-1);
        list.setBackground(MyColor.BLUE_LIGHT);
        list.addMouseListener(new MouseClick());

        listScroller = new JScrollPane(list);
        listScroller.setBounds((MainPanel.WIDTH - 450)/2, 700, 450, 170);


        addBtn = new Button("DODAJ");
        addBtn.setBackground(MyColor.GREEN);
        addBtn.setLocation(360, 120);
        addBtn.setActionCommand("add");

        removeBtn = new Button("USU�");
        removeBtn.setBackground(MyColor.RED);
        removeBtn.setLocation(480, 120);
        removeBtn.setActionCommand("remove");

        addWordPanel.add(tf1);
        addWordPanel.add(tf2);
        addWordPanel.add(addBtn);
        addWordPanel.add(removeBtn);
        addWordPanel.add(groupsCombo);
        addWordPanel.add(levelCombo);
        addWordPanel.add(cmbLabel1);
        addWordPanel.add(cmbLabel2);

        add(addLabel);
        add(addWordPanel);
        add(categoryPanel);
        add(listScroller);

        setVisible(false);
    }

}
