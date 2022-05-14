import java.util.ArrayList;

public  class MotorShow implements java.io.Serializable {
    public String Title;

    public MotorShow() {
    }

    public MotorShow(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String newTitle) {
        Title = newTitle;
    }

    public ArrayList<Car> cars = new ArrayList();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

}