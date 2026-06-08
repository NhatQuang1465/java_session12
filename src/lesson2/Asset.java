package lesson2;
public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public abstract double getMarketValue();

    public void showInfo() {
        System.out.println("Mã tài sản: " + assetCode);
        System.out.println("Tên: " + name);
        System.out.println("Giá mua: " + purchasePrice);
    }
}