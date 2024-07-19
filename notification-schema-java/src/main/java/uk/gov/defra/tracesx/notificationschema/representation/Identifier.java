package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RetrospectiveCloningMergeMethod;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Identifier {

  @RetrospectiveCloningProperty()
  private Integer speciesNumber;
  @RetrospectiveCloningProperty(mergeMethod = RetrospectiveCloningMergeMethod.REPLACE)
  private Map<String, String> data;
  private EconomicOperator permanentAddress;
  private Boolean isPlaceOfDestinationThePermanentAddress;
}
