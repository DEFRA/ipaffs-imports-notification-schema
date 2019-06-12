const chai = require('chai')

const Address = require('../src/entities/address')
const Applicant = require('../src/entities/applicant')
const Commodities = require('../src/entities/commodities')
const Complement = require('../src/entities/complement')
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
const ImpactOfTransportationOnAnimals = require('../src/entities/impact_of_transportation_on_animals')
const Inspector = require('../src/entities/official_inspector')
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
const User = require('../src/entities/user')
const UserInfo = require('../src/entities/user_info')
const VeterinaryInformation = require('../src/entities/veterinary_information')
const Veterinarian = require('../src/entities/official_veterinarian')
const SingleLaboratoryTests = require('../src/entities/singlelaboratory_tests')

describe('Entities: ', () => {

  const entities = [
    PartOne,
    Commodities,
    Complement,
    ConsignmentCheck,
    ControlAuthority,
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