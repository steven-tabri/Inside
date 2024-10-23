package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    protected static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String AGED = "Aged Brie";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    protected static final String CONJURED = "Conjured Mana Cake";
    protected static final List<String> LIST_B_A_S = List.of(BACKSTAGE, AGED, SULFURAS);


    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {

        Arrays.stream(items)
            .filter(item -> !LIST_B_A_S.contains(item.name))
            .filter(item -> item.quality > 0)
            .peek(item -> item.quality--)
            .filter(item -> CONJURED.equals(item.name))
            .forEach(item -> item.quality--);

        Arrays.stream(items)
            .filter(item -> LIST_B_A_S.contains(item.name))
            .filter(item -> item.quality < 50)
            .peek(item -> item.quality++)
            .filter(item -> BACKSTAGE.equals(item.name))
            .filter(item -> item.sellIn < 11)
            .filter(item -> item.quality < 50)
            .peek(item -> item.quality++)
            .filter(item -> item.sellIn < 6)
            .filter(item -> item.quality < 50)
            .forEach(item -> item.quality++);

        Arrays.stream(items)
            .filter(item -> !SULFURAS.equals(item.name))
            .forEach(item -> item.sellIn--);

        Arrays.stream(items)
            .filter(item -> item.sellIn < 0)
            .forEach(this::alterQuality);
    }

    protected void alterQuality(Item item) {
        if (AGED.equals(item.name) && item.quality < 50) {
            item.quality++;
        } else if (BACKSTAGE.equals(item.name)) {
            item.quality = 0;
        } else if (!List.of(SULFURAS, AGED).contains(item.name) && item.quality > 0) {
            item.quality--;
            if (CONJURED.equals(item.name) && item.quality > 0) {
                item.quality--;
            }
        }
    }

}
