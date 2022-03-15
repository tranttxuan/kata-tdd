package tdd.gildedRose;

// https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt
public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras")) {
                continue;
            } else {
                item.sellIn = updateSellIn(item);
                if (item.name.equals("Aged Brie")) {
                    int newQualify = (int) item.qualify + 1;
                    newQualify = validateQuality(newQualify);
                    item.qualify = newQualify;
                } else if (item.name.equals("Backstage passes") && item.sellIn <= 10 && item.sellIn > 5) {
                    int newQualify = (int) item.qualify + 2;
                    newQualify = validateQuality(newQualify);
                    item.qualify = newQualify;
                } else if (item.name.equals("Backstage passes") && item.sellIn <= 5 && item.sellIn > 0) {
                    int newQualify = (int) item.qualify + 3;
                    newQualify = validateQuality(newQualify);
                    item.qualify = newQualify;
                } else if (item.name.equals("Backstage passes") && item.sellIn <= 0) {
                    item.qualify = 0;
                } else if (item.name.equals("Conjured")) {
                    int newQualify = (int) item.qualify / 4;
                    newQualify = validateQuality(newQualify);
                    item.qualify = newQualify;
                } else {
                    int newQualify = (int) item.qualify / 2;
                    newQualify = validateQuality(newQualify);
                    item.qualify = newQualify;
                }
            }
        }
    }

    private int updateSellIn(Item item){
        return item.sellIn - 1;
    }
    private int validateQuality(int qualify){
        if (qualify > 50) return qualify = 50;
        if (qualify < 0) return qualify = 0;
        return qualify;
    }
}
