package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.apache.commons.lang3.StringUtils.isBlank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class ComplementParameterSetKeyDataPairValidator {

  private final String fieldName;

  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList) {
    if (keyDataPairList == null) {
      return false;
    }
    for (ComplementParameterSetKeyDataPair keyDataPair : keyDataPairList) {
      String key = keyDataPair.getKey();
      if (isBlank(key)) {
        return false;
      }
      if (key.equals(getFieldName())) {
        return isValid(keyDataPair.getData());
      }
    }
    return false;
  }

  protected abstract boolean isValid(String data);
}
