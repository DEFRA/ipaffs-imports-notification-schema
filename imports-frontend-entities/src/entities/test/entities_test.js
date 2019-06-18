const chai = require('chai')

const Address = require('../address')
const Applicant = require('../applicant')
const Commodities = require('../commodities')
const Complement = require('../complement')
const ConsignmentCheck = require('../consignment_check')
const ConsignmentValidation = require('../consignment_validation')
const Control = require('../control')
const ControlAuthority = require('../control_authority')
const ControlStatuses = require('../control_status')
const Decision = require('../decision')
const DetailsOnReexport = require('../details_on_reexport')
const EconomicOperator = require('../economic_operator')
const EconomicOperatorAddress = require('../economic_operator_address')
const Error = require('../error')
const FeedbackInformation = require('../feedback_information')
const IdentificationDetail = require('../identification_detail')
const ImpactOfTransportationOnAnimals = require('../impact_of_transportation_on_animals')
const Inspector = require('../official_inspector')
const KeyDataPair = require('../key_data_pair')
const LaboratoryTestResult = require('../laboratory_test_result')
const LaboratoryTests = require('../laboratory_tests')
const MeansOfTransport = require('../means_of_transport')
const Notification = require('../notification')
const NotificationSealsContainers = require('../notification_seals_containers')
const PartOne = require('../part_one')
const PartThree = require('../part_three')
const PartTwo = require('../part_two')
const Party = require('../party')
const Purpose = require('../purpose')
const Route = require('../route')
const User = require('../user')
const UserInfo = require('../user_info')
const VeterinaryInformation = require('../veterinary_information')
const Veterinarian = require('../official_veterinarian')

describe('Entities: ', () => {

  const entities = [
    PartOne,
    Commodities,
    Complement,
    ConsignmentCheck,
    ControlAuthority,
    ControlStatuses,
    Notification,
    Purpose,
    Veterinarian,
    Inspector,
    Address,
    Applicant,
    ConsignmentValidation,
    Control,
    Decision,
    DetailsOnReexport,
    EconomicOperator,
    EconomicOperatorAddress,
    Error,
    FeedbackInformation,
    ImpactOfTransportationOnAnimals,
    KeyDataPair,
    LaboratoryTestResult,
    LaboratoryTests,
    MeansOfTransport,
    NotificationSealsContainers,
    PartTwo,
    PartThree,
    Party,
    Route,
    SingleLaboratoryTests,
    User,
    UserInfo,
    VeterinaryInformation,
    IdentificationDetail
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