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
import org.hibernate.validator.constraints.NotEmpty;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PartOne {

  private Party personResponsible;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignor"
          + ".not.null}")
  private EconomicOperator consignor;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.consignee"
          + ".not.null}")
  private EconomicOperator consignee;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.importer"
          + ".not.null}")
  private EconomicOperator importer;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.deliveryaddress.not"
              + ".null}")
  private EconomicOperator placeOfDestination;

  @Valid
  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
          + ".not.null}")
  private Commodities commodities;

  @Valid
  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.not.null}")
  private Purpose purpose;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.pointofentry"
          + ".not.null}")
  private String pointOfEntry;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.arrivaldate"
          + ".not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate arrivalDate;

  @NotNull(
      groups = NotificationFieldValidation.class,
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
      groups = {NotificationFieldValidation.class, NotificationCedFieldValidation.class},
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
  private VeterinaryInformation veterinaryInformation;

  private String importerLocalReferenceNumber;
  private Route route;

  private List<NotificationSealsContainers> sealsContainers;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime submissionDate;

  private Set<ValidationMessageCode> consignmentValidation;
  private UserInformation submittedBy;

  @Size(min = 2, max = 2)
  @Pattern(regexp = "^[A-Z][A-Z]$")
  private String countryOfOrigin;

  private EconomicOperator placeOfOriginHarvest;
  private EconomicOperator permanentAddress;
  private LocalDateTime dateOfImport;
  private List<String> species;
  private Integer quantity;
  private String animalsCertifiedFor;
  private List<String> transitingCountries;
  private String identification;
}
