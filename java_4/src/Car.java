import java.util.ArrayList;

public class Car implements java.io.Serializable {
    private String Brand;

    public void setBrand(String newBrand) {
        Brand = newBrand;
    }

    public String getBrand() {
        return Brand;
    }

    private int MaxPassenger;

    public void setMaxPassenger(int newMaxPassenger) {
        MaxPassenger = newMaxPassenger;
    }

    public int getMaxPassenger() {
        return MaxPassenger;
    }

    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int newPrice) {
        Price = newPrice;
    }

    private int InStock;

    public int getInStock() {
        return InStock;
    }

    public boolean isInStock() {
        return InStock > 0;
    }

    public void setInStock(int newInStock) {
        InStock = newInStock;
    }

    public ArrayList<Application> applications = new ArrayList();

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }
    public void removeApplication(Application application) {
        applications.remove(application);
    }


    public Car() {
    }

    public Car(String Brand, int MaxPassenger, int Price, int InStock) {
        this.Brand = Brand;
        this.MaxPassenger = MaxPassenger;
        this.Price = Price;
        this.InStock = InStock;
    }
}