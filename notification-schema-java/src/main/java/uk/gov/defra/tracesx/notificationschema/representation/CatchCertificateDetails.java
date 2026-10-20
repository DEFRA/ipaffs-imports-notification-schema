package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateValueDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateValueSerializer;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Jacksonized
public class CatchCertificateDetails {

  private UUID catchCertificateId;
  private String catchCertificateReference;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  @tools.jackson.databind.annotation.JsonSerialize(using = IsoDateValueSerializer.class)
  @tools.jackson.databind.annotation.JsonDeserialize(using = IsoDateValueDeserializer.class)
  private LocalDate dateOfIssue;

  private String flagState;
  private List<String> species;
}
