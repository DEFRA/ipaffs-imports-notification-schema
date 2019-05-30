package uk.gov.defra.tracesx.notificationschema.validation;

import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

import java.util.EnumMap;
import java.util.Map;

public class EnumValidationHelper {

  static final Map<NotificationTypeEnum, Class> annotatedMap =
      new EnumMap<>(NotificationTypeEnum.class);

  static {
    annotatedMap.put(NotificationTypeEnum.CVEDA, CVEDA.class);
    annotatedMap.put(NotificationTypeEnum.CED, CED.class);
    annotatedMap.put(NotificationTypeEnum.CVEDP, CVEDP.class);
  }

  private EnumValidationHelper() {
    // no-arg constructor
  }

  /**
   * Asserting if the data is specific to the {@link NotificationTypeEnum}.
   *
   * @param property, the untrusted data
   * @param notificationType, the {@link Notification} type
   * @param <T>, can be any kind of enum
   * @return {@code true} or {@code false}
   * @see NotAcceptableActionEnum
   * @see CVEDA
   */
  public static <T extends Enum<T> & EntityProperty> Boolean assertType(
      T property, NotificationTypeEnum notificationType) {
    if (notificationType == null) {
      throw new IllegalArgumentException("Notification Type shoul not be empty");
    }
    if (property == null) {
      throw new IllegalArgumentException("Tested property should not be empty");
    }
    return EntityProperty.getAnnotation(property, annotatedMap.get(notificationType)).isPresent();
  }
}
