

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SweetService service = new SweetService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Sweet\n2. View Sweets\n3. Purchase\n4. Restock\n5. Exit");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.println("Enter ID, Name, Category, Price, Quantity:");
                    service.addSweet(new Sweet(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextInt()));
                }
                case 2 -> service.getAllSweets().forEach(System.out::println);
                case 3 -> {
                    System.out.println("Enter ID and Quantity:");
                    service.purchaseSweet(sc.nextInt(), sc.nextInt());
                }
                case 4 -> {
                    System.out.println("Enter ID and Quantity:");
                    service.restockSweet(sc.nextInt(), sc.nextInt());
                }
                case 5 -> System.exit(0);
            }
        }
    }
}
