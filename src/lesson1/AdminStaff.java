package lesson1;
public class AdminStaff extends Staff implements ICapability {

    private double bonus;

    public AdminStaff(int id, String name,
                      double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        System.out.println("Đánh giá nhân viên hành chính.");
    }

    @Override
    public void showInfo() {
        System.out.println("=== NHÂN VIÊN HÀNH CHÍNH ===");
        super.showInfo();
        System.out.println("Thưởng: " + bonus);
    }

    public void update(String name,
                       double baseSalary,
                       double bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }
}