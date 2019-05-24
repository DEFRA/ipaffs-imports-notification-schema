const chai = require('chai')

const Address = require('../address')
const Applicant = require('../applicant')
const ApprovedEstablishment = require('../approved_establishment')
const Commodities = require('../commodities')
const Commodity = require('../commodity')
const Complement = require('../complement')
const ConsignmentCheck = require('../consignment_check')
const ConsignmentValidation = require('../consignment_validation')
const Control = require('../control')
const ControlAuthority = require('../control_authority')
const Decision = require('../decision')
const DetailsOnReexport = require('../details_on_reexport')
const Document = require('../document')
const EconomicOperator = require('../economic_operator')
const EconomicOperatorAddress = require('../economic_operator_address')
const EntitiesContainer = require('../entities_container')
const Error = require('../error')
const FeedbackInformation = require('../feedback_information')
const IdentificationDetail = require('../identification_detail')
const ImpactOfTransportationOnAnimals = require('../impact_of_transportation_on_animals')
const InternationalTelephone = require('../international_telephone')
const KeyDataPair = require('../key_data_pair')
const LaboratoryTestResult = require('../laboratory_test_result')
const LaboratoryTests = require('../laboratory_tests')
const MeansOfTransport = require('../means_of_transport')
const Notification = require('../notification')
const NotificationSealsContainers = require('../notification_seals_containers')
const OfficialInspector = require('../official_inspector')
const OfficialVeterinarian = require('../official_veterinarian')
const PartOne = require('../part_one')
const PartThree = require('../part_three')
const PartTwo = require('../part_two')
const Party = require('../party')
const Purpose = require('../purpose')
const RequestMetadata = require('../request_metadata')
const Route = require('../route')
const SinglelaboratoryTests = require('../singlelaboratory_tests')
const TransferPoints = require('../transfer_points')
const Transport = require('../transport')
const Transporter = require('../transporter')
const User = require('../user')
const UserInfo = require('../user_info')
const VeterinaryInformation = require('../veterinary_information')

describe('Entities test', () => {

  const entities = [
    Address,
    Applicant,
    ApprovedEstablishment,
    Commodities,
    Commodity,
    Complement,
    ConsignmentCheck,
    ConsignmentValidation,
    Control,
    ControlAuthority,
    Decision,
    DetailsOnReexport,
    Document,
    EconomicOperator,
    EconomicOperatorAddress,
    EntitiesContainer,
    Error,
    FeedbackInformation,
    IdentificationDetail,
    ImpactOfTransportationOnAnimals,
    InternationalTelephone,
    KeyDataPair,
    LaboratoryTestResult,
    LaboratoryTests,
    MeansOfTransport,
    Notification,
    NotificationSealsContainers,
    OfficialInspector,
    OfficialVeterinarian,
    PartOne,
    PartThree,
    PartTwo,
    Party,
    Purpose,
    RequestMetadata,
    Route,
    SinglelaboratoryTests,
    TransferPoints,
    Transport,
    Transporter,
    User,
    UserInfo,
    VeterinaryInformation
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
})