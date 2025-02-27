package com.gildedrose;

public class UpdatableFactory {

    private UpdatableFactory() {
    }

    public static Updatable toUpdatable(final Item item) {
        return switch (EItemName.getByName(item.name)) {
            case BACKSTAGE -> new ItemBackstage(item);
            case SULFURAS -> new ItemSulfuras(item);
            case BRIE -> new ItemBrie(item);
            case GENERIC -> new ItemGeneric(item);
        };
    }
}
