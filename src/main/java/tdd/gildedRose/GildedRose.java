package tdd.gildedRose;

// https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt
public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            InventoryItem inventoryItem = InventoryItem.create(item);
            inventoryItem.dailyUpdate(item);
        }
    }

}
