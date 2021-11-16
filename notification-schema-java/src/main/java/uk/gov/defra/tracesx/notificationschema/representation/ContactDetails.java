package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ContactDetailsEmailOrTelephoneRequired;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEUDocumentCheckValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuChedValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;

import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ContactDetailsEmailOrTelephoneRequired(groups = NotificationHighRiskEuChedValidation.class)
public class ContactDetails {

  @NotNull(groups = NotificationHighRiskEuChedValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone"
          + ".contactdetails.name"
          + ".not.null}")
  private String name = null;

  private String telephone = null;
  private String email = null;
  private String agent = null;
}