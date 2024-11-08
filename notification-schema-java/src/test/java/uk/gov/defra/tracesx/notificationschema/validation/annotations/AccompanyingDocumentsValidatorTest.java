package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

 class AccompanyingDocumentsValidatorTest {

  private AccompanyingDocumentsValidator validator;
  private Notification notification;

  @BeforeEach
  void setup() {
    validator = new AccompanyingDocumentsValidator();
    notification = new Notification();
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.AIR_WAYBILL);
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
    notification.setPartOne(new PartOne());
    notification.getPartOne().setVeterinaryInformation(veterinaryInformation);
    notification.setPartTwo(new PartTwo());
    notification.getPartTwo().setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
  }

  @Test
  void isValid_ReturnsTrue_WhenValidPartOneAndPartTwoAccompanyingDocuments() {
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenValidPartOneAndPartTwoNullAccompanyingDocuments() {
    notification.getPartTwo().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenValidPartOneAndPartTwoEmptyAccompanyingDocuments() {
    notification.getPartTwo().setAccompanyingDocuments(new ArrayList<>());
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenPartOneNullVeterinaryInformationAndPartTwoValidAccompanyingDocuments() {
    notification.getPartOne().setVeterinaryInformation(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenPartOneNullAccompanyingDocumentsAndPartTwoValidAccompanyingDocuments() {
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenPartOneEmptyAccompanyingDocumentsAndPartTwoValidAccompanyingDocuments() {
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(new ArrayList<>());
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenPartOneNullVeterinaryInformationAndPartTwoNullAccompanyingDocuments() {
    notification.getPartOne().setVeterinaryInformation(null);
    notification.getPartTwo().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenPartOneEmptyAccompanyingDocumentsAndPartTwoNullAccompanyingDocuments() {
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(new ArrayList<>());
    notification.getPartTwo().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenPartOneEmptyAccompanyingDocumentsAndPartTwoEmptyAccompanyingDocuments() {
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(new ArrayList<>());
    notification.getPartTwo().setAccompanyingDocuments(new ArrayList<>());
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenPartOneNullAccompanyingDocumentsAndPartTwoEmptyAccompanyingDocuments() {
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(null);
    notification.getPartTwo().setAccompanyingDocuments(new ArrayList<>());
    assertThat(validator.isValid(notification, null)).isFalse();
  }

}
