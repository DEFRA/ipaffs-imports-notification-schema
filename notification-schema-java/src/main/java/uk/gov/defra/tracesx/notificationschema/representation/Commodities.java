package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CommodityIntention;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CommodityTemperature;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppGmsDeclaration;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.MinCommoditiesGrossWeight;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullFinishedOrPropagatedKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullWoodPackagingKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhytosanitaryCertificateAttachmentRequired;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.QuantityImp;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpOrChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationLowRiskFieldValidation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@MinCommoditiesGrossWeight(
    groups = NotificationCedOrCvedpOrChedppFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
            + ".totalgrossweight.min.message}")
@NotNullWoodPackagingKeyDataPair(
    groups = NotificationChedppFieldValidation.class,
    field = "units-quantity",
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
        + ".woodpackagingnumberunits.not.null}")
@NotNullWoodPackagingKeyDataPair(
    groups = NotificationChedppFieldValidation.class,
    field = "units-type",
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
        + ".woodpackagingunittype.not.null}")
@NotNullWoodPackagingKeyDataPair(
    groups = NotificationChedppFieldValidation.class,
    field = "country-of-origin",
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
        + ".woodpackagingcountryoforigin.not.null}")
@ChedppGmsDeclaration(
    groups = NotificationChedppFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
            + ".gmsdeclarationaccepted.message}")
@NotNullFinishedOrPropagatedKeyDataPair(
    groups = NotificationChedppFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
            + ".finishedorpropagated.message}")
public class Commodities {

  @NotNull(
      groups = NotificationCedOrCvedpOrChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".totalgrossweight.not.null}")
  private BigDecimal totalGrossWeight;

  @NotNull(
      groups = NotificationCedOrCvedpOrChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".totalnetweight.not.null}")
  private BigDecimal totalNetWeight;

  private Integer numberOfPackages;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".temperature.not.null}")
  private CommodityTemperature temperature = null;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".numberofanimals.not.null}")
  @Min(
      value = 1,
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".numberofanimals.min.message}")
  private Integer numberOfAnimals = null;

  @NotNull(
      groups = NotificationLowRiskFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp"
              + ".commodities.commodityComplement.min.message}")
  private List<CommodityComplement> commodityComplement = null;

  @Valid
  @QuantityImp(
      groups = NotificationLowRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp"
          + ".commodities.complementParameterSet.quantity.not.null}")
  private List<ComplementParameterSet> complementParameterSet = null;

  private Boolean includeNonAblactedAnimals = null;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".countryoforigin.not.null}")
  private String countryOfOrigin = null;

  private Boolean countryOfOriginIsPodCountry = null;

  private Boolean isLowRiskArticle72Country;

  private String regionOfOrigin = null;

  @NotNull(
      groups = NotificationCedOrCvedpOrChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".consignedcountry.not.null}")
  private String consignedCountry = null;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".animalscertifiedas.not.null}")
  private AnimalCertification animalsCertifiedAs = null;

  private CommodityIntention commodityIntendedFor = null;

  private BigDecimal totalGrossVolume;

  private String totalGrossVolumeUnit;
  private Boolean gmsDeclarationAccepted;
  private Boolean consignedCountryInChargeGroup;

  public Commodities addCommodityComplementItem(CommodityComplement commodityComplementItem) {
    if (this.commodityComplement == null) {
      this.commodityComplement = new ArrayList<>();
    }
    this.commodityComplement.add(commodityComplementItem);
    return this;
  }

  public Commodities addComplementParameterSetItem(
      ComplementParameterSet complementParameterSetItem) {
    if (this.complementParameterSet == null) {
      this.complementParameterSet = new ArrayList<>();
    }
    this.complementParameterSet.add(complementParameterSetItem);
    return this;
  }
}
