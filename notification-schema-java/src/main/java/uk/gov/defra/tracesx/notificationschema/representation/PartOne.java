package uk.gov.defra.tracesx.notificationschema.representation;

import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.NET_WEIGHT;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.NUMBER_PACKAGE;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.QUANTITY;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.TYPE_PACKAGE;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.TYPE_QUANTITY;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ProvideCtcMrnEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RetrospectiveCloningMergeMethod;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TypeOfImp;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedaPurposeExitDateNotNull;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppInvalidPodCheck;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppIsPositiveDoubleKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppMinValueKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppNotNullKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppPodRequired;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ImpPlaceOfOriginNotNull;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ImpPortOfEntry;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ImpPortOfExit;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ImpPortOfExitDateInFuture;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ImpPortOfExitDateNotNull;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.NotNullPurposeExitBip;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhytosanitaryCertificateRequired;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PortOfEntryAndPointOfEntryNotEmpty;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PortOfExitAndExitBipNotEmpty;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationContactDetailsEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationGvmsRouteValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuChedValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationLowRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCvedpFieldValidationHighRiskJourney;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationTransporterContactDetailsEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryApprovedEstablishmentValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.PhytosanitaryCertificateRequiredValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.PointOfEntryControlPointValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCEDValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCHEDPPValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCvedaValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedaValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedpValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ImpPlaceOfOriginNotNull(
    groups = NotificationLowRiskFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp"
            + ".consignor.not.null}")
@NotNullPurposeExitBip(
    groups = {
        NotificationCvedaFieldValidation.class,
        NotificationHighRiskEuChedValidation.class,
    },
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
        + ".exitbip.not.null}")
@ImpPortOfEntry(
    groups = {NotificationLowRiskFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofentry"
        + ".not.null}")
@ImpPortOfExit(
    groups = {NotificationLowRiskFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofexit"
        + ".not.null}")
@ImpPortOfExitDateNotNull(
    groups = {NotificationLowRiskFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofexitdate"
        + ".not.null}")
@ImpPortOfExitDateInFuture(
    groups = NotificationLowRiskFieldValidation.class,
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofexitdate"
        + ".must.be.in.future}")
@PhytosanitaryCertificateRequired(groups = PhytosanitaryCertificateRequiredValidation.class)
@ChedppInvalidPodCheck(
    groups = NotificationChedppFieldValidation.class,
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pod"
        + ".invalid.due.to.country}")
@ChedppPodRequired(
    groups = NotificationChedppFieldValidation.class,
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pod.required}")
@PortOfEntryAndPointOfEntryNotEmpty(
    groups = {NotificationCvedaEuFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofentry"
        + ".pointofentry.eucveda.not.null}")
@PortOfEntryAndPointOfEntryNotEmpty(
    groups = {NotificationCvedpEuFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofentry"
        + ".pointofentry.eucvedp.not.null}")
@PortOfExitAndExitBipNotEmpty(
    groups = {NotificationCvedaEuFieldValidation.class},
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.portofexit"
        + ".exitbip.eucveda.not.null}")
public class PartOne {

  private TypeOfImp typeOfImp;

  @Valid
  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.personResponsible"
          + ".not.null}")
  private Party personResponsible;

  private String customsReferenceNumber;

  private Boolean containsWoodPackaging;

  private Boolean consignmentArrived;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignor"
          + ".not.null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignor.chedpp"
          + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperator consignor;

  private EconomicOperator consignorTwo;

  private EconomicOperator packer;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignee"
          + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperator consignee;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.importer"
          + ".not.null}")
  @NotNull(
      groups = NotificationLowRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp.importer"
          + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperator importer;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationLowRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.deliveryaddress.not"
              + ".null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.deliveryaddress.chedpp"
              + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperator placeOfDestination;

  private EconomicOperator pod;
  private EconomicOperator placeOfOriginHarvest;
  private List<EconomicOperator> additionalPermanentAddresses;

  private String cphNumber;
  private Boolean importingFromCharity;
  private Boolean isPlaceOfDestinationThePermanentAddress;

  @Valid
  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
          + ".not.null}")
  @ChedppMinValueKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = NUMBER_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.number_package.message}")
  @ChedppMinValueKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = NET_WEIGHT,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.net_weight.message}")
  @ChedppNotNullKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = TYPE_PACKAGE,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.type_package.message}")
  @ChedppNotNullKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = TYPE_QUANTITY,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.type_quantity.message}")
  @ChedppNotNullKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = QUANTITY,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.quantity.message}")
  @ChedppIsPositiveDoubleKeyDataPair(
      groups = NotificationChedppFieldValidation.class,
      field = QUANTITY,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".complementparameterset.keydatapair.chedpp.quantity.message}")
  @RetrospectiveCloningProperty(mergeMethod = RetrospectiveCloningMergeMethod.REPLACE)
  private Commodities commodities;

  @Valid
  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.not.null}")
  @ChedaPurposeExitDateNotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
          + ".exitdate.not.null}"
  )
  @RetrospectiveCloningProperty()
  private Purpose purpose;

  @NotBlank(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pointofentry"
          + ".not.null}")
  @NotBlank(
      groups = NotificationChedppFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pointofentry"
          + ".chedpp.not.null}")
  @NotBlank(
      groups = NotificationHighRiskEuCedFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pointofentry"
          + ".euced.not.null}")
  @RetrospectiveCloningProperty()
  private String pointOfEntry;

  @NotNull(
      groups = PointOfEntryControlPointValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone."
          + "pointofentrycontrolpoint.not.null}")
  private String pointOfEntryControlPoint;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".not.null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate.chedpp"
          + ".not.null}")
  @NotNull(
      groups = NotificationCvedaEuFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".eucveda.not.null}")
  @NotNull(
      groups = NotificationHighRiskEuCedFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".euced.not.null}")
  @NotNull(
      groups = NotificationCvedpEuFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".eucvedp.not.null}")
  @NotNull(
      groups = NotificationLowRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.euimp.arrivaldate"
          + ".not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  @RetrospectiveCloningProperty()
  private LocalDate arrivalDate;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime"
          + ".not.null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime.chedpp"
          + ".not.null}")
  @NotNull(
      groups = NotificationCvedaEuFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime"
          + ".eucveda.not.null}")
  @NotNull(
      groups = NotificationCvedpEuFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime"
          + ".eucvedp.not.null}")
  @NotNull(
      groups = NotificationHighRiskEuCedFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaltime"
          + ".euced.not.null}")
  @JsonSerialize(using = IsoTimeSerializer.class)
  @JsonDeserialize(using = IsoTimeDeserializer.class)
  @RetrospectiveCloningProperty()
  private LocalTime arrivalTime;

  @Valid
  @NotNull(
      groups = {
          TransporterDetailsRequiredEuCvedaValidation.class,
          TransporterDetailsRequiredCvedaValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter"
          + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperator transporter;

  private Boolean transporterDetailsRequired;

  @Valid
  @NotNull(
      groups = {TransporterDetailsRequiredEuCvedaValidation.class,
          TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.not"
              + ".null}")
  @NotNull(
      groups = TransporterDetailsRequiredCHEDPPValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.not"
              + ".null}")
  @NotNull(
      groups = TransporterDetailsRequiredEuCvedpValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.eucvedp"
              + ".not.null}")
  private MeansOfTransportAfterBip meansOfTransport;

  @Valid
  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCedFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansOfTransportFromEntryPoint.not.null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.chedpp.type.not.null}")
  @NotNull(
      groups = NotificationHighRiskEuCedFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansOfTransportFromEntryPoint.euced.not.null}")
  @NotNull(
      groups = NotificationCvedpEuFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansOfTransportFromEntryPoint.eucvedp.not.null}")
  @RetrospectiveCloningProperty()
  private MeansOfTransportBeforeBip meansOfTransportFromEntryPoint;

  @NotNull(
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuredate"
          + ".not.null}")
  @NotNull(
      groups = {TransporterDetailsRequiredEuCvedaValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuredate"
          + ".eucveda.not.null}")
  @NotNull(
      groups = {TransporterDetailsRequiredEuCvedpValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuredate"
          + ".eucvedp.not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate departureDate;

  @NotNull(
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class},
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuretime"
          + ".not.null}")
  @NotNull(
      groups = {TransporterDetailsRequiredEuCvedaValidation.class},
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuretime"
          + ".eucveda.not.null}")
  @NotNull(
      groups = {TransporterDetailsRequiredEuCvedpValidation.class},
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.departuretime"
          + ".eucvedp.not.null}")
  @JsonSerialize(using = IsoTimeSerializer.class)
  @JsonDeserialize(using = IsoTimeDeserializer.class)
  private LocalTime departureTime;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".estimatedjourneytimeinminutes.not.null}")
  @NotNull(
      groups = {
          TransporterDetailsRequiredEuCvedaValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".estimatedjourneytimeinminutes.eucveda.not.null}")
  private Integer estimatedJourneyTimeInMinutes;

  private String responsibleForTransport;

  @Valid
  @NotNull(
      groups = {
          NotificationVeterinaryApprovedEstablishmentValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.veterinaryInformation"
              + ".not.null}")
  @NotNull(
      groups = NotificationSingleCvedpFieldValidationHighRiskJourney.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone"
          + ".veterinaryInformation.properties.accompanyingDocuments.chedp.must.have.latest."
          + "veterinary.document}"
  )
  @RetrospectiveCloningProperty()
  private VeterinaryInformation veterinaryInformation;

  private String importerLocalReferenceNumber;

  @RetrospectiveCloningProperty()
  private Route route;

  @RetrospectiveCloningProperty(mergeMethod = RetrospectiveCloningMergeMethod.REPLACE)
  private List<@Valid NotificationSealsContainers> sealsContainers;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime submissionDate;

  private Set<ValidationMessageCode> consignmentValidation;
  private UserInformation submittedBy;

  private Boolean complexCommoditySelected;
  private String portOfEntry;
  private String portOfExit;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate portOfExitDate;

  @Valid
  @NotNull(
      groups = {
          NotificationContactDetailsEuFieldValidation.class,
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.contactdetails"
          + ".not.null}")
  @NotNull(
      groups = {
          NotificationChedppFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.contactdetails"
          + ".chedpp.not.null}")
  private ContactDetails contactDetails;

  @NotEmpty(groups = NotificationTransporterContactDetailsEuFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone"
          + ".transportercontactdetails.not.empty}")
  private List<NominatedContact> nominatedContacts;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime originalEstimatedDateTime;
  private Boolean isCatchCertificateRequired;
  @NotNull(
      groups = {
          NotificationGvmsRouteValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.isGVMSRoute"
              + ".not.null}")
  private Boolean isGVMSRoute;
  private Boolean isChargeable;
  private Boolean wasChargeable;
  private BillingInformation billingInformation;
  private CommonUserCharge commonUserCharge;
  private ProvideCtcMrnEnum provideCtcMrn;
}
