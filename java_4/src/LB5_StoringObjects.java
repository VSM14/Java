import java.io.IOException;

public class LB5_StoringObjects {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

        Serialization.recordObject("lb5.dat", Ralf);
        Serialization.uploadObject("lb5.dat");

        MotorShow NewRalf = Serialization.returnObject("lb5.dat");

//Проверка
        System.out.println(NewRalf.getCars().get(0).getBrand());
        System.out.println(Ralf.getCars().get(0).getBrand());

        System.out.println(NewRalf.cars.get(0).getApplications().get(0).getFIO());
        System.out.println(Ralf.cars.get(0).getApplications().get(0).getFIO());
    }
}
