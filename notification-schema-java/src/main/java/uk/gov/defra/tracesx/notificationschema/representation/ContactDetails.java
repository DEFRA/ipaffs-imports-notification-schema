package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ContactDetailsEmailOrTelephoneRequired;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationContactDetailsEuFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ContactDetailsEmailOrTelephoneRequired(
    groups = {
        NotificationContactDetailsEuFieldValidation.class,
        NotificationChedppFieldValidation.class
    })
public class ContactDetails {

  @NotNull(
      groups = {
          NotificationContactDetailsEuFieldValidation.class,
          NotificationChedppFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone"
          + ".contactdetails.name"
          + ".not.null}")
  private String name = null;

  private String telephone = null;
  private String email = null;
  private String agent = null;
}
