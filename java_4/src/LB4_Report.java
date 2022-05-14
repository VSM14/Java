import java.io.IOException;

public class LB4_Report {
    public static void main(String[] args) throws IOException {
        MotorShow Ralf = new MotorShow("Ralf");

        Car Porsche = new Car("Porsche", 2, 60000, 2);
        Car BMV = new Car("BMV", 5, 23000, 4);
        Ralf.addCar(Porsche);
        Ralf.addCar(BMV);

        ApplicationDiscount A_Application = new ApplicationDiscount(Porsche, "Иванов Иван Иванович",
                "8-800-555-35-35", 6);
        Porsche.addApplication(A_Application);
        ApplicationNoDiscount B_Application = new ApplicationNoDiscount(Porsche, "Петров Петр Петрович",
                "8-800-555-35-36");
        Porsche.addApplication(B_Application);
        ApplicationNoDiscount C_Application = new ApplicationNoDiscount(Porsche, "Александров Александр Александрович",
                "8-800-555-35-37");
        Porsche.addApplication(C_Application);

        ApplicationDiscount D_Application = new ApplicationDiscount(BMV, "Васильев Михаил Петрович",
                "8-800-555-35-38", 10);
        BMV.addApplication(D_Application);
        ApplicationNoDiscount E_Application = new ApplicationNoDiscount(BMV, "Кондратьев Владимир Тимурович",
                "8-800-555-35-39");
        BMV.addApplication(E_Application);

        MotorShowReport.MadeReport(Ralf);
        MotorShowReport.ReadReport(Ralf);
    }
}
