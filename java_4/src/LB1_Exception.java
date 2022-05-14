public class LB1_Exception {
    public static void main(String[] args) {

        MotorShow Ralf = new MotorShow("Ralf");
        Car Porsche = new Car("Porsche", 2, 60000, 0);
        ApplicationDiscount A_Application = new ApplicationDiscount(Porsche, "Иванов Иван Иванович",
                "8-800-555-35-35", 6);
        Porsche.addApplication(A_Application);
        ApplicationNoDiscount B_Application = new ApplicationNoDiscount(Porsche, "",//Петров Петр Петрович
                "8-800-555-35-36");
        Porsche.addApplication(B_Application);
        ApplicationNoDiscount C_Application = new ApplicationNoDiscount(Porsche, "",//Александров Александр Александрович
                "8-800-555-35-37");
        Porsche.addApplication(C_Application);

        for (int i = 0; i < Porsche.getApplications().size(); i++) {
            System.out.println("\nЗаявка номер: " + (i + 1));
            System.out.println("Машина: " + Porsche.getBrand());
            System.out.println("ФИО: " + ((Application) Porsche.getApplications().get(i)).getFIO());
            System.out.println("Номер: " + ((Application) Porsche.getApplications().get(i)).getPhoneNumber());
            System.out.println("Стоимость заказа: " + ((Application) Porsche.getApplications().get(i)).getOrderValue());
        }
    }
}
