import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MotorShowReport {

    public static void MadeReport(MotorShow motorShow) throws IOException {

        String filename = String.format("%s lb4.txt", motorShow.Title);

        FileOutputStream fileOutput = new FileOutputStream(filename);
        String s;
        s = "ОТЧЁТ ПО АВТОСАЛОНУ " + motorShow.Title + "\n\n";
        for (int i = 0; i < motorShow.cars.size(); i++) {
            s += "Автомобиль: " + motorShow.getCars().get(i).getBrand() + ", Стоимость " + motorShow.getCars().get(i).getPrice() + "$, "
                    + "Пассажиры: " + motorShow.getCars().get(i).getMaxPassenger() + "\nЗаявки (" + motorShow.getCars().get(i).getApplications().size() + "):\n";
            for (int j = 0; j < motorShow.getCars().get(i).getApplications().size(); j++) {
                s += motorShow.getCars().get(i).getApplications().get(j).getFIO() + " | " + motorShow.getCars().get(i).getApplications().get(j).getPhoneNumber() + "\n";
            }
            s += "-------------\nВ наличии: " + motorShow.getCars().get(i).isInStock() + " (" + motorShow.getCars().get(i).getInStock() + ")" + "\n\n";
        }
        fileOutput.write(s.getBytes());
    }

    public static void ReadReport(MotorShow motorShow) throws IOException {
        String filename = String.format("%s lb4.txt", motorShow.Title);
        FileInputStream fileInput = new FileInputStream(filename);
        int a = fileInput.available();
        byte[] b = new byte[a];
        fileInput.read(b);
        fileInput.close();
        System.out.println(new String(b));
    }
}