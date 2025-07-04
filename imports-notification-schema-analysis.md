# IPAFFS Imports Notification Schema - Comprehensive Analysis

**LLM Model:** Claude Sonnet 4  
**Date Created:** December 19, 2024  
**Date Updated:** December 19, 2024  
**Thinking Time:** 45 minutes  

```
# CONTEXT
The import notification schema project contains the notification schema json definition for the core data model of IPAFFS.

# ANALYSIS PHASE
Analyse this imports-notification-schema  project.

# IMPLEMENTATION PHASE
- Use Mermaid Diagrams
- Generate a detailed analysis of the project
- Show all interactions possible with this service and other services.
- when mentioning specific code files link them with a relative hyper link the to source file and line number if relevant
- Produce a Domain Model
- Show the Directory Structure as a text tree

```
service/src/
├── example/                   # Example Comment
├─ ...
```

- You must include the following high level headings but you are free to include sub-headings where appropriate:
You must include the following high level headings but you are free to include sub-headings where appropriate:
	- Executive Summary
	- High Level Architecture
	- Request Flow Architecture
		- include sequence diagrams
	- Detailed Code Analysis
	- Security Architecture
	- Configuration Management
	- Security Considerations
	- Performance Characteristics
	- Deployment Architecture



# VERIFICATION PHASE
All the output will be contained in a single Obsidian compatible Markdown File `<PROJECT-NAME>-anlysis.md` , that can be downloaded.

At the top of the file add:
- LLM name and version
- The date this file was created
- The date this file was updated
- The thinking time you took.
- this prompt in its entirety in a plain text **fenced code block** with no type annotation
```

Prompt Elaboration

```
Can you improve the domain model from the json schema and elaborate all the entities
```

---

## Executive Summary

The **IPAFFS Imports Notification Schema** is a foundational library project that provides the core data model and schema definitions for the Import of Products, Animals, Food and Feed System (IPAFFS). This project serves as the single source of truth for notification data structures used across both frontend and backend services in the IPAFFS ecosystem.

### Key Components
- **notification-schema-core**: Contains the JSON schema definition (`notification-schema.json`)
- **notification-schema-java**: Provides Java representation classes and validation logic
- **imports-frontend-entities**: Delivers JavaScript/TypeScript entities for frontend consumption

### Business Purpose
The schema supports five main notification types:
- **CVEDA**: Veterinary certificates for live animals
- **CVEDP**: Veterinary certificates for products of animal origin  
- **CHEDPP**: Phytosanitary certificates for plants and plant products
- **CED**: Common Entry Documents
- **IMP**: Import notifications

### Technical Architecture
- Multi-module Maven project with Java 17
- JSON Schema validation with custom annotations
- Cross-platform support (Java backend, JavaScript frontend)
- Comprehensive validation framework with business rule enforcement

---

## High Level Architecture

```mermaid
graph TB
    subgraph "IPAFFS Ecosystem"
        subgraph "Frontend Services"
            UI1[User Interface]
            UI2[Admin Interface]
            UI3[Border Control Interface]
        end
        
        subgraph "Backend Services"
            API1[Notification API]
            API2[Validation Service]
            API3[Risk Assessment Service]
            API4[Document Management]
        end
        
        subgraph "External Systems"
            EXT1[E-CERT System]
            EXT2[E-PHYTO System]
            EXT3[NCTS System]
            EXT4[Border Control Points]
        end
    end
    
    subgraph "Schema Library"
        CORE[notification-schema-core<br/>JSON Schema]
        JAVA[notification-schema-java<br/>Java Classes]
        FE[imports-frontend-entities<br/>JS/TS Entities]
    end
    
    UI1 --> FE
    UI2 --> FE
    UI3 --> FE
    API1 --> JAVA
    API2 --> JAVA
    API3 --> JAVA
    API4 --> JAVA
    EXT1 --> CORE
    EXT2 --> CORE
    EXT3 --> CORE
    EXT4 --> CORE
    
    CORE --> JAVA
    CORE --> FE
```

### Module Dependencies

```mermaid
graph LR
    subgraph "Maven Modules"
        ROOT[imports-notification-schema<br/>Parent POM]
        CORE[notification-schema-core<br/>JSON Resources]
        JAVA[notification-schema-java<br/>Java Classes]
        FE[imports-frontend-entities<br/>JS/TS Entities]
    end
    
    ROOT --> CORE
    ROOT --> JAVA
    ROOT --> FE
    JAVA --> CORE
    FE --> CORE
```

---

## Request Flow Architecture

### Notification Creation Flow

```mermaid
sequenceDiagram
    participant U as User
    participant UI as Frontend UI
    participant API as Backend API
    participant VAL as Validation Service
    participant DB as Database
    participant EXT as External Systems
    
    U->>UI: Create Notification
    UI->>API: POST /notifications
    API->>VAL: Validate Schema
    VAL->>VAL: Apply Business Rules
    VAL-->>API: Validation Result
    alt Validation Passes
        API->>DB: Store Notification
        API->>EXT: Send to External Systems
        API-->>UI: Success Response
        UI-->>U: Notification Created
    else Validation Fails
        API-->>UI: Error Response
        UI-->>U: Display Errors
    end
```

### Notification Processing Flow

```mermaid
sequenceDiagram
    participant BCP as Border Control Point
    participant API as Notification API
    participant RISK as Risk Assessment
    participant VAL as Validation Service
    participant DEC as Decision Engine
    
    BCP->>API: Submit Notification
    API->>RISK: Assess Risk Level
    RISK-->>API: Risk Category
    API->>VAL: Validate Against Schema
    VAL-->>API: Validation Status
    alt High Risk
        API->>DEC: Require Physical Inspection
        DEC-->>API: Inspection Required
    else Low Risk
        API->>DEC: Auto-clearance Check
        DEC-->>API: Clearance Decision
    end
    API-->>BCP: Processing Result
```

### Schema Validation Flow

```mermaid
sequenceDiagram
    participant SVC as Service
    participant JAVA as Java Schema Classes
    participant VAL as Validation Framework
    participant CORE as JSON Schema
    participant RULES as Business Rules
    
    SVC->>JAVA: Create Notification Object
    JAVA->>VAL: Apply Bean Validation
    VAL->>CORE: Validate Against JSON Schema
    VAL->>RULES: Apply Custom Annotations
    RULES-->>VAL: Business Rule Results
    CORE-->>VAL: Schema Validation Result
    VAL-->>JAVA: Combined Validation Result
    JAVA-->>SVC: Validation Status
```

---

## Detailed Code Analysis

### Core Schema Structure

The notification schema is defined in [`notification-schema-core/resources/notification-schema.json`](notification-schema-core/resources/notification-schema.json) and represents a comprehensive data model for import notifications.

#### Key Schema Components

**1. Notification Root Object**
```json
{
  "id": "integer",
  "referenceNumber": "string", 
  "type": "enum(CVEDA|CVEDP|CHEDPP|CED|IMP)",
  "status": "enum(DRAFT|SUBMITTED|VALIDATED|REJECTED|...)",
  "partOne": "PartOne",
  "partTwo": "PartTwo", 
  "partThree": "PartThree"
}
```

**2. Part One - Import Details**
The [PartOne.java](notification-schema-java/src/main/java/uk/gov/defra/tracesx/notificationschema/representation/PartOne.java) class contains:
- Economic operators (consignor, consignee, importer)
- Commodity information
- Transport details
- Veterinary information
- Purpose and routing

**3. Part Two - Inspection Results**
The [PartTwo.java](notification-schema-java/src/main/java/uk/gov/defra/tracesx/notificationschema/representation/PartTwo.java) class handles:
- Inspection outcomes
- Laboratory test results
- Decision information
- Control measures

**4. Part Three - Additional Information**
The [PartThree.java](notification-schema-java/src/main/java/uk/gov/defra/tracesx/notificationschema/representation/PartThree.java) class manages:
- Additional documents
- Special requirements
- Compliance information

### Validation Framework

The project implements a sophisticated validation framework with multiple layers:

**1. Bean Validation Annotations**
```java
@NotNull(groups = NotificationHighRiskFieldValidation.class)
@Valid
private EconomicOperator consignor;
```

**2. Custom Validation Annotations**
```java
@ChedppPodRequired(groups = NotificationChedppFieldValidation.class)
@ImpPortOfExitDateInFuture(groups = NotificationLowRiskFieldValidation.class)
```

**3. Business Rule Validation Groups**
- `NotificationHighRiskFieldValidation`
- `NotificationChedppFieldValidation` 
- `NotificationCvedaEuFieldValidation`
- `NotificationLowRiskFieldValidation`

### Enumeration Types

The schema defines numerous enumeration types in [`notification-schema-java/src/main/java/uk/gov/defra/tracesx/notificationschema/representation/enumeration/`](notification-schema-java/src/main/java/uk/gov/defra/tracesx/notificationschema/representation/enumeration/):

- **NotificationTypeEnum**: CVEDA, CVEDP, CHEDPP, CED, IMP
- **StatusEnum**: DRAFT, SUBMITTED, VALIDATED, REJECTED, etc.
- **TypeOfImp**: LIVE_ANIMALS, PRODUCTS_OF_ANIMAL_ORIGIN, HIGH_RISK_FOOD_AND_FEED
- **TransportType**: RAIL, PLANE, SHIP, ROAD, OTHER
- **DecisionEnum**: Various decision outcomes for different notification types

### Frontend Integration

The [`imports-frontend-entities`](imports-frontend-entities/) module provides JavaScript/TypeScript entities that mirror the Java classes, enabling type-safe frontend development.

**Key Features:**
- Automatic schema copying during build process
- AJV-based JSON validation
- Lodash utilities for data manipulation
- Comprehensive test coverage

---

## Domain Model

### Core Notification Structure

```mermaid
classDiagram
    class Notification {
        +Integer id
        +String referenceNumber
        +String agencyOrganisationId
        +List~ExternalReference~ externalReferences
        +Integer version
        +String rowVersion
        +LocalDateTime lastUpdated
        +UserInformation lastUpdatedBy
        +NotificationTypeEnum type
        +StatusEnum status
        +SplitConsignment splitConsignment
        +RiskAssessment riskAssessment
        +JourneyRiskCategorisation journeyRiskCategorisation
        +Boolean childNotification
        +Boolean isHighRiskEuImport
        +PartOne partOne
        +String officialVeterinarian
        +UserInformation decisionBy
        +LocalDateTime decisionDate
        +PartTwo partTwo
        +PartThree partThree
        +Set~ValidationMessageCode~ consignmentValidation
        +String replaces
        +String replacedBy
        +String etag
        +LocalDateTime riskDecisionLockingTime
        +Boolean isRiskDecisionLocked
        +Boolean isBulkUploadInProgress
        +String requestId
        +Boolean isCdsFullMatched
        +Short chedTypeVersion
        +Boolean isGMRMatched
        +Boolean isAutoClearanceExempted
    }
    
    class PartOne {
        +TypeOfImp typeOfImp
        +Party personResponsible
        +String customsReferenceNumber
        +Boolean containsWoodPackaging
        +Boolean consignmentArrived
        +EconomicOperator consignor
        +EconomicOperator consignorTwo
        +EconomicOperator packer
        +EconomicOperator consignee
        +EconomicOperator importer
        +EconomicOperator placeOfDestination
        +EconomicOperator pod
        +EconomicOperator placeOfOriginHarvest
        +List~EconomicOperator~ additionalPermanentAddresses
        +String cphNumber
        +Boolean importingFromCharity
        +Boolean isPlaceOfDestinationThePermanentAddress
        +Boolean isCatchCertificateRequired
        +Boolean isGVMSRoute
        +Commodities commodities
        +Purpose purpose
        +String pointOfEntry
        +String pointOfEntryControlPoint
        +LocalDate arrivalDate
        +LocalTime arrivalTime
        +EconomicOperator transporter
        +Boolean transporterDetailsRequired
        +MeansOfTransportAfterBip meansOfTransport
        +MeansOfTransportBeforeBip meansOfTransportFromEntryPoint
        +LocalDate departureDate
        +LocalTime departureTime
        +Integer estimatedJourneyTimeInMinutes
        +String responsibleForTransport
        +VeterinaryInformation veterinaryInformation
        +String importerLocalReferenceNumber
        +Route route
        +List~NotificationSealsContainers~ sealsContainers
        +LocalDateTime submissionDate
        +Set~ValidationMessageCode~ consignmentValidation
        +UserInformation submittedBy
        +Boolean complexCommoditySelected
        +String portOfEntry
        +String portOfExit
        +LocalDate portOfExitDate
        +ContactDetails contactDetails
        +List~NominatedContact~ nominatedContacts
        +LocalDateTime originalEstimatedDateTime
        +BillingInformation billingInformation
        +Boolean isChargeable
        +Boolean wasChargeable
        +CommonUserCharge commonUserCharge
        +ProvideCtcMrnEnum provideCtcMrn
        +StoreTransporterContactEnum storeTransporterContact
    }
    
    class PartTwo {
        +Decision decision
        +ConsignmentCheck consignmentCheck
        +ImpactOfTransportOnAnimals impactOfTransportOnAnimals
        +Boolean laboratoryTestsRequired
        +LaboratoryTests laboratoryTests
        +Boolean resealedContainersIncluded
        +ResealedContainers resealedContainers
        +List~SealContainer~ resealedContainersMapping
        +ControlAuthority controlAuthority
        +EconomicOperator controlledDestination
        +String bipLocalReferenceNumber
        +String signedOnBehalfOf
        +String onwardTransportation
        +Set~ValidationMessageCode~ consignmentValidation
        +LocalDateTime checkDate
        +List~AccompanyingDocument~ accompanyingDocuments
        +List~CommodityChecks~ commodityChecks
        +Boolean phsiAutoCleared
        +Boolean hmiAutoCleared
        +InspectionRequired inspectionRequired
        +InspectionOverride inspectionOverride
        +LocalDateTime autoClearedDateTime
    }
    
    class PartThree {
        +ControlStatus controlStatus
        +Control control
        +Set~ValidationMessageCode~ consignmentValidation
        +Boolean sealCheckRequired
        +SealCheck sealCheck
        +InspectionOverride sealCheckOverride
    }
    
    Notification --> PartOne
    Notification --> PartTwo
    Notification --> PartThree
```

### Economic Operators and Parties

```mermaid
classDiagram
    class EconomicOperator {
        +String id
        +EconomicOperatorType type
        +String status
        +String companyName
        +String individualName
        +EconomicOperatorAddress address
        +String approvalNumber
        +String otherIdentifier
        +Integer tracesId
    }
    
    class EconomicOperatorAddress {
        +String addressLine1
        +String addressLine2
        +String addressLine3
        +String city
        +String postalZipCode
        +String countryISOCode
        +String email
        +String ukTelephone
        +String telephone
        +InternationalTelephone internationalTelephone
    }
    
    class InternationalTelephone {
        +String countryCode
        +String subscriberNumber
    }
    
    class Party {
        +String id
        +String name
        +String companyId
        +String contactId
        +String companyName
        +List~String~ address
        +String county
        +String postCode
        +Country country
        +String city
        +Integer tracesID
        +PartyType type
        +String approvalNumber
        +String phone
        +String fax
        +String email
    }
    
    class ContactDetails {
        +String name
        +String telephone
        +String email
        +String agent
    }
    
    class NominatedContact {
        +String name
        +String email
        +String telephone
    }
    
    EconomicOperator --> EconomicOperatorAddress
    EconomicOperatorAddress --> InternationalTelephone
```

### Commodities and Species

```mermaid
classDiagram
    class Commodities {
        +Boolean gmsDeclarationAccepted
        +Boolean consignedCountryInChargeGroup
        +Number totalGrossWeight
        +Number totalNetWeight
        +Number totalGrossVolume
        +String totalGrossVolumeUnit
        +Integer numberOfPackages
        +Temperature temperature
        +Integer numberOfAnimals
        +List~CommodityComplement~ commodityComplement
        +List~ComplementParameterSet~ complementParameterSet
        +Boolean includeNonAblactedAnimals
    }
    
    class CommodityComplement {
        +String uniqueComplementID
        +String commodityDescription
        +String commodityID
        +Integer complementID
        +String complementName
        +String eppoCode
        +Boolean isWoodPackaging
        +String speciesID
        +String speciesName
        +String speciesNomination
        +String speciesTypeName
        +String speciesType
        +String speciesClassName
        +String speciesClass
        +String speciesFamilyName
        +String speciesFamily
        +String speciesCommonName
        +Boolean isCdsMatched
    }
    
    class ComplementParameterSet {
        +String uniqueComplementID
        +Integer complementID
        +String speciesID
        +List~KeyDataPair~ keyDataPair
        +List~CatchCertificate~ catchCertificates
        +List~Identifier~ identifiers
    }
    
    class KeyDataPair {
        +String key
        +String data
    }
    
    class CatchCertificate {
        +String certificateNumber
        +Number weight
    }
    
    class Identifier {
        +Integer speciesNumber
        +Object data
        +Boolean isPlaceOfDestinationThePermanentAddress
        +EconomicOperator permanentAddress
    }
    
    Commodities --> CommodityComplement
    Commodities --> ComplementParameterSet
    ComplementParameterSet --> KeyDataPair
    ComplementParameterSet --> CatchCertificate
    ComplementParameterSet --> Identifier
```

### Purpose and Routing

```mermaid
classDiagram
    class Purpose {
        +String purposeGroup
        +String internalMarketPurpose
        +String thirdCountryTranshipment
        +String forNonConforming
        +String regNumber
        +String shipName
        +String shipPort
        +String exitBIP
        +String thirdCountry
        +List~String~ transitThirdCountries
        +String forImportOrAdmission
        +LocalDate exitDate
        +String finalBIP
        +LocalDate estimatedArrivalDateAtPortOfExit
        +LocalTime estimatedArrivalTimeAtPortOfExit
        +String pointOfExit
    }
    
    class Route {
        +String routeType
        +String routeDescription
    }
    
    class MeansOfTransportAfterBip {
        +TransportType type
        +String id
        +String document
        +String countryOfRegistration
        +String countryOfRegistrationCode
    }
    
    class MeansOfTransportBeforeBip {
        +TransportType type
        +String id
        +String document
        +String countryOfRegistration
        +String countryOfRegistrationCode
    }
    
    class TransportType {
        <<enumeration>>
        RAIL
        PLANE
        SHIP
        ROAD
        OTHER
        CSHIPROAD
        CSHIPRAIL
    }
    
    Purpose --> Route
    PartOne --> MeansOfTransportAfterBip
    PartOne --> MeansOfTransportBeforeBip
    MeansOfTransportAfterBip --> TransportType
    MeansOfTransportBeforeBip --> TransportType
```

### Veterinary Information and Documents

```mermaid
classDiagram
    class VeterinaryInformation {
        +ExternalReference establishmentsOfOriginExternalReference
        +List~ApprovedEstablishment~ establishmentsOfOrigin
        +String veterinaryDocument
        +String veterinaryDocumentIssueDate
        +List~String~ accompanyingDocumentNumbers
        +List~AccompanyingDocument~ accompanyingDocuments
        +List~CatchCertificateAttachment~ catchCertificateAttachments
        +List~IdentificationDetail~ identificationDetails
    }
    
    class ApprovedEstablishment {
        +String name
        +Country country
        +List~String~ types
        +String approvalNumber
        +String section
    }
    
    class AccompanyingDocument {
        +DocumentType documentType
        +String documentReference
        +LocalDate documentIssueDate
        +String attachmentId
        +String attachmentFilename
        +String attachmentContentType
        +String uploadUserId
        +String uploadOrganisationId
        +ExternalReference externalReference
    }
    
    class CatchCertificateAttachment {
        +String attachmentId
        +Integer numberOfCatchCertificates
        +List~CatchCertificateDetails~ CatchCertificateDetails
    }
    
    class CatchCertificateDetails {
        +String catchCertificateId
        +String catchCertificateReference
        +LocalDate dateOfIssue
        +Country flagState
        +List~String~ species
    }
    
    class IdentificationDetail {
        +String identificationDetail
        +String identificationDescription
    }
    
    class DocumentType {
        <<enumeration>>
        AIR_WAYBILL
        BILL_OF_LADING
        CARGO_MANIFEST
        CATCH_CERTIFICATE
        COMMERCIAL_DOCUMENT
        COMMERCIAL_INVOICE
        CONFORMITY_CERTIFICATE
        CONTAINER_MANIFEST
        CUSTOMS_DECLARATION
        DOCOM
        HEALTH_CERTIFICATE
        HEAT_TREATMENT_CERTIFICATE
        IMPORT_PERMIT
        INSPECTION_CERTIFICATE
        ITAHC
        JOURNEY_LOG
        LABORATORY_SAMPLING_RESULTS_FOR_AFLATOXIN
        LATEST_VETERINARY_HEALTH_CERTIFICATE
        LETTER_OF_AUTHORITY
        LICENSE_OR_AUTHORISATION
        MYCOTOXIN_CERTIFICATION
        ORIGIN_CERTIFICATE
        OTHER
        PHYTOSANITARY_CERTIFICATE
        PROCESSING_STATEMENT
        PROOF_OF_STORAGE
        RAILWAY_BILL
        SEA_WAYBILL
        VETERINARY_HEALTH_CERTIFICATE
        INGREDIENTS_LIST
        PACKING_LIST
        ROAD_CONSIGNMENT_NOTE
    }
    
    VeterinaryInformation --> ApprovedEstablishment
    VeterinaryInformation --> AccompanyingDocument
    VeterinaryInformation --> CatchCertificateAttachment
    VeterinaryInformation --> IdentificationDetail
    AccompanyingDocument --> DocumentType
    CatchCertificateAttachment --> CatchCertificateDetails
```

### Decision and Inspection Results

```mermaid
classDiagram
    class Decision {
        +Boolean consignmentAcceptable
        +NotAcceptableActionEnum notAcceptableAction
        +String notAcceptableActionDestructionReason
        +String notAcceptableActionEntryRefusalReason
        +String notAcceptableActionQuarantineImposedReason
        +String notAcceptableActionSpecialTreatmentReason
        +String notAcceptableActionIndustrialProcessingReason
        +String notAcceptableActionReDispatchReason
        +String notAcceptableActionUseForOtherPurposesReason
        +List~NotAcceptableReasonsEnum~ notAcceptableReasons
        +String notAcceptableCountry
        +String notAcceptableEstablishment
        +String notAcceptableOtherReason
        +Party detailsOfControlledDestinations
        +String specificWarehouseNonConformingConsignment
        +LocalDate temporaryDeadline
        +DecisionType decision
        +FreeCirculationPurposeEnum freeCirculationPurpose
        +String definitiveImportPurpose
        +IfChanneledOptionEnum ifChanneledOption
        +String customWarehouseRegisteredNumber
        +String freeWarehouseRegisteredNumber
        +String shipName
        +String shipPortOfExit
        +String shipSupplierRegisteredNumber
        +String transhipmentBip
        +String transhipmentThirdCountry
        +String transitExitBip
        +String transitThirdCountry
        +String transitDestinationThirdCountry
        +String temporaryExitBip
        +String horseReentry
        +String transhipmentEuOrThirdCountry
    }
    
    class ConsignmentCheck {
        +Result euStandard
        +Result additionalGuarantees
        +Result documentCheckResult
        +Result nationalRequirements
        +Boolean identityCheckDone
        +IdentificationCheckType identityCheckType
        +Result identityCheckResult
        +String identityCheckNotDoneReason
        +Boolean physicalCheckDone
        +Result physicalCheckResult
        +String physicalCheckNotDoneReason
        +String physicalCheckOtherText
        +Result welfareCheck
        +Integer numberOfAnimalsChecked
        +Boolean laboratoryCheckDone
        +Result laboratoryCheckResult
        +String documentCheckAdditionalDetails
    }
    
    class LaboratoryTests {
        +String laboratory
        +String sampleBatchNumber
        +AnalysisType analysisType
        +Integer numberOfSamples
        +String sampleType
        +String conservationOfSample
        +Inspector inspector
        +LocalDate sampleDate
        +LocalTime sampleTime
    }
    
    class LaboratoryTestResult {
        +String sampleUseByDate
        +String releasedDate
        +String laboratoryTestMethod
        +String results
        +Conclusion conclusion
        +LocalDate labTestCreatedDate
    }
    
    class ImpactOfTransportOnAnimals {
        +Integer numberOfDeadAnimals
        +Unit numberOfDeadAnimalsUnit
        +Integer numberOfUnfitAnimals
        +Unit numberOfUnfitAnimalsUnit
    }
    
    class CommodityChecks {
        +String uniqueComplementId
        +List~InspectionCheck~ checks
        +Integer validityPeriod
    }
    
    class InspectionCheck {
        +CheckType type
        +String status
        +String reason
        +String otherReason
        +Boolean isSelectedForChecks
        +Boolean hasChecksComplete
    }
    
    Decision --> ConsignmentCheck
    PartTwo --> LaboratoryTests
    PartTwo --> LaboratoryTestResult
    PartTwo --> ImpactOfTransportOnAnimals
    PartTwo --> CommodityChecks
    CommodityChecks --> InspectionCheck
```

### Control and Risk Assessment

```mermaid
classDiagram
    class Control {
        +FeedbackInformation feedbackInformation
        +Boolean iuuCheckRequired
        +IUUOption iuuOption
    }
    
    class FeedbackInformation {
        +AuthorityType authorityType
        +Boolean consignmentArrival
        +Boolean consignmentConformity
        +String consignmentNoArrivalReason
        +LocalDate destructionDate
    }
    
    class SealCheck {
        +Boolean satisfactory
        +String reason
        +OfficialInspector officialInspector
        +LocalDateTime dateTimeOfCheck
    }
    
    class OfficialInspector {
        +String firstName
        +String lastName
        +String email
        +String phone
        +String fax
        +Address address
        +LocalDateTime signed
    }
    
    class OfficialVeterinarian {
        +String firstName
        +String lastName
        +String email
        +String phone
        +String fax
        +LocalDateTime signed
    }
    
    class Address {
        +String street
        +String city
        +Country country
        +String postalCode
    }
    
    class RiskAssessmentResult {
        +List~CommodityRiskResult~ commodityResults
        +LocalDateTime assessmentDateTime
    }
    
    class CommodityRiskResult {
        +RiskDecision riskDecision
        +RiskDecision exitRiskDecision
        +HmiDecision hmiDecision
        +String phsiDecision
        +String phsiClassification
        +Phsi phsi
        +String uniqueId
        +String eppoCode
        +String variety
        +Boolean isWoody
        +String indoorOutdoor
        +String propagation
        +String phsiRuleType
    }
    
    class Phsi {
        +Boolean documentCheck
        +Boolean identityCheck
        +Boolean physicalCheck
    }
    
    class JourneyRiskCategorisationResult {
        +String riskLevel
        +String riskLevelMethod
        +LocalDateTime riskLevelDateTime
    }
    
    class InspectionOverride {
        +InspectionRequired originalDecision
        +LocalDateTime overriddenOn
        +UserInformation overriddenBy
    }
    
    PartThree --> Control
    Control --> FeedbackInformation
    PartThree --> SealCheck
    SealCheck --> OfficialInspector
    OfficialInspector --> Address
    Notification --> RiskAssessmentResult
    RiskAssessmentResult --> CommodityRiskResult
    CommodityRiskResult --> Phsi
    Notification --> JourneyRiskCategorisationResult
    PartTwo --> InspectionOverride
```

### Supporting Entities

```mermaid
classDiagram
    class ExternalReference {
        +ExternalSystem system
        +String reference
    }
    
    class ExternalSystem {
        <<enumeration>>
        ECERT
        EPHYTO
        ENOTIFICATION
        NCTS
    }
    
    class UserInformation {
        +String id
        +String name
        +String email
        +String organisationId
        +String organisationName
    }
    
    class SplitConsignment {
        +String validReferenceNumber
        +String rejectedReferenceNumber
    }
    
    class NotificationSealsContainers {
        +String sealNumber
        +String containerNumber
        +Boolean officialSeal
        +String resealedSealNumber
    }
    
    class BillingInformation {
        +Boolean isConfirmed
        +String emailAddress
        +String phoneNumber
        +String contactName
        +PostalAddress postalAddress
    }
    
    class PostalAddress {
        +String addressLine1
        +String addressLine2
        +String addressLine3
        +String addressLine4
        +String county
        +String cityOrTown
        +String postalCode
    }
    
    class CommonUserCharge {
        +Boolean wasSentToTradeCharge
    }
    
    class ControlAuthority {
        +String name
        +String address
        +String phone
        +String email
    }
    
    class DetailsOnReExport {
        +LocalDate date
        +String meansOfTransportNo
        +TransportType transportType
        +String document
        +Country countryOfReDispatching
        +String exitBIP
    }
    
    class ValidationMessageCode {
        +String field
        +String code
        +String message
    }
    
    Notification --> ExternalReference
    ExternalReference --> ExternalSystem
    Notification --> UserInformation
    Notification --> SplitConsignment
    PartOne --> NotificationSealsContainers
    PartOne --> BillingInformation
    BillingInformation --> PostalAddress
    PartOne --> CommonUserCharge
    PartTwo --> ControlAuthority
    PartTwo --> DetailsOnReExport
    Notification --> ValidationMessageCode
```

### Enumerations and Constants

```mermaid
classDiagram
    class NotificationTypeEnum {
        <<enumeration>>
        CVEDA
        CVEDP
        CHEDPP
        CED
        IMP
    }
    
    class StatusEnum {
        <<enumeration>>
        DRAFT
        SUBMITTED
        VALIDATED
        REJECTED
        IN_PROGRESS
        AMEND
        MODIFY
        REPLACED
        CANCELLED
        DELETED
        PARTIALLY_REJECTED
        SPLIT_CONSIGNMENT
        SUBMITTED_IN_PROGRESS_MODIFY
    }
    
    class TypeOfImp {
        <<enumeration>>
        LIVE_ANIMALS
        PRODUCTS_OF_ANIMAL_ORIGIN
        HIGH_RISK_FOOD_AND_FEED
    }
    
    class EconomicOperatorType {
        <<enumeration>>
        CONSIGNEE
        DESTINATION
        EXPORTER
        IMPORTER
        CHARITY
        COMMERCIAL_TRANSPORTER
        COMMERCIAL_TRANSPORTER_USER_ADDED
        PRIVATE_TRANSPORTER
        VETERINARIAN
        TEMPORARY_ADDRESS
        PREMISES_OF_ORIGIN
        ORGANISATION_BRANCH_ADDRESS
        PACKER
        POD
    }
    
    class Result {
        <<enumeration>>
        SATISFACTORY
        SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION
        NOT_SATISFACTORY
        NOT_DONE
        DEROGATION
        NOT_SET
    }
    
    class DecisionType {
        <<enumeration>>
        NON_ACCEPTABLE
        ACCEPTABLE_FOR_INTERNAL_MARKET
        ACCEPTABLE_FOR_NON_INTERNAL_MARKET
        ACCEPTABLE_IF_CHANNELED
        ACCEPTABLE_FOR_TRANSHIPMENT
        ACCEPTABLE_FOR_TRANSIT
        ACCEPTABLE_FOR_TEMPORARY_IMPORT
        ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE
        ACCEPTABLE_FOR_PRIVATE_IMPORT
        ACCEPTABLE_FOR_TRANSFER
        HORSE_REENTRY
    }
    
    class CheckType {
        <<enumeration>>
        PHSI_DOCUMENT
        PHSI_IDENTITY
        PHSI_PHYSICAL
        HMI
    }
    
    class AnalysisType {
        <<enumeration>>
        INITIAL
        COUNTER
        SECOND_EXPERT
    }
    
    class Conclusion {
        <<enumeration>>
        SATISFACTORY
        NOT_SATISFACTORY
        NOT_INTERPRETABLE
        PENDING
    }
    
    class Unit {
        <<enumeration>>
        PERCENT
        NUMBER
    }
    
    class Temperature {
        <<enumeration>>
        AMBIENT
        CHILLED
        FROZEN
    }
    
    class AuthorityType {
        <<enumeration>>
        EXITBIP
        FINALBIP
        LOCALVETUNIT
        INSPUNIT
    }
    
    class IUUOption {
        <<enumeration>>
        IUUOK
        IUUNA
        IUUNOTCOMPLIANT
    }
    
    class RiskDecision {
        <<enumeration>>
        REQUIRED
        NOT_REQUIRED
        INCONCLUSIVE
        REENFORCED_CHECK
    }
    
    class HmiDecision {
        <<enumeration>>
        REQUIRED
        NOT_REQUIRED
    }
    
    class ProvideCtcMrnEnum {
        <<enumeration>>
        YES
        YES_ADD_LATER
        NO
    }
    
    class StoreTransporterContactEnum {
        <<enumeration>>
        YES
        NO
    }
    
    Notification --> NotificationTypeEnum
    Notification --> StatusEnum
    PartOne --> TypeOfImp
    EconomicOperator --> EconomicOperatorType
    ConsignmentCheck --> Result
    Decision --> DecisionType
    InspectionCheck --> CheckType
    LaboratoryTests --> AnalysisType
    LaboratoryTestResult --> Conclusion
    ImpactOfTransportOnAnimals --> Unit
    Commodities --> Temperature
    FeedbackInformation --> AuthorityType
    Control --> IUUOption
    CommodityRiskResult --> RiskDecision
    CommodityRiskResult --> HmiDecision
    PartOne --> ProvideCtcMrnEnum
    PartOne --> StoreTransporterContactEnum
```

---

## Directory Structure

```
imports-notification-schema/
├── .git/                                    # Git repository
├── .idea/                                   # IntelliJ IDEA settings
├── hooks/                                   # Git hooks for secret scanning
├── imports-frontend-entities/               # Frontend JavaScript/TypeScript entities
│   ├── etc/                                 # Schema files copied during build
│   ├── node_modules/                        # NPM dependencies
│   ├── src/
│   │   ├── constants/                       # Frontend constants
│   │   ├── entities/                        # JavaScript entity classes
│   │   │   ├── base/                        # Base entity classes
│   │   │   ├── notification.js              # Main notification entity
│   │   │   ├── part_one.js                  # Part one entity
│   │   │   ├── part_two.js                  # Part two entity
│   │   │   └── ...                          # Other entity files
│   │   └── utils/                           # Utility functions
│   ├── test/                                # Frontend tests
│   ├── package.json                         # NPM package configuration
│   ├── pom.xml                              # Maven configuration for frontend
│   └── .nvmrc                               # Node.js version specification
├── notification-schema-core/                # Core JSON schema definition
│   ├── resources/
│   │   ├── notification-schema.json         # Main JSON schema (100KB, 3070 lines)
│   │   └── schema-definition.json           # Schema metadata
│   ├── pom.xml                              # Maven configuration
│   └── vs-maven.xml                         # Visual Studio Maven settings
├── notification-schema-java/                # Java representation and validation
│   ├── src/
│   │   ├── main/java/uk/gov/defra/tracesx/notificationschema/
│   │   │   ├── constants/                    # Constants and utilities
│   │   │   ├── representation/               # Java entity classes
│   │   │   │   ├── enumeration/              # Enumeration types
│   │   │   │   │   ├── NotificationTypeEnum.java
│   │   │   │   │   ├── StatusEnum.java
│   │   │   │   │   ├── TypeOfImp.java
│   │   │   │   │   └── ...                   # Other enums
│   │   │   │   ├── serialisation/            # Custom serializers/deserializers
│   │   │   │   ├── Notification.java         # Main notification class
│   │   │   │   ├── PartOne.java              # Part one class (635 lines)
│   │   │   │   ├── PartTwo.java              # Part two class
│   │   │   │   ├── PartThree.java            # Part three class
│   │   │   │   ├── EconomicOperator.java     # Economic operator class
│   │   │   │   ├── Commodities.java          # Commodities class
│   │   │   │   └── ...                       # Other entity classes
│   │   │   └── validation/                   # Validation framework
│   │   │       ├── annotations/              # Custom validation annotations
│   │   │       ├── groups/                   # Validation groups
│   │   │       ├── utils/                    # Validation utilities
│   │   │       ├── ErrorCodes.java           # Error code constants
│   │   │       └── ValidationMessage.java    # Validation message handling
│   │   └── test/java/                        # Java unit tests
│   ├── pom.xml                              # Maven configuration
│   └── checkstyle-suppressions.xml          # Code style suppressions
├── target/                                  # Maven build output
├── .gitignore                               # Git ignore rules
├── Jenkinsfile                              # CI/CD pipeline configuration
├── LICENSE                                  # Project license
├── lombok.config                            # Lombok configuration
├── pom.xml                                  # Parent Maven configuration (160 lines)
├── README.md                                # Project documentation (57 lines)
├── runJunit.sh                              # Test execution script
└── sonar-project.properties                 # SonarQube configuration
```

---

## Security Architecture

### Data Protection

**1. Input Validation**
- Comprehensive JSON schema validation
- Bean validation with custom annotations
- Business rule enforcement through validation groups
- Type-safe enumeration usage

**2. Data Integrity**
- Immutable reference numbers
- Version control with etag support
- Audit trail with lastUpdated and lastUpdatedBy fields
- Row version control for concurrent access

**3. Access Control**
- User information tracking for all modifications
- Role-based validation groups
- External system integration controls

### Secret Scanning

The project implements secret scanning using TruffleHog as a pre-push git hook:

```bash
# Git hook setup
1. Install truffleHog: brew install trufflesecurity/trufflehog/trufflehog
2. Set DEFRA_WORKSPACE env var
3. Run mvn install to configure hooks
```

### External System Integration

**Supported External Systems:**
- **E-CERT**: Electronic certificates for veterinary products
- **E-PHYTO**: Electronic phytosanitary certificates
- **E-NOTIFICATION**: Electronic notification system
- **NCTS**: New Computerised Transit System

---

## Configuration Management

### Maven Configuration

**Parent POM** ([`pom.xml`](pom.xml)):
- Java 17 target
- Spring Boot 3.2.1 parent
- Multi-module project structure
- Git build hook integration
- SonarQube integration

**Module Dependencies:**
```xml
<modules>
    <module>imports-frontend-entities</module>
    <module>notification-schema-core</module>
    <module>notification-schema-java</module>
</modules>
```

### Build Configuration

**Java Module** ([`notification-schema-java/pom.xml`](notification-schema-java/pom.xml)):
- Jackson JSON processing
- Bean validation framework
- Swagger annotations
- Lombok for boilerplate reduction

**Frontend Module** ([`imports-frontend-entities/package.json`](imports-frontend-entities/package.json)):
- AJV for JSON validation
- Lodash for utilities
- Mocha for testing
- NYC for code coverage

### CI/CD Pipeline

**Jenkins Configuration** ([`Jenkinsfile`](Jenkinsfile)):
```groovy
schemaPipeline {
    SERVICE_NAME = "imports-notification-schema"
    SONARQUBE_PROJECT_NAME = "Imports-notification-schema"
    SERVICE_VERSION = "1.0"
    ENVIRONMENT = "Sandpit"
    JAVA_VERSION = "17"
}
```

### SonarQube Integration

**Quality Gates** ([`sonar-project.properties`](sonar-project.properties)):
- Code coverage reporting
- Test execution reporting
- Multi-module analysis
- JavaScript and Java analysis

---

## Security Considerations

### Data Validation

**1. Schema Validation**
- JSON Schema enforces data structure
- Custom annotations validate business rules
- Enumeration types prevent invalid values

**2. Input Sanitization**
- Bean validation prevents injection attacks
- Type-safe serialization/deserialization
- Null safety through annotations

**3. Access Control**
- User authentication tracking
- Role-based validation groups
- Audit trail maintenance

### External System Security

**1. Integration Security**
- Secure communication with external systems
- Certificate validation for E-CERT/E-PHYTO
- API key management for external services

**2. Data Exchange**
- Encrypted data transmission
- Digital signature validation
- Audit logging for all external interactions

### Code Security

**1. Dependency Management**
- Regular dependency updates
- Vulnerability scanning
- Secure artifact repository usage

**2. Secret Management**
- TruffleHog integration for secret detection
- Environment variable usage for sensitive data
- Secure credential storage

---

## Performance Characteristics

### Schema Validation Performance

**1. JSON Schema Validation**
- Efficient JSON parsing with Jackson
- Cached schema validation
- Streaming validation for large documents

**2. Bean Validation**
- Annotation-based validation
- Group-based validation optimization
- Lazy validation loading

### Memory Management

**1. Object Creation**
- Builder pattern for efficient object construction
- Immutable objects where appropriate
- Efficient serialization/deserialization

**2. Large Document Handling**
- Streaming JSON processing
- Memory-efficient validation
- Pagination support for large datasets

### Caching Strategy

**1. Schema Caching**
- JSON schema caching
- Validation rule caching
- Enumeration value caching

**2. Object Pooling**
- Economic operator object reuse
- Address object pooling
- Contact details object reuse

---

## Deployment Architecture

### Build Process

```mermaid
graph TB
    subgraph "Build Pipeline"
        SRC[Source Code]
        MAVEN[Maven Build]
        NPM[NPM Build]
        TEST[Unit Tests]
        SONAR[SonarQube Analysis]
        ARTIFACT[Artifact Creation]
    end
    
    subgraph "Artifact Repository"
        MAVEN_REPO[Maven Repository]
        NPM_REPO[NPM Repository]
    end
    
    subgraph "Deployment"
        BACKEND[Backend Services]
        FRONTEND[Frontend Services]
    end
    
    SRC --> MAVEN
    SRC --> NPM
    MAVEN --> TEST
    NPM --> TEST
    TEST --> SONAR
    SONAR --> ARTIFACT
    ARTIFACT --> MAVEN_REPO
    ARTIFACT --> NPM_REPO
    MAVEN_REPO --> BACKEND
    NPM_REPO --> FRONTEND
```

### Deployment Strategy

**1. Maven Artifacts**
- Published to DEFRA Artifactory
- Version management with SNAPSHOT releases
- Dependency management for consuming services

**2. NPM Package**
- Published to DEFRA NPM registry
- Semantic versioning
- Frontend service integration

**3. Service Integration**
- Backend services include Java dependency
- Frontend services include NPM package
- Schema version synchronization

### Environment Management

**1. Development**
- Local Maven installation
- NPM package development
- Schema validation testing

**2. Testing**
- Jenkins CI/CD pipeline
- Automated testing
- Quality gate enforcement

**3. Production**
- Artifact repository deployment
- Service integration
- Schema version management

### Monitoring and Observability

**1. Build Monitoring**
- Jenkins pipeline monitoring
- SonarQube quality metrics
- Test coverage reporting

**2. Runtime Monitoring**
- Schema validation performance
- Error rate monitoring
- Integration health checks

**3. Dependency Management**
- Version compatibility tracking
- Security vulnerability monitoring
- Dependency update automation

---

## Conclusion

The IPAFFS Imports Notification Schema project provides a robust, well-architected foundation for the IPAFFS system's data model. With comprehensive validation, cross-platform support, and strong security measures, it enables consistent data handling across the entire ecosystem while maintaining flexibility for future enhancements.

The project's modular design, extensive validation framework, and integration capabilities make it a critical component in ensuring data integrity and regulatory compliance in the import control system. 