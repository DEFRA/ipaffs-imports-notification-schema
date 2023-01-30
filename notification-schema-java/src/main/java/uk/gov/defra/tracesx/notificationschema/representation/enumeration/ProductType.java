package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {
  BUDWOOD_SCIONS("Budwood/scions"),
  INTENDED_FOR_PLANTING_ALREADY_PLANTED("Intended for planting: already planted"),
  INTENDED_FOR_PLANTING_AQUATIC_PLANTS("Intended for planting: aquatic plants"),
  INTENDED_FOR_PLANTING_BONSAI("Intended for planting: bonsai"),
  INTENDED_FOR_PLANTING_CARNIVOROUS_PLANTS("Intended for planting: carnivorous plants"),
  INTENDED_FOR_PLANTING_CUTTINGS("Intended for planting: cuttings"),
  INTENDED_FOR_PLANTING_NOT_YET_PLANTED("Intended for planting: not yet planted"),
  INTENDED_FOR_PLANTING_OTHERS("Intended for planting: others"),
  INTENDED_FOR_PLANTING_PLANT_TISSUE_CULTURE("Intended for planting: plant tissue culture"),
  INTENDED_FOR_PLANTING_SEEDING("Intended for planting: seeding"),
  INTENDED_FOR_PLANTING_SEEDLINGS("Intended for planting: seedlings (except forestry "
      + "reproductive material), young plants of strawberries or of vegetables"),
  INTENDED_FOR_PLANTING_SEEDS("Intended for planting: seeds"),
  INTENDED_FOR_PLANTING_SEED_POTATOES("Intended for planting: seed potatoes"),
  INTENDED_FOR_PLANTING_SHRUBS("Intended for planting: shrubs"),
  INTENDED_FOR_PLANTING_UNDERGROUND_ORGANS("Intended for planting: underground organs"),
  OTHER("Other"),
  OTHERS("Others"),
  OTHER_LIVING_PLANTS_CUT_BRANCHES_WITHOUT_FOLIAGE("Other living plants: cut branches without"
      + " foliage"),
  OTHER_LIVING_PLANTS_CUT_FLOWERS_AND_BRANCHES_WITH_FOLIAGE("Other living plants: cut flowers"
      + " and branches with foliage"),
  OTHER_LIVING_PLANTS_CUT_TREES_RETAINING_FOLIAGE("Other living plants: cut trees retaining "
      + "foliage"),
  OTHER_LIVING_PLANTS_FRUIT_AND_VEGETABLES("Other living plants: fruit and vegetables"),
  OTHER_LIVING_PLANTS_LEAFY_VEGETABLES("Other living plants: leafy vegetables"),
  OTHER_LIVING_PLANTS_LEAVES("Other living plants: leaves"),
  OTHER_LIVING_PLANTS_OTHERS("Other living plants: others"),
  OTHER_LIVING_PLANTS_POLLEN("Other living plants: pollen"),
  OTHER_LIVING_PLANTS_STORED_PRODUCTS_CAPABLE_OF_GERMINATING("Other living plants: stored "
      + "products capable of germinating"),
  OTHER_LIVING_PLANTS_WARE_POTATOES("Other living plants: ware potatoes"),
  PLANT_PRODUCTS_BARK("Plant products: bark"),
  PLANT_PRODUCTS_DUNNAGE("Plant products: dunnage"),
  PLANT_PRODUCTS_LOGS("Plant products: logs"),
  PLANT_PRODUCTS_OTHERS("Plant products: others"),
  PLANT_PRODUCTS_SAWN_WOOD("Plant products: sawn wood"),
  PLANT_PRODUCTS_STORED_PRODUCTS_NOT_CAPABLE_OF_GERMINATING("Plant products: stored products "
      + "not capable of germinating"),
  PLANT_PRODUCTS_WASTE_OF_PLANT_ORIGIN("Plant products: waste of plant origin"),
  PLANT_PRODUCTS_WOOD_AND_BARK("Plant products: wood and bark");

  private String value;

  ProductType(String value) {
    this.value = value;
  }

  public static ProductType fromValue(String text) {
    for (ProductType u : ProductType.values()) {
      if (u.value.equalsIgnoreCase(text)) {
        return u;
      }
    }
    return null;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
