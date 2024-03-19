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
}
