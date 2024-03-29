package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IsNonNegativeIntegerKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.MinValueKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;

@Builder(toBuilder = true)
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ComplementParameterSet {

  public static final String NUMBER_PACKAGE = "number_package";
  public static final String NET_WEIGHT = "netweight";
  public static final String NUMBER_ANIMAL = "number_animal";
  public static final String QUANTITY = "quantity";
  public static final String TYPE_PACKAGE = "type_package";
  public static final String TYPE_PRODUCT = "type_product";
  public static final String TYPE_QUANTITY = "type_quantity";
  public static final String COMMODITY_GROUP = "commodity_group";
  public static final String LOW_RISK_ARTICLE_72_COMMODITY = "low_risk_article72_commodity";
  public static final String FINISHED_OR_PROPAGATED = "finished_or_propagated";
  public static final String VARIETY = "variety";
  public static final String CLASS = "class";
  public static final String INTENDED_USE = "intended_use";
  public static final String MARKETING_STANDARD = "marketing_standard";
  public static final String REGULATORY_AUTHORITY = "regulatory_authority";
  public static final String VALIDITY_PERIOD = "validity_period";
  public static final String CONTAINER = "container";

  private UUID uniqueComplementID;
  private Integer complementID;
  private String speciesID;

  @Valid
  @MinValueKeyDataPair(
      groups = {
          NotificationCedOrCvedpFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      field = NET_WEIGHT,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.net_weight.message}")
  @MinValueKeyDataPair(
      groups = {
          NotificationCvedaFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      field = NUMBER_ANIMAL,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.number_animal.message}")
  @IsNonNegativeIntegerKeyDataPair(
      groups = {
          NotificationCedOrCvedpFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedaFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      field = NUMBER_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.number_package.message}")
  @NotNullKeyDataPair(
      groups = {
          NotificationCedOrCvedpFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      field = TYPE_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.type_package.message}")
  private List<ComplementParameterSetKeyDataPair> keyDataPair;

  private List<Identifier> identifiers;

  private List<CatchCertificate> catchCertificates;

  public ComplementParameterSet addKeyDataPairItem(
      ComplementParameterSetKeyDataPair keyDataPairItem) {
    if (this.keyDataPair == null) {
      this.keyDataPair = new ArrayList<>();
    }
    this.keyDataPair.add(keyDataPairItem);
    return this;
  }

  @JsonIgnore
  public boolean isArticle72() {
    return this.keyDataPair.stream().filter(Objects::nonNull)
        .anyMatch(keyDataPair ->
            LOW_RISK_ARTICLE_72_COMMODITY.equals(keyDataPair.getKey())
            && Boolean.parseBoolean(keyDataPair.getData()));
  }
}
