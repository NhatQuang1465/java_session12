package lesson1;

public class Lecturer extends Staff implements ICapability {

    private int teachingHours;

    public Lecturer(int id, String name,
                    double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + teachingHours * 200000;
    }

    @Override
    public void checkPerformance() {
        System.out.println("Đánh giá giảng viên dựa trên giờ giảng.");
    }

    @Override
    public void showInfo() {
        System.out.println("=== GIẢNG VIÊN ===");
        super.showInfo();
        System.out.println("Số giờ giảng: " + teachingHours);
    }

    public void update(String name,
                       double baseSalary,
                       int teachingHours) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.teachingHours = teachingHours;
    }
}