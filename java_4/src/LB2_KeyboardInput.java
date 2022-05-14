import java.io.IOException;
import java.util.Scanner;

public class LB2_KeyboardInput {
    public static void main(String[] args) throws IOException {
        System.out.print("\nРабота для класса In \n");
        In in = new In();

        System.out.print("Введите бренд, вместимость, цену автомобиля и наличие: \n");
        Car car1 = new Car(in.InString(), in.InInt(), in.InInt(), in.InInt());

        System.out.println(car1.getBrand() + "\n" + car1.getMaxPassenger() + "\n" + car1.getPrice() + "\n" + car1.getInStock() + "\n");


        System.out.print("\nПовторим для класса Scanner \n");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите бренд, наличие, вместимость и цену автомобиля: \n");
        Car car2 = new Car(scanner.nextLine(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.close();

        System.out.println(car2.getBrand() + "\n" + car2.getMaxPassenger() + "\n" + car2.getPrice() + "\n" + car2.getInStock() + "\n");

    }
}
