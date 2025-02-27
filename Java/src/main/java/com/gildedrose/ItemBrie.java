package com.gildedrose;

public final class ItemBrie extends AbsItemEnhanced {
    public ItemBrie(final Item item) {
        super(item);
    }

    @Override
    int computeQualityDelta() {
        int delta = 1;
        if (getSellIn() < 0) {
            ++delta;
        }
        return delta;
    }
}
