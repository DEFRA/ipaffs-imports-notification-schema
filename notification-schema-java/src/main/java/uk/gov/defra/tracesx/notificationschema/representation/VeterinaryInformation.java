package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.LatestHealthCertificateRequired;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCvedpFieldValidationHighRiskJourney;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryApprovedEstablishmentValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@LatestHealthCertificateRequired(
    groups = NotificationSingleCvedpFieldValidationHighRiskJourney.class
)
public class VeterinaryInformation {

  @NotEmpty(
      groups = {NotificationVeterinaryApprovedEstablishmentValidation.class},
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.veterinaryInformation"
              + ".properties.establishmentsOfOrigin.not.null}")
  private List<ApprovedEstablishment> establishmentsOfOrigin;
  private String veterinaryDocument;
  private String veterinaryDocumentIssueDate;
  private List<String> accompanyingDocumentNumbers;
  private ExternalReference establishmentsOfOriginExternalReference;

  @Valid
  private List<AccompanyingDocument> accompanyingDocuments;

  private List<CatchCertificateAttachment> catchCertificateAttachments;

  private List<NotificationIdentificationDetails> identificationDetails;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate dateOfIssue;
}
