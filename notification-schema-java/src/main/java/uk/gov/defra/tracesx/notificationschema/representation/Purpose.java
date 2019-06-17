package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForNonConformingEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.InternalMarketPurpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import java.util.List;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Purpose {

  private Boolean conformsToEU;
  private InternalMarketPurpose internalMarketPurpose;
  private String thirdCountryTranshipment;
  private ForNonConformingEnum forNonConforming;
  private String regNumber;
  private String shipName;
  private String shipPort;
  private String exitBIP;
  private String thirdCountry;
  private List<String> transitThirdCountries;
  private ForImportOrAdmissionEnum forImportOrAdmission;
  private String exitDate;
  private String finalBIP;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.purposeGroup"
              + ".not.null}")
  private PurposeGroupEnum purposeGroup;
}
