package com.gildedrose;

public class Item {

  public static final int MAX_QUALITY_PRODUCT = 50;
  public static final int MIN_QUALITY_PRODUCT = 0;

  public static final int EXPIRY_DATE = 0;
  public static final int BACKSTAGE_PASSES_LIMIT_10 = 10;
  public static final int BACKSTAGE_PASSES_LIMIT_5 = 5;

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public String name;

  public int sellIn;

  public int quality;

  /**
   * Constructeur de la classe Item.
   * @param name Nom du produit.
   * @param sellIn Nombre de jours dans lesquels le produit doit être vendu.
   * @param quality Qualité du produit.
   */
  public Item(String name, int sellIn, int quality) {
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
  }

  /**
   * Retourne une chaîne de caractères représentant le produit.
   * @return Chaîne de caractères représentant le produit.
   */
  @Override
  public String toString() {
      return this.name + ", " + this.sellIn + ", " + this.quality;
  }
  /**
   * Met à jour la qualité du produit.
   */
  public void updateQuality() {
    switch (this.name) {
      case AGED_BRIE:
        this.sellIn = this.sellIn - 1;

        this.quality = Math.min(this.quality + (this.sellIn >= EXPIRY_DATE ? 1 : 2), MAX_QUALITY_PRODUCT);

        break;
      case BACKSTAGE_PASSES:
        this.sellIn = this.sellIn - 1;

        this.quality =  (this.sellIn < EXPIRY_DATE) ? 0 :
                        (this.sellIn < BACKSTAGE_PASSES_LIMIT_5) ? Math.min(this.quality + 3, MAX_QUALITY_PRODUCT) :
                        (this.sellIn < BACKSTAGE_PASSES_LIMIT_10) ? Math.min(this.quality + 2, MAX_QUALITY_PRODUCT) :
                        Math.min(this.quality + 1, MAX_QUALITY_PRODUCT);

        break;
      case SULFURAS:
        break;
      default:
        this.sellIn -= 1;

        this.quality = Math.max(this.quality - (this.sellIn >= EXPIRY_DATE ? 1 : 2), MIN_QUALITY_PRODUCT);

        break;
    }
  }
}
