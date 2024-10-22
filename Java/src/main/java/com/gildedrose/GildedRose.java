package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        updateQualityNew();
    }

    public void updateQualityOld() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }





    protected static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String AGED = "Aged Brie";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    public void updateQualityNew() {

        Arrays.stream(items)
            .filter(item -> !List.of(BACKSTAGE, AGED, SULFURAS).contains(item.name))
            .filter(item -> item.quality > 0)
            .forEach(item -> item.quality--);

        Arrays.stream(items)
            .filter(item -> item.quality < 50)
            .peek(item -> item.quality++)
            .filter(item -> BACKSTAGE.equals(item.name))
            .filter(item -> item.sellIn < 11)
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
        }
    }

}
