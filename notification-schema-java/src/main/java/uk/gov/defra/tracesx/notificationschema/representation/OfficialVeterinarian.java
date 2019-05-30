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
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeSerializer;

import java.time.LocalDateTime;

@Builder
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class OfficialVeterinarian {

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String fax;

  @JsonSerialize(using = IsoDateTimeSerializer.class)
  @JsonDeserialize(using = IsoDateTimeDeserializer.class)
  private LocalDateTime signed;
}
