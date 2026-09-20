import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Fiat");
        System.out.println(cars.size());
        System.out.println(cars.contains("BMW"));
        System.out.println(cars.get(2));
        System.out.println(cars.indexOf("Fiat"));
        System.out.println(cars.isEmpty());
        for (String car : cars) {
            System.out.println(car);
        }
        cars.remove("BMW");
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
