package com.gildedrose;

public abstract class AbsItemEnhanced implements Updatable {
    static final int QUALITY_MIN = 0;
    static final int QUALITY_MAX = 50;
    private final Item item;

    protected AbsItemEnhanced(final Item item) {
        this.item = item;
    }

    boolean isUpdatable() {
        return true;
    }

    @Override
    public void updateSellIn() {
        if (isUpdatable()) {
            --item.sellIn;
        }
    }

    @Override
    public void updateQuality() {
        if (isUpdatable()) {
            int quality = item.quality;
            quality += computeQualityDelta();
            item.quality = Math.max(QUALITY_MIN, Math.min(quality, QUALITY_MAX));
        }
    }

    abstract int computeQualityDelta();

    public final int getQuality() {
        return item.quality;
    }

    public final int getSellIn() {
        return item.sellIn;
    }
}
