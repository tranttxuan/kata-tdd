package tdd.gildedRose;

public class ConjuredItem extends InventoryItem{
    public static final String ITEM_NAME = "Conjured";
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdate(Item item) {
        int newQualify = (int) item.qualify / 4;
        item.qualify = validateUpdatedQuality(newQualify);
    }
}
