package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhytosanitaryCertificateAttachmentRequired;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@PhytosanitaryCertificateAttachmentRequired(groups = NotificationChedppFieldValidation.class)
public class AccompanyingDocument {

  private DocumentType documentType = null;
  private String documentReference = null;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate documentIssueDate = null;

  private UUID attachmentId = null;
  private String attachmentFilename = null;
  private String attachmentContentType = null;
  private UUID uploadUserId = null;
  private UUID uploadOrganisationId = null;
  private ExternalReference externalReference = null;
  private String flagState;

  @JsonIgnore
  public boolean isClonedDocument() {
    return Objects.nonNull(externalReference) && externalReference.getSystem()
        .equals(ExternalSystem.ECERT);
  }
}
