package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void simpleItemShouldDecreaseQuality() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 7)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Elixir of the Mongoose", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(6, app.items[0].quality);
  }

  @Test
  void simpleItemShouldDecreaseQualityTwiceAsFastAfterSpoiling() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", -1, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Elixir of the Mongoose", app.items[0].name);
    assertEquals(-2, app.items[0].sellIn);
    assertEquals(8, app.items[0].quality);
  }

  @Test
  void conjuredItemsShouldSpoilTwiceAsFast() {
    final Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Conjured Mana Cake", app.items[0].name);
    assertEquals(2, app.items[0].sellIn);
    assertEquals(4, app.items[0].quality);
  }

  @Test
  void shouldNeverAlterSulfuras() {
    final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
    assertEquals(10, app.items[0].sellIn);
    assertEquals(80, app.items[0].quality);
  }

  @Test
  void shouldIncreaseQualityForBrie() {
    final Item[] items = new Item[] {new Item("Aged Brie", 5, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Aged Brie", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(11, app.items[0].quality);
  }

    @Test
  void shouldNotIncreaseQualityForBrieIfAlready50() {
    final Item[] items = new Item[] {new Item("Aged Brie", 5, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Aged Brie", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
  }

  @Test
  void shouldIncreaseQualityForBackstagePassesIfNotExpiredForLessThan11Days() {
          final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    assertEquals(9, app.items[0].sellIn);
    assertEquals(12, app.items[0].quality);
  }

    @Test
  void shouldIncreaseQualityForBackstagePassesIfNotExpiredForLessThan3Days() {
          final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(13, app.items[0].quality);
  }

    @Test
  void shouldSetQualityToZeroForBackstagePassesIExpired() {
          final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    assertEquals(-2, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }
}
