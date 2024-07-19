package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RetrospectiveCloningMergeMethod;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Route {

  @RetrospectiveCloningProperty(mergeMethod = RetrospectiveCloningMergeMethod.REPLACE)
  private List<String> transitingStates = null;
}
