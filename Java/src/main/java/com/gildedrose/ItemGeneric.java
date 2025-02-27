package com.gildedrose;

public final class ItemGeneric extends AbsItemEnhanced {
    public ItemGeneric(final Item item) {
        super(item);
    }

    @Override
    int computeQualityDelta() {
        int delta = -1;
        if (getSellIn() < 0) {
            delta = delta *2;
        }
        return delta;
    }
}
