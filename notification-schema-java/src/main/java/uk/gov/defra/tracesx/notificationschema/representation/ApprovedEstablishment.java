package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import java.util.List;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode
@ToString
public class ApprovedEstablishment {

  private String id;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String name;

  @NotNull(groups = NotificationFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String country;

  private List<String> types;
  private String approvalNumber;
}
