package tdd.gildedRose;

public class InventoryItem {
    protected final Item item;

    public static InventoryItem create(Item item) {
        if (item.name.equals(SulfurasItem.ITEM_NAME))
            return new SulfurasItem(item);
        if (item.name.equals(AgedBrieItem.ITEM_NAME))
            return new AgedBrieItem(item);
        if (item.name.equals(BackstagePasses.ITEM_NAME))
            return new BackstagePasses(item);
        if (item.name.equals(ConjuredItem.ITEM_NAME))
            return new ConjuredItem(item);
        return new InventoryItem(item);
    }

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void dailyUpdate(Item item) {
            int newQualify = (int) item.qualify / 2;
            newQualify = validateUpdatedQuality(newQualify);
            item.qualify = newQualify;
    }

    protected int validateUpdatedQuality(int qualify) {
        if (qualify > 50) return 50;
        if (qualify < 0) return 0;
        return qualify;
    }
}
