package lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Drink> menu = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm món");
            System.out.println("2. Hiển thị menu");
            System.out.println("3. Áp dụng giảm giá");
            System.out.println("4. Xóa món");
            System.out.println("5. Thống kê");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("1. Coffee");
                    System.out.println("2. Fruit Tea");

                    int type =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Tên món: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price =
                            Double.parseDouble(sc.nextLine());

                    if (type == 1) {

                        menu.add(
                                new Coffee(
                                        id,
                                        name,
                                        price
                                )
                        );

                    } else {

                        menu.add(
                                new FruitTea(
                                        id,
                                        name,
                                        price
                                )
                        );
                    }

                    System.out.println("Thêm thành công!");
                    break;

                case 2:

                    if (menu.isEmpty()) {
                        System.out.println("Menu trống!");
                    } else {

                        for (Drink d : menu) {

                            d.showInfo();
                            d.prepare();

                            System.out.println(
                                    "----------------");
                        }
                    }

                    break;

                case 3:

                    System.out.print(
                            "Nhập % giảm giá: ");

                    double percent =
                            Double.parseDouble(
                                    sc.nextLine());

                    for (Drink d : menu) {
                        d.applyDiscount(percent);
                    }

                    System.out.println(
                            "Áp dụng giảm giá thành công!");

                    break;

                case 4:

                    System.out.print(
                            "Nhập ID món cần xóa: ");

                    String deleteId =
                            sc.nextLine();

                    boolean removed =
                            menu.removeIf(
                                    d -> d.getId()
                                            .equalsIgnoreCase(
                                                    deleteId));

                    if (removed) {
                        System.out.println(
                                "Xóa thành công!");
                    } else {
                        System.out.println(
                                "Không tìm thấy món!");
                    }

                    break;

                case 5:

                    if (menu.isEmpty()) {

                        System.out.println(
                                "Không có dữ liệu!");

                    } else {

                        double total = 0;

                        for (Drink d : menu) {
                            total += d.getPrice();
                        }

                        double average =
                                total / menu.size();

                        System.out.println(
                                "Tổng giá trị menu: "
                                        + total);

                        System.out.println(
                                "Giá trung bình: "
                                        + average);
                    }

                    break;

                case 0:

                    System.out.println(
                            "Thoát chương trình");
                    break;

                default:

                    System.out.println(
                            "Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}