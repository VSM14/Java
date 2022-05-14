import javax.swing.*;
import java.awt.*;

class DialogCarCreate extends JDialog {
    public DialogCarCreate(JFrame jFrame, MotorShow motorShow, JList<String> jlist) {
        super(jFrame, "CarCreate", true);
        JPanel jPanel = new JPanel(new VerticalLayout());

        jPanel.add(new JLabel("Введите свойства автомобиля"));

        JPanel panelBrand = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBrand.add(new JLabel("Марка -"));
        JTextField textBrand = new JTextField(null, 8);
        panelBrand.add(textBrand);

        JPanel panelPass = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPass.add(new JLabel("Пассажиры -"));
        JTextField textPass = new JTextField(null, 8);
        panelPass.add(textPass);

        JPanel panelPrice = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPrice.add(new JLabel("Стоимость -"));
        JTextField textPrice = new JTextField(null, 8);
        panelPrice.add(textPrice);

        JPanel panelInStock = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInStock.add(new JLabel("На складе -"));
        JTextField textInStock = new JTextField(null, 8);
        panelInStock.add(textInStock);

        jPanel.add(panelBrand);
        jPanel.add(panelPass);
        jPanel.add(panelPrice);
        jPanel.add(panelInStock);

        add(jPanel);

        JButton buttonCreate = new JButton("Создать");
        buttonCreate.addActionListener(event -> {
            Car newCar1 = new Car(textBrand.getText(), Integer.parseInt(textPass.getText()), Integer.parseInt(textPrice.getText()), Integer.parseInt(textInStock.getText()));
            motorShow.addCar(newCar1);
//            System.out.println(motorShow.getCars().size());
            DefaultListModel<String> model = new DefaultListModel<>();
            for (int i = 0; i < motorShow.getCars().size(); i++) {
                model.addElement(String.valueOf(motorShow.getCars().get(i).getBrand()));
            }
            jlist.setModel(model);
            setVisible(false);

        });
        JPanel jPanel1 = new JPanel();
        jPanel1.add(buttonCreate);
        add(jPanel1, BorderLayout.SOUTH);

        setSize(250, 300);
    }
}