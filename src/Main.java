import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Friend friend;
    static List<Friend> friends = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Добавить друга");
            System.out.println("2. Узнать сколько дней осталось до дня рождения друга");
            System.out.println("3. Вывод всех друзей");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    return;
                case 1:
                    addFriend();
                    break;
                case 2:
                    System.out.print("Имя друга: ");
                    String name = scanner.nextLine();
                    for(Friend f : friends) {
                        if (f.getName().equals(name.toLowerCase())) {
                            f.daysBeforeBirthday();
                            break;
                        }
                    }
                    break;
                case 3:
                    getFriends();
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
    }
    static void addFriend(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M d");
        friend = new Friend();
        System.out.print("Имя друга: ");
        friend.setName(scanner.nextLine());
        System.out.print("Введите дату (год месяц день): ");
        friend.setBirthDate(LocalDate.parse(scanner.nextLine(),formatter));
        friends.add(friend);
    }
    static void getFriends(){
        System.out.println("Список друзей:");
        for(Friend f : friends) {
            System.out.println(f);
        }
    }
}