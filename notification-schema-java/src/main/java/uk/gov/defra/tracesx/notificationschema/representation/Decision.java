package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IfChanneledOptionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.SpecificWarehouseNonConformingConsignmentEnum;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.FreeCirculationPurpose;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IfChanneledOption;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotAcceptableCountry;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotAcceptableEstablishment;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotAcceptableOtherReason;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotAcceptableReason;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.SpecificWarehouse;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NotAcceptableReason(
    groups = NotificationFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
            + ".notacceptablereasoning.not.null}")
@NotAcceptableOtherReason(
    groups = NotificationFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
            + ".notacceptableotherreason.not.null}")
@NotAcceptableEstablishment(
    groups = NotificationCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
            + ".notacceptableestablishment.not.null}")
@NotAcceptableCountry(
    groups = NotificationCedOrCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
            + ".notacceptablecountry.not.null}")
@SpecificWarehouse(
    groups = NotificationCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision."
        + "specificwarehousenonconformingconsignment.not.null}")
@IfChanneledOption(
    groups = NotificationCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision."
            + "ifchanneledoption.not.null}")
@FreeCirculationPurpose(
    groups = NotificationCedFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision."
            + "freecirculationpurpose.not.null}")
public class Decision {

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
              + ".consignmentacceptable.not.null}")
  private Boolean consignmentAcceptable;

  private NotAcceptableActionEnum notAcceptableAction;
  private String notAcceptableDestructionReason;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate notAcceptableActionByDate;

  private List<NotAcceptableReasonsEnum> notAcceptableReasons;

  private String notAcceptableCountry;

  private String notAcceptableEstablishment;

  private String notAcceptableOtherReason;

  private Party detailsOfControlledDestinations;
  private SpecificWarehouseNonConformingConsignmentEnum specificWarehouseNonConformingConsignment;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate temporaryDeadline;

  private DecisionEnum decision;
  private FreeCirculationPurposeEnum freeCirculationPurpose;
  private DefinitiveImportPurposeEnum definitiveImportPurpose;
  private IfChanneledOptionEnum ifChanneledOption;
  private String customWarehouseRegisteredNumber;
  private String freeWarehouseRegisteredNumber;
  private String shipName;
  private String shipPortOfExit;
  private String shipSupplierRegisteredNumber;
  private String transhipmentEuOrThirdCountry;
  private String transhipmentBip;
  private String transhipmentThirdCountry;
  private String transitExitBip;
  private String transitThirdCountry;
  private String transitDestinationThirdCountry;
  private String temporaryExitBip;
  private String horseReentry;
}
