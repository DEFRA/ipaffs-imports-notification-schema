package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IsNonNegativeIntegerKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.MinValueKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ComplementParameterSet {

  public static final String NUMBER_PACKAGE = "number_package";
  public static final String NET_WEIGHT = "netweight";
  public static final String NUMBER_ANIMAL = "number_animal";
  public static final String TYPE_PACKAGE = "type_package";
  public static final String TYPE_PRODUCT = "type_product";
  public static final String COMMODITY_GROUP = "commodity_group";

  private UUID uniqueComplementID;
  private Integer complementID;
  private String speciesID;

  @Valid
  @MinValueKeyDataPair.List({
      @MinValueKeyDataPair(
          groups = NotificationCedOrCvedpFieldValidation.class,
          field = NET_WEIGHT,
          message =
              "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
                  + ".complementparameterset.keydatapair.net_weight.message}"),
      @MinValueKeyDataPair(
          groups = NotificationCvedaFieldValidation.class,
          field = NUMBER_ANIMAL,
          message =
              "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
                  + ".complementparameterset.keydatapair.number_animal.message}")
      })
  @IsNonNegativeIntegerKeyDataPair(
      groups = {
          NotificationCedOrCvedpFieldValidation.class,
          NotificationCvedaFieldValidation.class
      },
      field = NUMBER_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.number_package.message}")
  @NotNullKeyDataPair.List({
      @NotNullKeyDataPair(
          groups = NotificationCedOrCvedpFieldValidation.class,
          field = TYPE_PACKAGE,
          message =
              "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
                  + ".complementparameterset.keydatapair.type_package.message}")
      })
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
}
