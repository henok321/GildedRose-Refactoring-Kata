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

  private void decreaseQuality(final Item item) {
    System.out.println("decrease: " + item);
    final boolean isNotSulfurasHandOfRagneros = !item.name.equals("Sulfuras, Hand of Ragnaros");
    final boolean isConjured = item.name.startsWith("Conjured");

    if (isConjured) {
      item.quality = item.quality - 2;
    } else {

      if (isNotSulfurasHandOfRagneros) {
        item.quality = item.quality - 1;
      }
    }
  }

  public void updateQuality() {
    for (final Item item : items) {

      if (!item.name.equals("Aged Brie")
          && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (item.quality > 0) {
          decreaseQuality(item);
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;

          if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }
          }
        }
      }

      decreaseSellIn(item);

      if (item.sellIn < 0) {
        if (!item.name.equals("Aged Brie")) {
          if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
              decreaseQuality(item);
            }
          } else {
            item.quality = 0;
          }
        } else {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }
      }
    }
  }
}
