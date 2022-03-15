package tdd.gildedRose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void updateQualityForANormalItem(){
        Item[] items = new Item[]{
                new Item("Product 1", 1, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  25);
    }

    @Test
    void itemQualityValueNeverMoreThan50(){
        Item[] items = new Item[]{new Item("Product 1", 1, 110),};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  50);
    }

    @Test
    void itemQualityValueNeverNegative(){
        Item[] items = new Item[]{new Item("Product 1", 1, -1),};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  0);
    }

    @Test
    void updateQualityForAAgedBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 10, 10),
                new Item("Aged Brie", 10, 100)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  11);
        assertEquals(items[1].qualify,  50);
    }
    @Test
    void updateQualityForASulfuras(){
        Item[] items = new Item[]{new Item("Sulfuras", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  10);
        assertEquals(items[0].sellIn,  10);
    }

    @Test
    void updateQualityForABackstagePassesWhenSellInIsMoreThan10(){
        Item[] items = new Item[]{
                new Item("Backstage passes", 12, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  11);
    }

    @Test
    void updateQualityForABackstagePassesWhenSellInIsFrom6To10(){
        Item[] items = new Item[]{
                new Item("Backstage passes", 10, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  12);
    }

    @Test
    void updateQualityForABackstagePassesWhenSellInIsFrom1To5(){
        Item[] items = new Item[]{
                new Item("Backstage passes", 5, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  13);
    }

    @Test
    void updateQualityForABackstagePassesWhenSellInIs0(){
        Item[] items = new Item[]{
                new Item("Backstage passes", 0, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  0);
    }

    @Test
    void updateQualityForAConjured(){
        Item[] items = new Item[]{new Item("Conjured", 10, 12)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].qualify,  3);
    }
}