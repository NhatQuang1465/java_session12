package lesson2;

import java.util.ArrayList;

public class AssetManager {

    private ArrayList<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public Asset search(String assetCode) {

        for (Asset a : assets) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                return a;
            }
        }
        return null;
    }
    public void search(double minPrice) {
        boolean found = false;
        for (Asset a : assets) {
            if (a.getPurchasePrice() > minPrice) {
                a.showInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }
    public void showValue(Asset a) {
        System.out.println(
                "Giá trị hiện tại: " + a.getMarketValue());
    }
}