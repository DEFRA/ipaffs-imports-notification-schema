package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ChedppNotAcceptableCommodityOrPackageEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ChedppNotAcceptableReasonEnum;

import javax.validation.constraints.NotNull;

@Getter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SingleChedppNotAcceptableReason {

  @NotNull
  private ChedppNotAcceptableReasonEnum reason;

  @NotNull
  private ChedppNotAcceptableCommodityOrPackageEnum commodityOrPackage;
}
