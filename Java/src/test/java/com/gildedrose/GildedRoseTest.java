package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void foo() {
    final Item[] items = new Item[] {new Item("foo", 0, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
  }

  @Test
  void simpleItemShouldSpoilRegulary() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 7)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Elixir of the Mongoose", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(6, app.items[0].quality);
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
}
