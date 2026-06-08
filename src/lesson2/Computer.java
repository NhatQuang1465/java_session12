package lesson2;

public class Computer extends Asset {

    private int ram;
    private String cpu;

    public Computer(String assetCode,
                    String name,
                    double purchasePrice,
                    int ram,
                    String cpu) {

        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8; // khấu hao 20%
    }

    @Override
    public void showInfo() {
        System.out.println("=== MÁY TÍNH ===");
        super.showInfo();
        System.out.println("RAM: " + ram + " GB");
        System.out.println("CPU: " + cpu);
    }
}