package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void decreaseSellIn(final Item item) {
        final boolean isNotSulfurasHandOfRagneros = !item.name.equals("Sulfuras, Hand of Ragnaros");

        if (isNotSulfurasHandOfRagneros) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decreaseQuality(final Item item, final int qualityDecrease) {
        item.quality = item.quality - qualityDecrease;
    }

    private void increaseQuality(final Item item, final int qualityIncrease) {
        if (item.quality < 50) {
            item.quality = item.quality + qualityIncrease;
        }
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (isAgedBrie(item) || isBackstageConcert(item)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    handleBackstageQuality(item);
                }
            } else {
                handleQualityDecrease(item);
            }

            decreaseSellIn(item);

            if (item.sellIn < 0) {
                if (isAgedBrie(item)) {
                    increaseQuality(item, 1);
                } else {
                    if (isBackstageConcert(item)) {
                        item.quality = 0;
                    } else {
                        handleQualityDecrease(item);
                    }
                }
            }
        }
    }

    private void handleQualityDecrease(final Item item) {
        if (item.quality > 0) {
            final boolean isNotSulfurasHandOfRagneros = !item.name.equals("Sulfuras, Hand of Ragnaros");
            final boolean isConjured = item.name.startsWith("Conjured");

            if (isConjured) {
                decreaseQuality(item, 2);
            } else {
                if (isNotSulfurasHandOfRagneros) {
                    decreaseQuality(item, 1);
                }
            }
        }
    }

    private boolean isBackstageConcert(final Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(final Item item) {
        return item.name.equals("Aged Brie");
    }

    private void handleBackstageQuality(final Item item) {
        if (isBackstageConcert(item)) {
            final boolean concertInTenOrLessDays = item.sellIn < 11;
            final boolean concertInFiveOrLessDays = item.sellIn < 6;

            if (concertInFiveOrLessDays) {
                increaseQuality(item, 2);
            } else if (concertInTenOrLessDays) {
                increaseQuality(item, 1);
            }
        }
    }

}
