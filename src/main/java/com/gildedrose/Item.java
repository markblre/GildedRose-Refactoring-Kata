package com.gildedrose;

public class Item {

  public static final int MAX_QUALITY_PRODUCT = 50;
  public static final int MIN_QUALITY_PRODUCT = 0;

  public static final int EXPIRY_DATE = 0;
  public static final int BACKSTAGE_PASSES_LIMIT_11 = 11;
  public static final int BACKSTAGE_PASSES_LIMIT_6 = 6;

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
  }

  @Override
  public String toString() {
      return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public void updateQuality() {
    if (!this.name.equals(AGED_BRIE)
      && !this.name.equals(BACKSTAGE_PASSES)) {
      if (this.quality > MIN_QUALITY_PRODUCT) {
        if (!this.name.equals(SULFURAS)) {
          this.quality = this.quality - 1;
        }
      }
    } else {
      if (this.quality < MAX_QUALITY_PRODUCT) {
        this.quality = this.quality + 1;

        if (this.name.equals(BACKSTAGE_PASSES)) {
          if (this.sellIn < BACKSTAGE_PASSES_LIMIT_11) {
            if (this.quality < MAX_QUALITY_PRODUCT) {
              this.quality = this.quality + 1;
            }
          }

          if (this.sellIn < BACKSTAGE_PASSES_LIMIT_6) {
            if (this.quality < MAX_QUALITY_PRODUCT) {
              this.quality = this.quality + 1;
            }
          }
        }
      }
    }

    if (!this.name.equals(SULFURAS)) {
      this.sellIn = this.sellIn - 1;
    }

    if (this.sellIn < EXPIRY_DATE) {
      if (!this.name.equals(AGED_BRIE)) {
        if (!this.name.equals(BACKSTAGE_PASSES)) {
          if (this.quality > MIN_QUALITY_PRODUCT) {
            if (!this.name.equals(SULFURAS)) {
              this.quality = this.quality - 1;
            }
          }
        } else {
          this.quality = this.quality - this.quality;
        }
      } else {
        if (this.quality < MAX_QUALITY_PRODUCT) {
          this.quality = this.quality + 1;
        }
      }
    }
  }
}
