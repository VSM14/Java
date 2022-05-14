public class ApplicationDiscount extends Application implements java.io.Serializable {

    public double Discount;

    public double getDiscount() {
        return Discount;
    }

    @Override
    public void setDiscount(double newDiscount) {
        this.Discount = newDiscount;
    }

    public ApplicationDiscount() {
    }

    public ApplicationDiscount(Car car, String FIO, String PhoneNumber, double Discount) {
        super(car, FIO, PhoneNumber);
        this.Discount = Discount;
    }

    public double getOrderValue() {
        try {
            if (this.getCar().getInStock() == 0) throw new MyException.KolvoAvtomobileyException("");
            return getCar().getPrice() * (1 - Discount / 100);
        } catch (MyException.KolvoAvtomobileyException ex) {
            System.out.println("   ОШИБКА: нет автомобилей");
        }
        return -1;
    }
}
