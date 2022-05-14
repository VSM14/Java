public class ApplicationNoDiscount extends Application implements java.io.Serializable {

    public ApplicationNoDiscount() {
    }

    public ApplicationNoDiscount(Car car, String FIO, String PhoneNumber) {
        super(car, FIO, PhoneNumber);
    }

    @Override
    public double getDiscount() {
        return 0;
    }

    @Override
    public void setDiscount(double text) {
    }

    public double getOrderValue() {
        try {
            if (this.getCar().getInStock() == 0) throw new MyException.KolvoAvtomobileyException("");
            return getCar().getPrice();
        } catch (MyException.KolvoAvtomobileyException ex) {
            System.out.println("   ОШИБКА: нет автомобилей");
        }
        return -1;
    }
}
