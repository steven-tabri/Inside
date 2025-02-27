package com.gildedrose;

public final class ItemSulfuras extends AbsItemEnhanced {
    public ItemSulfuras(final Item item) {
        super(item);
    }

    @Override
    boolean isUpdatable() {
        return false;
    }

    @Override
    int computeQualityDelta() {
        return 0;
    }
}
