import java.io.IOException;

public class LB6_XMLFormat {
    public static void main(String[] args) throws IOException {
        MotorShow Ralf = new MotorShow("Ralf");

        Car Porsche = new Car("Porsche", 2, 60000, 3);
        Car BMV = new Car("BMV", 5, 23000, 2);
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

        SerializationXML serializationxml = new SerializationXML();
        serializationxml.recordObject("file.xml", Ralf);
        MotorShow NewRalf = serializationxml.uploadObject("file.xml");


//проверка
        System.out.println(NewRalf.Title);
        System.out.println(Ralf.Title);

        System.out.println(NewRalf.cars.get(0).getBrand() + " " + NewRalf.cars.get(1).getBrand());
        System.out.println(Ralf.cars.get(0).getBrand() + " " + Ralf.cars.get(1).getBrand());

        System.out.println(NewRalf.cars.get(0).getApplications().get(0).getFIO());
        System.out.println(Ralf.cars.get(1).getApplications().get(1).getFIO());
    }
}
