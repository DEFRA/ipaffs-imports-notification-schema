package uk.gov.defra.tracesx.notificationschema.representation;

import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.NET_WEIGHT;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.NUMBER_PACKAGE;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.TYPE_PACKAGE;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.TYPE_PRODUCT;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppMinValueKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppNotNullKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.DogPlaceOfOriginImp;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullVeterinaryDocument;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationLowRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryApprovedEstablishmentValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCEDValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredValidation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@DogPlaceOfOriginImp(
    groups = NotificationLowRiskFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp"
            + ".consignor.not.null}")
public class PartOne {

  @Valid
  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.personResponsible"
          + ".not.null}")
  private Party personResponsible;

  private String customsReferenceNumber;

  private Boolean containsWoodPackaging;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignor"
          + ".not.null}")
  private EconomicOperator consignor;

  private EconomicOperator consignorTwo;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignee"
          + ".not.null}")
  private EconomicOperator consignee;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.importer"
          + ".not.null}")
  @NotNull(
      groups = NotificationLowRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp.importer"
          + ".not.null}")
  private EconomicOperator importer;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.deliveryaddress.not"
              + ".null}")
  private EconomicOperator placeOfDestination;

  private EconomicOperator placeOfOriginHarvest;
  private List<EconomicOperator> additionalPermanentAddresses;

  private String cphNumber;
  private Boolean importingFromCharity;
  private Boolean isPlaceOfDestinationThePermanentAddress;

  @Valid
  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
          + ".not.null}")
  @ChedppMinValueKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = NUMBER_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.number_package.message}")
  @ChedppMinValueKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = NET_WEIGHT,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.net_weight.message}")
  @ChedppNotNullKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = TYPE_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.type_package.message}")
  @ChedppNotNullKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = TYPE_PRODUCT,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.type_product.message}")
  private Commodities commodities;

  @Valid
  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.not.null}")
  private Purpose purpose;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pointofentry"
          + ".not.null}")
  private String pointOfEntry;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".not.null}")
  @NotNull(
      groups = NotificationLowRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp.arrivaldate"
          + ".not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate arrivalDate;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime"
          + ".not.null}")
  @JsonSerialize(using = IsoTimeSerializer.class)
  @JsonDeserialize(using = IsoTimeDeserializer.class)
  private LocalTime arrivalTime;

  @Valid
  @NotNull(
      groups = TransporterDetailsRequiredValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter"
          + ".not.null}")
  private EconomicOperator transporter;

  private Boolean transporterDetailsRequired;

  @Valid
  @NotNull(
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.not"
              + ".null}")
  private MeansOfTransportAfterBip meansOfTransport;

  @Valid
  @NotNull(
      groups = {NotificationHighRiskFieldValidation.class, NotificationCedFieldValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansOfTransportFromEntryPoint.not.null}")
  private MeansOfTransportBeforeBip meansOfTransportFromEntryPoint;

  @NotNull(
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class},
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuredate"
          + ".not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate departureDate;

  @NotNull(
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class},
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuretime"
          + ".not.null}")
  @JsonSerialize(using = IsoTimeSerializer.class)
  @JsonDeserialize(using = IsoTimeDeserializer.class)
  private LocalTime departureTime;

  @NotNull(
      groups = {NotificationCvedaFieldValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".estimatedjourneytimeinminutes.not.null}")
  private Integer estimatedJourneyTimeInMinutes;

  @NotEmpty(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".responsiblefortransport.not.empty}")
  private String responsibleForTransport;

  @Valid
  @NotNull(
      groups = {
          NotificationVeterinaryValidation.class,
          NotificationVeterinaryApprovedEstablishmentValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.veterinaryInformation"
              + ".not.null}")
  @NotNullVeterinaryDocument(
      groups = {NotificationVeterinaryValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.veterinaryInformation"
              + ".properties.accompanyingDocuments.must.have.veterinary.document}")
  private VeterinaryInformation veterinaryInformation;

  private String importerLocalReferenceNumber;
  private Route route;

  private List<NotificationSealsContainers> sealsContainers;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime submissionDate;

  private Set<ValidationMessageCode> consignmentValidation;
  private UserInformation submittedBy;

  private Boolean complexCommoditySelected;
  private String portOfEntry;
}
