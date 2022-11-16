import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static boolean isYearLeap(int year) {
        boolean leapYear;
        leapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        return leapYear;
    }

    public static void isPhoneAppUpdate(int clientOS, int yearPhoneManufacture) {
        int currentYear = LocalDate.now().getYear();

        if ((clientOS == 0 || clientOS == 1) && yearPhoneManufacture == currentYear) {
            System.out.println(clientOS == 0 ? "Установите версию приложения для iOS по ссылке\n" : "Установите версию приложения для Android по ссылке\n");
        } else if (clientOS == 0 && yearPhoneManufacture < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке\n");
        } else if (clientOS == 1 && yearPhoneManufacture < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке\n");
        } else {
            System.out.println("Неверно введён номер ОС. Пожалуйста, повторите Вашу попытку позже.\n");
        }

    }

    public static int isDaysDelivery (int deliveryDistance){
        int daysToDelivery = 0;

        if (deliveryDistance >= 0 && deliveryDistance <= 20) {
            daysToDelivery += 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            daysToDelivery += 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            daysToDelivery += 3;
        }
        return daysToDelivery;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Task 1
        System.out.print("Введите год: ");
        int year = sc.nextInt();
        if (isYearLeap(year)) {
            System.out.println(year + " является високосным\n");
        } else {
            System.out.println(year + " не является високосным\n");
        }

        //Task 2
        System.out.print("Пожалуйста, выберите номер своей операционной системы: ");
        System.out.println("\n0 - iOS");
        System.out.println("1 - Android");
        int clientOS = sc.nextInt();

        if (clientOS != 1 && clientOS != 0) {
            System.out.println("Неверно введён номер ОС. Пожалуйста, повторите Вашу попытку позже.\n");
        } else {
            System.out.print("Введите год производства Вашего телефона: ");
            int yearPhoneManufacture = sc.nextInt();
            isPhoneAppUpdate(clientOS, yearPhoneManufacture);
        }

        //Task 3
        System.out.println("Введите дистанцию до клиента (в км): ");
        int deliveryDays = isDaysDelivery(sc.nextInt());

        if (deliveryDays == 0) {
            System.out.println("Забрать карту можно только при личном посещении отделения банка.");
        } else {
            System.out.println("Потребуется дней: " + deliveryDays);
        }

    }
}