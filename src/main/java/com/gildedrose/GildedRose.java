package com.gildedrose;

class GildedRose {
  Item[] items;

  /**
   * Constructeur de la classe GildedRose.
   * @param items Liste des produits du stock.
   */
  public GildedRose(Item[] items) {
    this.items = items;
  }

  /**
   * Appelle la méthode de mise à jour de la qualité de l'ensemble des produits du stock.
   */
  public void updateQuality() {
    for (Item item : items) {
        item.updateQuality();
    }
  }
}
