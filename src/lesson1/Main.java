package lesson1;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> staffs = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm mới");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("1. Giảng viên");
                    System.out.println("2. Nhân viên hành chính");
                    System.out.print("Chọn loại: ");

                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Lương cơ bản: ");
                    double baseSalary =
                            Double.parseDouble(sc.nextLine());

                    if (type == 1) {

                        System.out.print("Số giờ giảng: ");
                        int hours =
                                Integer.parseInt(sc.nextLine());

                        staffs.add(
                                new Lecturer(
                                        id,
                                        name,
                                        baseSalary,
                                        hours
                                )
                        );

                    } else if (type == 2) {

                        System.out.print("Thưởng: ");
                        double bonus =
                                Double.parseDouble(sc.nextLine());

                        staffs.add(
                                new AdminStaff(
                                        id,
                                        name,
                                        baseSalary,
                                        bonus
                                )
                        );
                    }

                    System.out.println("Thêm thành công!");
                    break;

                case 2:

                    if (staffs.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {

                        for (Staff s : staffs) {
                            s.showInfo();
                            System.out.println("----------------");
                        }
                    }
                    break;

                case 3:

                    System.out.print("Nhập ID cần sửa: ");
                    int updateId =
                            Integer.parseInt(sc.nextLine());

                    boolean found = false;

                    for (Staff s : staffs) {

                        if (s.getId() == updateId) {

                            System.out.print("Tên mới: ");
                            String newName = sc.nextLine();

                            System.out.print("Lương cơ bản mới: ");
                            double newSalary =
                                    Double.parseDouble(
                                            sc.nextLine());

                            if (s instanceof Lecturer) {

                                System.out.print(
                                        "Giờ giảng mới: ");

                                int newHours =
                                        Integer.parseInt(
                                                sc.nextLine());

                                ((Lecturer) s).update(
                                        newName,
                                        newSalary,
                                        newHours
                                );

                            } else if (s instanceof AdminStaff) {

                                System.out.print(
                                        "Thưởng mới: ");

                                double newBonus =
                                        Double.parseDouble(
                                                sc.nextLine());

                                ((AdminStaff) s).update(
                                        newName,
                                        newSalary,
                                        newBonus
                                );
                            }

                            found = true;
                            System.out.println(
                                    "Cập nhật thành công!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy!");
                    }

                    break;

                case 4:

                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId =
                            Integer.parseInt(sc.nextLine());

                    boolean removed =
                            staffs.removeIf(
                                    s -> s.getId() == deleteId);

                    if (removed) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }

                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}