const _ = require('lodash')
const handler = require('./base/handler')
const Decision = require('./decision')
const ConsignmentCheck = require('./consignment_check')
const ImpactOfTransportOnAnimals = require(
    './impact_of_transportation_on_animals')
const LaboratoryTests = require('./laboratory_tests')
const ControlAuthority = require('./control_authority')
const ConsignmentValidation = require('./consignment_validation')
const EconomicOperator = require('./economic_operator')

module.exports = class PartTwo {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }
    this.decision = _.get(obj, 'decision') ? new Decision(obj.decision)
        : undefined
    this.consignmentCheck = _.get(obj, 'consignmentCheck')
        ? new ConsignmentCheck(obj.consignmentCheck) : undefined
    this.impactOfTransportOnAnimals = _.get(obj, 'impactOfTransportOnAnimals')
        ? new ImpactOfTransportOnAnimals(obj.impactOfTransportOnAnimals)
        : undefined
    this.laboratoryTestsRequired = obj.laboratoryTestsRequired
    this.laboratoryTests = _.get(obj, 'laboratoryTests') ? new LaboratoryTests(
        obj.laboratoryTests) : undefined
    this.resealedContainersIncluded = obj.resealedContainersIncluded
    this.resealedContainers = _.get(obj, 'resealedContainers', [])
    this.resealedContainersMapping = getSealsContainers(_.get(obj, 'resealedContainersMapping', []))
    this.controlAuthority = _.get(obj, 'controlAuthority')
        ? new ControlAuthority(obj.controlAuthority) : undefined
    this.bipLocalReferenceNumber = obj.bipLocalReferenceNumber
    this.signedOnBehalfOf = obj.signedOnBehalfOf
    this.onwardTransportation = obj.onwardTransportation
    this.consignmentValidation = getConsignmentValidation(
        _.get(obj, 'consignmentValidation', []))
    this.checkDate = obj.checkDate
    this.controlledDestination = _.get(obj, 'controlledDestination')
        ? new EconomicOperator(obj.controlledDestination) : undefined

    return Object.seal(new Proxy(this, handler))
  }
}

const getSealsContainers = inList => {

  const sealsContainersList = []
  _.forEach(inList, seal => {
    sealsContainersList.push(new NotificationSealsContainers(seal))
})

  return sealsContainersList
}

const getConsignmentValidation = inList => {

  const consignmentValidationList = []
  _.forEach(inList, consignmentValidation => {
    consignmentValidationList.push(
        new ConsignmentValidation(consignmentValidation))
  })

  return consignmentValidationList
}