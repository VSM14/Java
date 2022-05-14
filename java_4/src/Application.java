public abstract class Application implements java.io.Serializable {

    private String FIO;

    public String getFIO() {
        try {
            if (FIO == null || FIO.equals("")) throw new MyException.FIOException("");
            return FIO;
        } catch (MyException.FIOException ex) {
            System.out.println("   ОШИБКА: путсое имя");
        }
        return null;
    }

    public void setFIO(String newFIO) {
        this.FIO = newFIO;
    }

    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.PhoneNumber = newPhoneNumber;
    }

    private Car car;

    public void setCar(Car newCar) {
        this.car = newCar;
    }

    public Car getCar() {
        return car;
    }

    abstract public double getOrderValue();

    public Application() {
    }

    public Application(Car car, String FIO, String PhoneNumber) {
        this.car = car;
        this.PhoneNumber = PhoneNumber;
        this.FIO = FIO;
    }

    public abstract double getDiscount();

    public abstract void setDiscount(double text);
}

