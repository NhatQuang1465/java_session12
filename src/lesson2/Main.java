package lesson2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AssetManager manager = new AssetManager();

        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập tài sản");
            System.out.println("2. Xuất báo cáo");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Sửa giá mua");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("1. Máy tính");
                    System.out.println("2. Thiết bị mạng");

                    int type =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Mã tài sản: ");
                    String code = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá mua: ");
                    double price =
                            Double.parseDouble(sc.nextLine());

                    if (type == 1) {

                        System.out.print("RAM: ");
                        int ram =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("CPU: ");
                        String cpu = sc.nextLine();

                        manager.addAsset(
                                new Computer(
                                        code,
                                        name,
                                        price,
                                        ram,
                                        cpu
                                )
                        );

                    } else {

                        System.out.print("Số cổng: ");
                        int ports =
                                Integer.parseInt(sc.nextLine());

                        manager.addAsset(
                                new NetworkDevice(
                                        code,
                                        name,
                                        price,
                                        ports
                                )
                        );
                    }

                    System.out.println("Thêm thành công!");
                    break;

                case 2:

                    for (Asset a : manager.getAssets()) {

                        a.showInfo();

                        manager.showValue(a);

                        System.out.println(
                                "----------------");
                    }

                    break;

                case 3:

                    System.out.println("1. Tìm theo mã");
                    System.out.println("2. Tìm theo giá");

                    int searchType =
                            Integer.parseInt(sc.nextLine());

                    if (searchType == 1) {

                        System.out.print("Nhập mã: ");
                        String searchCode =
                                sc.nextLine();

                        Asset result =
                                manager.search(searchCode);

                        if (result != null) {
                            result.showInfo();
                            manager.showValue(result);
                        } else {
                            System.out.println(
                                    "Không tìm thấy!");
                        }

                    } else {

                        System.out.print(
                                "Nhập giá tối thiểu: ");

                        double minPrice =
                                Double.parseDouble(
                                        sc.nextLine());

                        manager.search(minPrice);
                    }

                    break;

                case 4:

                    System.out.print(
                            "Nhập mã tài sản: ");

                    String updateCode =
                            sc.nextLine();

                    Asset asset =
                            manager.search(updateCode);

                    if (asset != null) {

                        System.out.print(
                                "Giá mua mới: ");

                        double newPrice =
                                Double.parseDouble(
                                        sc.nextLine());

                        asset.setPurchasePrice(
                                newPrice);

                        System.out.println(
                                "Cập nhật thành công!");

                    } else {

                        System.out.println(
                                "Không tìm thấy!");
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