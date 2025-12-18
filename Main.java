import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private static Map<Address, Short> costPerAddress = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in/*, "CP866"*/);
    private static String input;
    private static final String END = "end";
    private static int sum = 0;

    private static boolean menu() {
        System.out.print(
                "\nЗаполнение нового заказа."
                        + "\nВведите страну: "
        );
        input = scanner.nextLine();
        if (input.equals(END)) {
            return false;
        }
        System.out.print("Введите город: ");
        Address addresInput = new Address(input, scanner.nextLine());
        System.out.print("Введите вес (кг): ");
        int kg = Integer.parseInt(scanner.nextLine());
        var it = costPerAddress.entrySet().iterator();
        boolean delivery = false;
        while (it.hasNext()) {
            var entry = it.next();
            var key = entry.getKey();
            if (
                    key.getCountry().equals(addresInput.getCountry())
                            && key.getCity().equals(addresInput.getCity())
            ) {
                var value = entry.getValue();
                System.out.print(
                        "Стоимость доставки составит: " + value + " руб."
                                + "\nОбщая стоимость всех доставок: " + (sum += (value * kg)) + " руб.\n"
                );
                delivery = true;
                break;
            }
        }
        if (!delivery) {
            System.out.print("Доставки по этому адресу нет\n");
        }
        return true;
    }

    public static void main(String[] args) {
        costPerAddress.put(new Address("Россия", "Казань"), (short) 100);
        costPerAddress.put(new Address("Россия", "Лесные Пеньки"), (short) 1_000);
        while (menu()) ;
    }
}