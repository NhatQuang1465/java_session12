package lesson2;

public class NetworkDevice extends Asset {

    private int numberOfPorts;

    public NetworkDevice(String assetCode,
                         String name,
                         double purchasePrice,
                         int numberOfPorts) {

        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9; // khấu hao 10%
    }

    @Override
    public void showInfo() {
        System.out.println("=== THIẾT BỊ MẠNG ===");
        super.showInfo();
        System.out.println("Số cổng: " + numberOfPorts);
    }
}