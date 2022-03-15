package tdd.gildedRose;

public class BackstagePasses extends InventoryItem {
    public static final String ITEM_NAME = "Backstage passes";

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdate(Item item) {
        if (item.sellIn <= 0) {
            item.qualify = 0;
        } else {
            int quality_factor;
            if (item.sellIn < 6) {
                quality_factor = 3;
            } else if (item.sellIn < 11) {
                quality_factor = 2;
            } else {
                quality_factor = 1;
            }
            int newQualify = (int) item.qualify + quality_factor;
            item.qualify = validateUpdatedQuality(newQualify);
        }
    }
}
