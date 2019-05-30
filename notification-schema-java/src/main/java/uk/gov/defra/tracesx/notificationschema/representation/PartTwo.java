package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.LaboratoryTestsNotAdded;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.LaboratoryTestsPending;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@JsonInclude(Include.NON_EMPTY)
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@LaboratoryTestsNotAdded(
    groups = NotificationFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notification.representation.parttwo"
            + ".reasonlaboratorytestsnotadded.not.empty}")
@LaboratoryTestsPending(
    groups = NotificationFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notification.representation.parttwo.laboratorytestspending"
            + ".not.empty}")
@Getter
@Setter
public class PartTwo {

  @Valid
  private Decision decision;

  @Valid
  private ConsignmentCheck consignmentCheck;

  private ImpactOfTransportOnAnimals impactOfTransportOnAnimals;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notification.representation.parttwo"
              + ".laboratorytestsrequired.not.null}")
  private Boolean laboratoryTestsRequired;

  @Valid
  private LaboratoryTests laboratoryTests;

  private List<String> resealedContainers;

  @Valid
  private ControlAuthority controlAuthority;

  private String bipLocalReferenceNumber;
  private String signedOnBehalfOf;
  private String onwardTransportation;
  private Set<ValidationMessageCode> consignmentValidation;
  private EconomicOperator controlledDestination;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime checkDate;
}
