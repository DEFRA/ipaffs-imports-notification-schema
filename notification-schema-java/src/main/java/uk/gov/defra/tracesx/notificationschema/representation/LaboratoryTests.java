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
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TestReason;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeSerializer;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LaboratoryTests {

  @JsonSerialize(using = IsoDateTimeSerializer.class)
  @JsonDeserialize(using = IsoDateTimeDeserializer.class)
  private LocalDateTime testDate;

  private TestReason testReason;
  @Valid
  private List<SingleLaboratoryTest> singleLaboratoryTests;
}
