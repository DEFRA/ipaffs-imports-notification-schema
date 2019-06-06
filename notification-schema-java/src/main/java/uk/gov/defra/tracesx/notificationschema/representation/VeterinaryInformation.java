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
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryApprovedEstablishmentValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryValidation;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class VeterinaryInformation {

  @NotEmpty(
      groups = {NotificationVeterinaryApprovedEstablishmentValidation.class},
      message =
          "{uk.gov.defra.tracesx.notification.representation.partone.veterinaryInformation"
              + ".properties.establishmentsOfOrigin.not.null}")
  private List<ApprovedEstablishment> establishmentsOfOrigin;

  @NotEmpty(
      groups = {NotificationVeterinaryValidation.class},
      message =
          "{uk.gov.defra.tracesx.notification.representation.partone.veterinaryInformation"
              + ".properties.veterinaryDocument.not.null}")
  private String veterinaryDocument;

  @NotEmpty(
      groups = {NotificationVeterinaryValidation.class},
      message =
          "{uk.gov.defra.tracesx.notification.representation.partone.veterinaryInformation"
              + ".properties.veterinaryDocumentIssueDate.not.null}")
  private String veterinaryDocumentIssueDate;

  private List<String> accompanyingDocumentNumbers;
  private List<NotificationIdentificationDetails> identificationDetails;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate dateOfIssue;
}
