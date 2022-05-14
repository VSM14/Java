import javax.swing.*;
import java.awt.*;

public class DialogAppEdit extends JDialog {
    public DialogAppEdit(JFrame jFrame, Car car, Application application) {
        super(jFrame, "AppEdit", true);

        JPanel jPanel = new JPanel(new VerticalLayout());

        jPanel.add(new JLabel("Введите новые свойства заявки на автомобиль " + car.getBrand()));

        JPanel panelF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelF.add(new JLabel("Фамилия -"));
        JTextField textF = new JTextField(null, 8);
        panelF.add(textF);
        JPanel panelI = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelI.add(new JLabel("Имя -"));
        JTextField textI = new JTextField(null, 8);
        panelI.add(textI);
        JPanel panelO = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelO.add(new JLabel("Отчество -"));
        JTextField textO = new JTextField(null, 8);
        panelO.add(textO);

        JRadioButton rb1 = new JRadioButton("Со стенда");
        JRadioButton rb2 = new JRadioButton("Отложенная поставка");

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);

        JPanel panelType = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelType.add(rb1);
        panelType.add(rb2);
        jPanel.add(panelType);
        if (application instanceof ApplicationNoDiscount) rb1.setSelected(true);
        else rb2.setSelected(true);
        rb1.setEnabled(false);
        rb2.setEnabled(false);

        JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTel.add(new JLabel("Телефон -"));
        JTextField textTel = new JTextField(null, 10);
        panelTel.add(textTel);

        JPanel panelDiscount = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDiscount.add(new JLabel("Скидка -"));
        JTextField textDiscount = new JTextField(null, 4);
        panelDiscount.add(new JLabel("%"));
        panelDiscount.add(textDiscount);

        jPanel.add(panelF);
        jPanel.add(panelI);
        jPanel.add(panelO);
        jPanel.add(panelTel);
        jPanel.add(panelDiscount);
        if (application instanceof ApplicationNoDiscount) {
            rb1.setSelected(true);
            textDiscount.setEnabled(false);
        } else rb2.setSelected(true);
        rb1.setEnabled(false);
        rb2.setEnabled(false);


        rb1.addActionListener(event -> textDiscount.setEnabled(false));
        rb2.addActionListener(event -> textDiscount.setEnabled(true));

        add(jPanel);
        JButton buttonEdit = new JButton("Изменить");
        buttonEdit.addActionListener(event -> {
            String FIO = textF.getText() + " " + textI.getText() + " " + textO.getText();
            if (!FIO.equals("  ")) application.setFIO(FIO);
            if (!textTel.getText().equals("")) application.setPhoneNumber(textTel.getText());
            if (rb2.isSelected()) if (!textDiscount.getText().equals(""))
                application.setDiscount(Integer.parseInt(textDiscount.getText()));

            setVisible(false);
        });
        JPanel jPanel1 = new JPanel();
        jPanel1.add(buttonEdit);
        add(jPanel1, BorderLayout.SOUTH);

        setSize(360, 340);

    }
}
