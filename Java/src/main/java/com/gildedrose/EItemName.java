package com.gildedrose;

import java.util.Arrays;

public enum EItemName {
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    GENERIC("");

    private final String name;

    EItemName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EItemName getByName(final String candidate) {
        return Arrays.stream(EItemName.values()).filter(eItemName -> eItemName.getName().equals(candidate)).findAny().orElse(GENERIC);
    }
}
