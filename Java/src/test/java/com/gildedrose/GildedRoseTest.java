package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static Item[] getItems() {
        return new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80), //
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), //
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), //
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49), //
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };
    }

    @Test
    void test2Days() {

        GildedRose app = new GildedRose(getItems());

        for (int i = 0; i < 2; i++) {
            app.updateQuality();

        }

//        +5 Dexterity Vest, 8, 18
        assertEquals(8, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
//        Aged Brie, 0, 2
        assertEquals(0, app.items[1].sellIn);
        assertEquals(2, app.items[1].quality);
//        Elixir of the Mongoose, 3, 5
        assertEquals(3, app.items[2].sellIn);
        assertEquals(5, app.items[2].quality);
//        Sulfuras, Hand of Ragnaros, 0, 80
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
//        Sulfuras, Hand of Ragnaros, -1, 80
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
//        Backstage passes to a TAFKAL80ETC concert, 13, 22
        assertEquals(13, app.items[5].sellIn);
        assertEquals(22, app.items[5].quality);
//        Backstage passes to a TAFKAL80ETC concert, 8, 50
        assertEquals(8, app.items[6].sellIn);
        assertEquals(50, app.items[6].quality);
//        Backstage passes to a TAFKAL80ETC concert, 3, 50
        assertEquals(3, app.items[7].sellIn);
        assertEquals(50, app.items[7].quality);
//        Conjured Mana Cake, 1, 2
        assertEquals(1, app.items[8].sellIn);
        assertEquals(2, app.items[8].quality);
    }

    @Test
    void test11Days() {

        GildedRose app = new GildedRose(getItems());

        for (int i = 0; i < 11; i++) {
            app.updateQuality();

        }

        // +5 Dexterity Vest, -1, 8
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //    Aged Brie, -9, 20
        assertEquals(-9, app.items[1].sellIn);
        assertEquals(20, app.items[1].quality);
        // Elixir of the Mongoose, -6, 0
        assertEquals(-6, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
        // Sulfuras, Hand of Ragnaros, 0, 80
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
        // Sulfuras, Hand of Ragnaros, -1, 80
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
        // Backstage passes to a TAFKAL80ETC concert, 4, 38
        assertEquals(4, app.items[5].sellIn);
        assertEquals(38, app.items[5].quality);
        // Backstage passes to a TAFKAL80ETC concert, -1, 0
        assertEquals(-1, app.items[6].sellIn);
        assertEquals(0, app.items[6].quality);
        // Backstage passes to a TAFKAL80ETC concert, -6, 0
        assertEquals(-6, app.items[7].sellIn);
        assertEquals(0, app.items[7].quality);
        // Conjured Mana Cake, -8, 0
        assertEquals(-8, app.items[8].sellIn);
        assertEquals(0, app.items[8].quality);
    }

    @Test
    void test30Days() {

        GildedRose app = new GildedRose(getItems());

        for (int i = 0; i < 30; i++) {
            app.updateQuality();
        }

        // +5 Dexterity Vest, -20, 0
        assertEquals(-20, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        //    Aged Brie, -28, 50
        assertEquals(-28, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
        //    Elixir of the Mongoose, -25, 0
        assertEquals(-25, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
        //    Sulfuras, Hand of Ragnaros, 0, 80
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
        //    Sulfuras, Hand of Ragnaros, -1, 80
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(80, app.items[4].quality);
        //    Backstage passes to a TAFKAL80ETC concert, -15, 0
        assertEquals(-15, app.items[5].sellIn);
        assertEquals(0, app.items[5].quality);
        //    Backstage passes to a TAFKAL80ETC concert, -20, 0
        assertEquals(-20, app.items[6].sellIn);
        assertEquals(0, app.items[6].quality);
        //    Backstage passes to a TAFKAL80ETC concert, -25, 0
        assertEquals(-25, app.items[7].sellIn);
        assertEquals(0, app.items[7].quality);
        //    Conjured Mana Cake, -27, 0
        assertEquals(-27, app.items[8].sellIn);
        assertEquals(0, app.items[8].quality);
    }

}
