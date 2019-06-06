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
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Conclusion;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LaboratoryTestResult {

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate sampleUseByDate;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate releasedDate;

  private String laboratoryTestMethod;
  private String results;
  private Conclusion conclusion;
}
