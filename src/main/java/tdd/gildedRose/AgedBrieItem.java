package tdd.gildedRose;

public class AgedBrieItem extends InventoryItem{
    public static final String ITEM_NAME = "Aged Brie";

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdate(Item item) {
        int newQualify = (int) item.qualify + 1;
        item.qualify = validateUpdatedQuality(newQualify);
    }
}
