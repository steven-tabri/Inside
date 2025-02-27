package com.gildedrose;

public final class ItemBackstage extends AbsItemEnhanced {
    public ItemBackstage(final Item item) {
        super(item);
    }

    @Override
    int computeQualityDelta() {
        int delta;

        if (getSellIn() < 0) {
            delta = -1 * getQuality();
        } else {
            delta = 1;
            if (getSellIn() < 10) {
                ++delta;
            }

            if (getSellIn() < 5) {
                ++delta;
            }
        }
        return delta;
    }
}
