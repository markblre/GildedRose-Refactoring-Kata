package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  // Item
  @Test
  @DisplayName("Test de la méthode toString() de la classe Item")
  void testToStringItem() {
    Item element = new Item("product", 10, 25);
    assertEquals("product, 10, 25", element.toString(), "Problème dans la méthode toString de la classe Item.");
  }

  //// PRODUITS
  @Test
  @DisplayName("Test de la mise à jour du nombre de jours restant pour vendre un produit")
  void testMiseAJourNombreDeJoursRestantAvantExpirationProduit() {
    Item element = new Item("product", 10, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.sellIn, "Le nombre de jours restant avant expiration d'un produit doit diminuer de 1 chaque jour.");
  }

  // Produits non périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit non périmé.")
  void testMiseAJourQualiteProduitNonPerime() {
    Item element = new Item("product", 1, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(24, element.quality, "La qualité d'un produit non périmé doit diminuer de 1 chaque jour.");
  }

  // Produits non périmés (tests à la borne inférieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit non périmé avec une qualité initiale de 1.")
  void testMiseAJourQualiteProduitNonPerimeQualiteInitiale1() {
    Item element = new Item("product", 10, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit non périmé avec une qualité initiale de 1 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit non périmé avec une qualité initiale de 0.")
  void testMiseAJourQualiteProduitNonPerimeQualiteInitiale0() {
    Item element = new Item("product", 10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit non périmé avec une qualité initiale de 0 doit être de 0.");
  }

  // Produits périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit périmé.")
  void testMiseAJourQualiteProduitPerime() {
    Item element = new Item("product", 0, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(23, element.quality, "La qualité d'un produit périmé doit diminuer de 2 chaque jour.");
  }

  // Produits périmés (tests à la borne inférieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit périmé avec une qualité initiale de 2.")
  void testMiseAJourQualiteProduitPerimeQualiteInitiale2() {
    Item element = new Item("product", -10, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit périmé avec une qualité initiale de 2 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit périmé avec une qualité initiale de 1.")
  void testMiseAJourQualiteProduitPerimeQualiteInitiale1() {
    Item element = new Item("product", -10, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit périmé avec une qualité initiale de 1 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit périmé avec une qualité initiale de 0.")
  void testMiseAJourQualiteProduitPerimeQualiteInitiale0() {
    Item element = new Item("product", -10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit périmé avec une qualité initiale de 0 doit être de 0.");
  }

  //// BRIES VIEILLIS
  @Test
  @DisplayName("Test de la mise à jour du nombre de jours restant pour vendre un brie vieilli.")
  void testMiseAJourNombreDeJoursRestantAvantExpirationBrieVieilli() {
    Item element = new Item("Aged Brie", 10, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.sellIn, "Le nombre de jours restant avant expiration d'un brie vieilli doit diminuer de 1 chaque jour.");
  }

  // Bries vieillis non périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un brie vieilli non périmé.")
  void testMiseAJourQualiteBrieVieilliNonPerime() {
    Item element = new Item("Aged Brie", 1, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(26, element.quality, "La qualité d'un brie vieilli non périmé doit augmenter de 1 chaque jour.");
  }

  // Bries vieillis non périmés (tests à la borne supérieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un brie vieilli non périmé avec une qualité initiale de 49.")
  void testMiseAJourQualiteBrieVieilliNonPerimeQualiteInitiale49() {
    Item element = new Item("Aged Brie", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un brie vieilli non périmé avec une qualité initiale de 49 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un brie vieilli non périmé avec une qualité initiale de 50.")
  void testMiseAJourQualiteBrieVieilliNonPerimeQualiteInitiale50() {
    Item element = new Item("Aged Brie", 10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un brie vieilli non périmé avec une qualité initiale de 50 doit être de 50.");
  }

  // Bries vieillis périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un brie vieilli périmé.")
  void testMiseAJourQualiteBrieVieilliPerime() {
    Item element = new Item("Aged Brie", 0, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(27, element.quality, "La qualité d'un brie vieilli périmé doit augmenter de 2 chaque jour.");
  }

  // Bries vieillis périmés (tests à la borne supérieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un brie vieilli périmé avec une qualité initiale de 48.")
  void testMiseAJourQualiteBrieVieilliPerimeQualiteInitiale48() {
    Item element = new Item("Aged Brie", -10, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un brie vieilli périmé avec une qualité initiale de 48 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un brie vieilli périmé avec une qualité initiale de 49.")
  void testMiseAJourQualiteBrieVieilliPerimeQualiteInitiale49() {
    Item element = new Item("Aged Brie", -10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un brie vieilli périmé avec une qualité initiale de 49 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un brie vieilli périmé avec une qualité initiale de 50.")
  void testMiseAJourQualiteBrieVieilliPerimeQualiteInitiale50() {
    Item element = new Item("Aged Brie", -10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un brie vieilli périmé avec une qualité initiale de 50 doit être de 50.");
  }

  //// SULFURAS
  @Test
  @DisplayName("Test de non modification du nombre de jours restant pour vendre un Sulfuras.")
  void testConstanceNombreDeJoursRestantAvantExpirationSulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(-1, element.sellIn, "Le nombre de jours restant avant expiration d'un Sulfuras ne doit pas être modifié.");
  }

  @Test
  @DisplayName("Test de la non modification de la qualité d'un Sulfuras.")
  void testConstanceQualiteSulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(80, element.quality, "La qualité d'un Sulfuras ne doit pas être modifiée.");
  }

  //// PASS
  @Test
  @DisplayName("Test de la mise à jour du nombre de jours restant pour vendre un pass.")
  void testMiseAJourNombreDeJoursRestantAvantExpirationPass() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.sellIn, "Le nombre de jours restant avant expiration d'un pass doit diminuer de 1 chaque jour.");
  }

  // Pass qui périment dans plus de 10 jours
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass qui périme dans 11 jours (Cas d'un pass de plus de 10 jours).")
  void testMiseAJourQualitePassQuiPerimeDansPlusDe10Jours() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(26, element.quality, "La qualité d'un pass qui périme dans plus de 10 jours doit augmenter de 1 chaque jour.");
  }

  // Pass qui périment dans plus de 10 jours (tests à la borne supérieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans plus de 10 jours avec une qualité initiale de 49.")
  void testMiseAJourQualitePassQuiPerimeDansPlusDe10JoursQualiteInitiale49() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans plus de 10 jours avec une qualité initiale de 49 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans plus de 10 jours avec une qualité initiale de 50.")
  void testMiseAJourQualitePassQuiPerimeDansPlusDe10JoursQualiteInitiale50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans plus de 10 jours avec une qualité initiale de 50 doit être de 50.");
  }

  // Pass qui périment dans un intervalle de 6 à 10 jours
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass qui périme dans 6 jours (Cas d'un pass qui périme dans un intervalle de 6 à 10 jours).")
  void testMiseAJourQualitePassQuiPerimeDans6Jours() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(27, element.quality, "La qualité d'un pass qui périme dans 6 jours doit augmenter de 2 (Cas d'un pass qui périme dans un intervalle de 6 à 10 jours).");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass qui périme dans 10 jours (Cas d'un pass qui périme dans un intervalle de 6 à 10 jours).")
  void testMiseAJourQualitePassQuiPerimeDans10Jours() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(27, element.quality, "La qualité d'un pass qui périme dans 10 jours doit augmenter de 2 (Cas d'un pass qui périme dans un intervalle de 6 à 10 jours).");
  }

  // Pass qui périment dans un intervalle de 6 à 10 jours (tests à la borne supérieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 48.")
  void testMiseAJoursQualitePassQuiPerimeDansUnIntervalleDe6A10JoursQualiteInitiale48() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 48 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 49.")
  void testMiseAJoursQualitePassQuiPerimeDansUnIntervalleDe6A10JoursQualiteInitiale49() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 49 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 50.")
  void testMiseAJoursQualitePassQuiPerimeDansUnIntervalleDe6A10JoursQualiteInitiale50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans un intervalle de 6 à 10 jours avec une qualité initiale de 50 doit être de 50.");
  }

  // Pass qui périment dans 5 jours ou moins
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass qui périme dans 1 jours (Cas d'un pass qui périme dans 5 jours ou moins).")
  void testMiseAJourQualitePassQuiPerimeDans1Jour() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(28, element.quality, "La qualité d'un pass qui périme dans 1 jours doit augmenter de 3 (Cas d'un pass qui périme dans 5 jours ou moins).");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass qui périme dans 5 jours (Cas d'un pass qui périme dans 5 jours ou moins).")
  void testMiseAJourQualitePassQuiPerimeDans5Jours() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(28, element.quality, "La qualité d'un pass qui périme dans 5 jours doit augmenter de 3 (Cas d'un pass qui périme dans 5 jours ou moins).");
  }

  // Pass qui périment dans 5 jours ou moins (tests à la borne supérieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 47.")
  void testMiseAJourQualitePassQuiPerimeDans5JoursOuMoinsQualiteInitialeDe47() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 47);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 47 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 48.")
  void testMiseAJourQualitePassQuiPerimeDans5JoursOuMoinsQualiteInitialeDe48() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 48 doit être de 50.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 49.")
  void testMiseAJourQualitePassQuiPerimeDans5JoursOuMoinsQualiteInitialeDe49() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 49 doit être de 50.");
  }

  @Test
  @DisplayName("Test que la qualité d’un pass qui périme dans 5 jours ou moins n'est jamais supérieur à 50 avec qualité initiale de 50.")
  void testMiseAJourQualitePassQuiPerimeDans5JoursOuMoinsQualiteInitialeDe50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "La qualité d'un pass qui périme dans 5 jours ou moins avec une qualité initiale de 50 doit être de 50.");
  }

  // Pass périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un pass périmé.")
  void testMiseAJourQualitePassPerime() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "la qualité d'un pass périmé doit être de 0.");
  }

  //// CONJURED
  @Test
  @DisplayName("Test de la mise à jour du nombre de jours restant pour vendre un produit invoqué")
  void testMiseAJourNombreDeJoursRestantAvantExpirationProduitInvoque() {
    Item element = new Item("Conjured", 10, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.sellIn, "Le nombre de jours restant avant expiration d'un produit invoqué doit diminuer de 1 chaque jour.");
  }

  // Produits invoqués non périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit invoqué non périmé.")
  void testMiseAJourQualiteProduitInvoqueNonPerime() {
    Item element = new Item("Conjured", 1, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(23, element.quality, "La qualité d'un produit invoqué non périmé doit diminuer de 2 chaque jour.");
  }

  // Produits invoqués non périmés (tests à la borne inférieure)
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit invoqué non périmé avec une qualité initiale de 2.")
  void testMiseAJourQualiteProduitInvoqueNonPerimeQualiteInitiale2() {
    Item element = new Item("Conjured", 10, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit non périmé avec une qualité initiale de 2 doit être de 0.");
  }
  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit invoqué non périmé avec une qualité initiale de 1.")
  void testMiseAJourQualiteProduitInvoqueNonPerimeQualiteInitiale1() {
    Item element = new Item("Conjured", 10, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit non périmé avec une qualité initiale de 1 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit invoqué non périmé avec une qualité initiale de 0.")
  void testMiseAJourQualiteProduitInvoqueNonPerimeQualiteInitiale0() {
    Item element = new Item("Conjured", 10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit non périmé avec une qualité initiale de 0 doit être de 0.");
  }

  // Produits périmés
  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit invoqué périmé.")
  void testMiseAJourQualiteProduitInvoquePerime() {
    Item element = new Item("Conjured", 0, 25);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(21, element.quality, "La qualité d'un produit invoqué périmé doit diminuer de 4 chaque jour.");
  }

  // Produits invoqués périmés (tests à la borne inférieure)

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit invoqué périmé avec une qualité initiale de 4.")
  void testMiseAJourQualiteProduitInvoquePerimeQualiteInitiale4() {
    Item element = new Item("Conjured", -10, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit invoqué périmé avec une qualité initiale de 4 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit invoqué périmé avec une qualité initiale de 3.")
  void testMiseAJourQualiteProduitInvoquePerimeQualiteInitiale3() {
    Item element = new Item("Conjured", -10, 3);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit invoqué périmé avec une qualité initiale de 3 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d’un produit invoqué périmé avec une qualité initiale de 2.")
  void testMiseAJourQualiteProduitInvoquePerimeQualiteInitiale2() {
    Item element = new Item("Conjured", -10, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit invoqué périmé avec une qualité initiale de 2 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit invoqué périmé avec une qualité initiale de 1.")
  void testMiseAJourQualiteProduitInvoquePerimeQualiteInitiale1() {
    Item element = new Item("Conjured", -10, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit périmé avec une qualité initiale de 1 doit être de 0.");
  }

  @Test
  @DisplayName("Test de la mise à jour de la qualité d'un produit invoqué périmé avec une qualité initiale de 0.")
  void testMiseAJourQualiteProduitInvoquePerimeQualiteInitiale0() {
    Item element = new Item("Conjured", -10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "La qualité d'un produit périmé avec une qualité initiale de 0 doit être de 0.");
  }
}
