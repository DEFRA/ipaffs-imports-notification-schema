package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Jacksonized
public class CatchCertificateAttachment {

  private String attachmentId;
  private List<CatchCertificateDetails> catchCertificateDetails;
}
