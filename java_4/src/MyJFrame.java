import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyJFrame extends JFrame {

    public MyJFrame(MotorShow motorShow) {

        super("Автосалон: \"" + motorShow.Title + "\"");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame jFrame = new JFrame();
        JTabbedPane jTabbedPane = new JTabbedPane();
        jFrame.add(jTabbedPane);
        String[] massBrand = new String[motorShow.getCars().size()];
        for (int i = 0; i < motorShow.getCars().size(); i++)
            massBrand[i] = String.valueOf(motorShow.getCars().get(i).getBrand());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>();
        for (String s : massBrand) listModel.addElement(s);

        list.setModel(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

        JPanel panelIsInStock = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIsInStock.add(new JLabel("Наличие -"));
        JTextField textIsInStock = new JTextField(null, 8);
        panelIsInStock.add(textIsInStock);


        JPanel panel1 = new JPanel(new VerticalLayout()) {
        };
        panel1.add(new JLabel("Список автомобилей"));
        panel1.add(list);

        panel1.add(panelBrand);
        panel1.add(panelPass);
        panel1.add(panelPrice);
        panel1.add(panelInStock);
        panel1.add(panelIsInStock);

        jTabbedPane.add(panel1, "Информация об автомобиле");

        JPanel panel2 = new JPanel(new VerticalLayout()) {
        };


        JPanel panel2Header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2Header.add(new JLabel("Заявки к автомобилю -"));
        JTextField panel2Car = new JTextField(null, 8);
        panel2Header.add(panel2Car);
        panel2.add(panel2Header);


        jTabbedPane.add(panel2, "Заявки");


        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table1 = new JTable(tableModel);
        tableModel.addColumn("ФИО");
        tableModel.addColumn("Номер телефона");

        table1.setPreferredScrollableViewportSize(new Dimension(500, 100));
//        table1.setFillsViewportHeight(true);
        final Car[] pickedCarr = new Car[1];
        panel2.add((new JScrollPane(table1)));
        //слушатель списка на 1 вкладке
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selected = list.locationToIndex(e.getPoint());
                    Car pickedCar = motorShow.getCars().get(selected);
                    pickedCarr[0] = pickedCar;

                    textBrand.setText(String.valueOf(pickedCar.getBrand()));
                    panel2Car.setText(String.valueOf(pickedCar.getBrand()));
                    textPass.setText(String.valueOf((pickedCar.getMaxPassenger())));
                    textPrice.setText(pickedCar.getPrice() + "$");
                    textInStock.setText(String.valueOf(pickedCar.getInStock()));
                    textIsInStock.setText(String.valueOf(pickedCar.isInStock()));

                    tableModel.setRowCount(0);
                    for (int i = 0; i < pickedCar.applications.size(); i++) {
                        tableModel.addRow(new Object[]{pickedCar.applications.get(i).getFIO(), pickedCar.applications.get(i).getPhoneNumber()});
                    }
                }
            }
        });
        JPanel panelRadio = new JPanel(new VerticalLayout());
        JRadioButton rb1 = new JRadioButton("Со стенда");
        JRadioButton rb2 = new JRadioButton("Отложенная поставка");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);

        JPanel panelDelivery = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDelivery.add(rb1);
        panelDelivery.add(rb2);
        JLabel jLabel = new JLabel("Скидка -");
        panelDelivery.add(jLabel);
        JTextField textPriceDelivery = new JTextField(null, 8);
        panelDelivery.add(textPriceDelivery);
        panelRadio.add(panelDelivery);

        panel2.add(panelRadio);
        final int[] row = new int[1];
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                textPriceDelivery.setText(null);
                row[0] = table1.rowAtPoint(evt.getPoint());
                if (pickedCarr[0].applications.get(row[0]) instanceof ApplicationNoDiscount) {
                    rb1.setSelected(true);
                    textPriceDelivery.setEnabled(false);
                    jLabel.setEnabled(false);
                }
                if (pickedCarr[0].applications.get(row[0]) instanceof ApplicationDiscount) {
                    textPriceDelivery.setEnabled(true);
                    jLabel.setEnabled(true);
                    textPriceDelivery.setText(pickedCarr[0].applications.get(row[0]).getDiscount() + "%");
                    rb2.setSelected(true);
                }
            }
        });

        JButton jButton1 = new JButton("Рассчитать стоимость");
        jButton1.addActionListener(e -> JOptionPane.showMessageDialog(jTabbedPane, pickedCarr[0].applications.get(row[0]).getOrderValue() + "$"));
        panel2.add(jButton1);

        getContentPane().add(jTabbedPane);

        class ActionListenerCarCreate implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new DialogCarCreate(jFrame, motorShow, list);
                dialog.setVisible(true);
            }
        }
        class ActionListenerAppCreate implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new DialogAppCreate(jFrame, pickedCarr[0]);
                dialog.setVisible(true);
            }
        }
        class ActionListenerCarEdit implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new DialogCarEdit(jFrame, motorShow, pickedCarr[0], list);
                dialog.setVisible(true);
            }
        }
        class ActionListenerAppEdit implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new DialogAppEdit(jFrame, pickedCarr[0], pickedCarr[0].applications.get(row[0]));
                dialog.setVisible(true);
            }
        }
        class ActionListenerCarRemove implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                motorShow.removeCar(pickedCarr[0]);
                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < motorShow.getCars().size(); i++) {
                    model.addElement(String.valueOf(motorShow.getCars().get(i).getBrand()));
                }
                list.setModel(model);
            }
        }
        class ActionListenerAppRemove implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                pickedCarr[0].removeApplication(pickedCarr[0].applications.get(row[0]));
                tableModel.removeRow(row[0]);
            }
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu jMenuFile = new JMenu("Файл");
        JMenu jMenuCreate = new JMenu("Создать");
        JMenu jMenuEdit = new JMenu("Редактировать");
        JMenu jMenuRemove = new JMenu("Удалить");
        menuBar.add(jMenuFile);
        menuBar.add(jMenuCreate);
        menuBar.add(jMenuEdit);
        menuBar.add(jMenuRemove);

        JMenuItem menuCarCreate = new JMenuItem("CarCreate");
        menuCarCreate.addActionListener(new ActionListenerCarCreate());
        JMenuItem menuAppCreate = new JMenuItem("AppCreate");
        menuAppCreate.addActionListener(new ActionListenerAppCreate());
        JMenuItem menuCarEdit = new JMenuItem("CarEdit");
        menuCarEdit.addActionListener(new ActionListenerCarEdit());
        JMenuItem menuAppEdit = new JMenuItem("AppEdit");
        menuAppEdit.addActionListener(new ActionListenerAppEdit());
        JMenuItem menuCarRemove = new JMenuItem("CarRemove");
        menuCarRemove.addActionListener(new ActionListenerCarRemove());
        JMenuItem menuAppRemove = new JMenuItem("AppRemove");
        menuAppRemove.addActionListener(new ActionListenerAppRemove());

        jMenuCreate.add(menuCarCreate);
        jMenuCreate.add(menuAppCreate);
        jMenuEdit.add(menuCarEdit);
        jMenuEdit.add(menuAppEdit);
        jMenuRemove.add(menuCarRemove);
        jMenuRemove.add(menuAppRemove);

        JMenuItem exitItem = new JMenuItem("Выход");
        jMenuFile.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));

        JButton buttonCaeCreate = new JButton("CarCreate");
        buttonCaeCreate.addActionListener(new ActionListenerCarCreate());
        panel1.add(buttonCaeCreate);
        JButton buttonCaeEdit = new JButton("CarEdit");
        buttonCaeEdit.addActionListener(new ActionListenerCarEdit());
        panel1.add(buttonCaeEdit);
        JButton buttonCaeRemove = new JButton("CarRemove");
        buttonCaeRemove.addActionListener(new ActionListenerCarRemove());
        panel1.add(buttonCaeRemove);

        JButton jButtonAppCreate = new JButton("AppCreate");
        jButtonAppCreate.addActionListener(new ActionListenerAppCreate());
        panel2.add(jButtonAppCreate);
        JButton jButtonAppEdit = new JButton("AppEdit");
        jButtonAppEdit.addActionListener(new ActionListenerAppEdit());
        panel2.add(jButtonAppEdit);
        JButton jButtonAppRemove = new JButton("AppRemove");
        jButtonAppRemove.addActionListener(new ActionListenerAppRemove());
        panel2.add(jButtonAppRemove);

        // Вывод окна на экран
        setSize(600, 450);
        setVisible(true);
    }
}
