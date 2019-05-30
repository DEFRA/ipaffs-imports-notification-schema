package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class UserInformation {

  @NotNull(groups = NotificationFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String displayName;

  @NotNull(groups = NotificationFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String userId;

  private Boolean isControlUser;
}
