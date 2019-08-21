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
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Capacity;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeSerializer;

import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class OfficialVeterinarian {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String fax;
  private String competentAuthority;
  private String relatedLVU;
  private Capacity capacity;
  private String placeOfSignature;

  @JsonSerialize(using = IsoDateTimeSerializer.class)
  @JsonDeserialize(using = IsoDateTimeDeserializer.class)
  private LocalDateTime signed;
}
