package tdd.gildedRose;

import java.util.Objects;

public class Item {
    public String name;
    public int sellIn;
    public int qualify;

    public Item(String name, int sellIn, int qualify) {
        this.name = name;
        this.sellIn = sellIn;
        this.qualify = qualify;
    }

    @Override
    public String toString() {
        return this.name +" - sellin:  "+ this.sellIn +" - quality: "+this.qualify;
    }
}
