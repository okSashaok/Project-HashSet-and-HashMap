import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static Map<Address, Short> costPerAddress = new HashMap<>();
    private static Set<String> uniqueCountry = new HashSet<>();
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
        if (costPerAddress.containsKey(addresInput)) {
            uniqueCountry.add(addresInput.getCountry());
            var value = costPerAddress.get(addresInput);
            System.out.print(
                    "Стоимость доставки составит: " + value + " руб."
                            + "\nОбщая стоимость всех доставок: " + (sum += (value * kg)) + " руб.\n"
            );
            System.out.print("Странны в заказах: ");
            for (var itSet = uniqueCountry.iterator(); ; ) {
                System.out.print(itSet.next());
                if (itSet.hasNext()) {
                    System.out.print(", ");
                    continue;
                }
                System.out.print("\n");
                break;
            }
        } else {
            System.out.print("Доставки по этому адресу нет\n");
        }
        return true;
    }

    public static void main(String[] args) {
        costPerAddress.put(new Address("Россия", "Казань"), (short) 100);
        costPerAddress.put(new Address("Россия", "Лесные Пеньки"), (short) 1_000);
        costPerAddress.put(new Address("Франция", "Франкфурт"), (short) 500);
        while (menu()) ;
    }
}