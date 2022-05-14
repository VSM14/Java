import javax.swing.*;
import java.awt.*;

public class DialogCarEdit extends JDialog {
    public DialogCarEdit(JFrame jFrame, MotorShow motorShow, Car car, JList<String> jlist) {
        super(jFrame, "CarEdit", true);

        JPanel jPanel = new JPanel(new VerticalLayout());

        jPanel.add(new JLabel("Введите новые свойства автомобиля " + car.getBrand()));

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

        JButton buttonEdit = new JButton("Изменить");
        buttonEdit.addActionListener(event -> {

            if (!textBrand.getText().trim().equals("")) car.setBrand(textBrand.getText().trim());
            if (!textPass.getText().trim().equals("")) car.setMaxPassenger(Integer.parseInt(textPass.getText()));
            if (!textPrice.getText().trim().equals("")) car.setPrice(Integer.parseInt(textPrice.getText()));
            if (!textInStock.getText().trim().equals("")) car.setInStock(Integer.parseInt(textInStock.getText()));

            DefaultListModel<String> model = new DefaultListModel<>();
            for (int i = 0; i < motorShow.getCars().size(); i++) {
                model.addElement(String.valueOf(motorShow.getCars().get(i).getBrand()));
            }
            jlist.setModel(model);

            setVisible(false);

        });
        JPanel jPanel1 = new JPanel();
        jPanel1.add(buttonEdit);
        add(jPanel1, BorderLayout.SOUTH);

        setSize(300, 250);
    }
}
