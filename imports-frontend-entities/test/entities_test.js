const chai = require('chai')

const Address = require('../src/entities/address')
const InspectionCheck = require('../src/entities/inspection_check')
const Applicant = require('../src/entities/applicant')
const ApprovedEstablishment = require('../src/entities/approved_establishment')
const Commodities = require('../src/entities/commodities')
const CommodityChecks = require('../src/entities/commodity_checks')
const Complement = require('../src/entities/complement')
const ComplementParameterSet = require('../src/entities/parameter_set')
const ConsignmentCheck = require('../src/entities/consignment_check')
const ConsignmentValidation = require('../src/entities/consignment_validation')
const Control = require('../src/entities/control')
const ControlAuthority = require('../src/entities/control_authority')
const Decision = require('../src/entities/decision')
const DetailsOnReexport = require('../src/entities/details_on_reexport')
const EconomicOperator = require('../src/entities/economic_operator')
const EconomicOperatorAddress = require('../src/entities/economic_operator_address')
const Error = require('../src/entities/error')
const FeedbackInformation = require('../src/entities/feedback_information')
const IdentificationDetail = require('../src/entities/identification_detail')
const Identifiers = require('../src/entities/identifiers')
const ImpactOfTransportationOnAnimals = require('../src/entities/impact_of_transportation_on_animals')
const Inspector = require('../src/entities/official_inspector')
const InternationalTelephone = require('../src/entities/international_telephone')
const KeyDataPair = require('../src/entities/key_data_pair')
const LaboratoryTestResult = require('../src/entities/laboratory_test_result')
const LaboratoryTests = require('../src/entities/laboratory_tests')
const MeansOfTransport = require('../src/entities/means_of_transport')
const Notification = require('../src/entities/notification')
const NotificationSealsContainers = require('../src/entities/notification_seals_containers')
const PartOne = require('../src/entities/part_one')
const PartThree = require('../src/entities/part_three')
const PartTwo = require('../src/entities/part_two')
const Party = require('../src/entities/party')
const Purpose = require('../src/entities/purpose')
const Route = require('../src/entities/route')
const SingleLaboratoryTests = require('../src/entities/singlelaboratory_tests')
const SplitConsignment = require('../src/entities/split_consignment')
const User = require('../src/entities/user')
const UserInfo = require('../src/entities/user_info')
const Veterinarian = require('../src/entities/official_veterinarian')
const VeterinaryInformation = require('../src/entities/veterinary_information')
const NominatedContact = require('../src/entities/nominated_contact')
const Document = require('../src/entities/document')
const ContactDetails = require('../src/entities/contact_details')
const ControlStatus = require('../src/entities/control_status')
const DestinationTypes = require('../src/entities/destination_types')
const EntitiesContainer = require('../src/entities/entities_container')
const RequestMetadata = require('../src/entities/request_metadata')
const Status = require('../src/entities/status')
const Transporter = require('../src/entities/transporter')
const AccompanyingDocument = require('../src/entities/accompanying_document')
const CatchCertificate = require('../src/entities/catch_certificate')
const CommodityRiskResult = require('../src/entities/commodity_risk_result')
const Phsi = require('../src/entities/phsi')
const InspectionOverride = require('../src/entities/inspection_override')
const ExternalReference = require('../src/entities/external_reference')
const RiskAssessment = require('../src/entities/risk_assessment')
const SealCheck = require('../src/entities/seal_check')
const CatchCertificateAttachment = require('../src/entities/catch_certificate_attachment')
const CatchCertificateDetails = require('../src/entities/catch_certificate_details')
const BillingInformation = require('../src/entities/billing_information')
const CommonUserCharge = require('../src/entities/common_user_charge')

describe('Entities: ', () => {

  const entities = [
    Address,
    InspectionCheck,
    Applicant,
    ApprovedEstablishment,
    Commodities,
    CommodityChecks,
    Complement,
    ComplementParameterSet,
    ConsignmentCheck,
    ConsignmentValidation,
    Control,
    ControlAuthority,
    Decision,
    DetailsOnReexport,
    EconomicOperator,
    EconomicOperatorAddress,
    Error,
    FeedbackInformation,
    IdentificationDetail,
    Identifiers,
    ImpactOfTransportationOnAnimals,
    Inspector,
    InternationalTelephone,
    KeyDataPair,
    LaboratoryTestResult,
    LaboratoryTests,
    MeansOfTransport,
    Notification,
    NominatedContact,
    NotificationSealsContainers,
    PartOne,
    PartThree,
    PartTwo,
    Party,
    Purpose,
    Route,
    SingleLaboratoryTests,
    SplitConsignment,
    User,
    UserInfo,
    Veterinarian,
    VeterinaryInformation,
    Document,
    ContactDetails,
    EntitiesContainer,
    RequestMetadata,
    Transporter,
    AccompanyingDocument,
    CatchCertificate,
    CommodityRiskResult,
    Phsi,
    InspectionOverride,
    ExternalReference,
    RiskAssessment,
    SealCheck,
    CatchCertificateAttachment,
    CatchCertificateDetails,
    CommonUserCharge,
    BillingInformation
  ]

  it('are capable of storing data', () => {
    let entityProperties
    for (let EntityClass of entities) {
      let entityInstance = new EntityClass()
      entityProperties = Object.getOwnPropertyNames(entityInstance)
      for (let property of entityProperties) {
        entityInstance[property] = 'test'
        chai.assert(entityInstance[property] === 'test', `Failed for entity: ${EntityClass.name}`)
        entityInstance[property] = 1
        chai.assert(entityInstance[property] === 1, `Failed for entity: ${EntityClass.name}`)
      }
    }
  })

  it('throws an exception if an invalid notification is used', () => {
    const invalidNotificationJson = {
      key: 'text'
    }

    chai.expect(() => new Notification(invalidNotificationJson)).to.throw()
  })

  it('validate status values', () => {
    let status = new Status()
    let expected = Object.freeze({
      DRAFT: 'Draft',
      SUBMITTED: 'New',
      AMEND: 'Amend',
      MODIFY: 'Modify',
      IN_PROGRESS: 'In Progress',
      VALIDATED: 'Valid',
      REJECTED: 'Rejected',
      CANCELLED: 'Cancelled',
      REPLACED: 'Replaced',
      PARTIALLY_REJECTED: 'Partially Rejected',
      SPLIT_CONSIGNMENT: 'Split Consignment',
      TO_PROCESS: 'To Process'
    });
    chai.assert.deepEqual(status, expected)
  })

  it('validate controlStatus values', () => {
    let controlStatus = new ControlStatus()
    let expected = Object.freeze({
      REQUIRED: 'Required',
      COMPLETED: 'Complete'
    })
    chai.assert.deepEqual(controlStatus, expected)
  })

  it('validate DestinationTypes values', () => {
    let destinationTypes = new DestinationTypes()
    let expected = Object.freeze({
      BALAI: 'Balai',
      QUARANTINE: 'Quarantine',
      BIRD_QUARANTINE: 'Bird Quarantine',
      ABP: 'ABP',
      OTHER_CONTROLLED_DESTINATION: 'Other Controlled Destination'
    })
    chai.assert.deepEqual(destinationTypes, expected)
  })
})
