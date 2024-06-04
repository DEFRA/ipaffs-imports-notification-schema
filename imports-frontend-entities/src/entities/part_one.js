const _ = require('lodash')
const handler = require('./base/handler')
const { getList } = require('../utils/list')
const EconomicOperator = require('./economic_operator')
const Party = require('./party')
const Commodities = require('./commodities')
const Purpose = require('./purpose')
const MeansOfTransport = require('./means_of_transport')
const VeterinaryInformation = require('./veterinary_information')
const Route = require('./route')
const NotificationSealsContainers = require('./notification_seals_containers')
const ConsignmentValidation = require('./consignment_validation')
const NominatedContact = require('./nominated_contact')
const BillingInformation = require('./billing_information')
const CommonUserCharge = require('./common_user_charge')

module.exports = class PartOne {

  constructor(obj = {}) {

    this.typeOfImp = obj.typeOfImp
    this.personResponsible = getIfDefined(obj, 'personResponsible', Party)
    this.customsReferenceNumber = obj.customsReferenceNumber
    this.containsWoodPackaging = obj.containsWoodPackaging
    this.consignmentArrived = obj.consignmentArrived
    this.consignor = getIfDefined(obj, 'consignor', EconomicOperator)
    this.consignorTwo = getIfDefined(obj, 'consignorTwo', EconomicOperator)
    this.packer = getIfDefined(obj, 'packer', EconomicOperator)
    this.consignee = getIfDefined(obj, 'consignee', EconomicOperator)
    this.importer = getIfDefined(obj, 'importer', EconomicOperator)
    this.placeOfDestination = getIfDefined(obj, 'placeOfDestination', EconomicOperator)
    this.pod = getIfDefined(obj, 'pod', EconomicOperator)
    this.placeOfOriginHarvest = getIfDefined(obj, 'placeOfOriginHarvest', EconomicOperator)
    this.additionalPermanentAddresses = getList(_.get(obj, 'additionalPermanentAddresses', []),
      EconomicOperator)
    this.cphNumber = obj.cphNumber
    this.importingFromCharity = obj.importingFromCharity
    this.isPlaceOfDestinationThePermanentAddress = obj.isPlaceOfDestinationThePermanentAddress
    this.commodities = getIfDefined(obj, 'commodities', Commodities)
    this.purpose = getIfDefined(obj, 'purpose', Purpose)
    this.pointOfEntry = obj.pointOfEntry
    this.pointOfEntryControlPoint = obj.pointOfEntryControlPoint
    this.arrivalDate = obj.arrivalDate
    this.arrivalTime = obj.arrivalTime
    this.meansOfTransport = getIfDefined(obj, 'meansOfTransport', MeansOfTransport)
    this.transporter = getIfDefined(obj, 'transporter', EconomicOperator)
    this.transporterDetailsRequired = obj.transporterDetailsRequired
    this.departureDate = obj.departureDate
    this.departureTime = obj.departureTime
    this.estimatedJourneyTimeInMinutes = obj.estimatedJourneyTimeInMinutes
    this.responsibleForTransport = obj.responsibleForTransport
    this.meansOfTransportFromEntryPoint = getIfDefined(obj, 'meansOfTransportFromEntryPoint', MeansOfTransport)
    this.veterinaryInformation = getIfDefined(obj, 'veterinaryInformation', VeterinaryInformation)
    this.importerLocalReferenceNumber = obj.importerLocalReferenceNumber
    this.route = getIfDefined(obj, 'route', Route)
    this.sealsContainers = getSealsContainers(_.get(obj, 'sealsContainers', []))
    this.submissionDate = obj.submissionDate
    this.consignmentValidation = getConsignmentValidation(
      _.get(obj, 'consignmentValidation', []))
    this.submittedBy = obj.submittedBy
    this.transporterDetailsRequired = obj.transporterDetailsRequired
    this.complexCommoditySelected = obj.complexCommoditySelected
    this.portOfEntry = obj.portOfEntry
    this.portOfExit = obj.portOfExit
    this.portOfExitDate = obj.portOfExitDate
    this.contactDetails = obj.contactDetails
    this.nominatedContacts = getList(_.get(obj, 'nominatedContacts', []), NominatedContact)
    this.originalEstimatedDateTime = obj.originalEstimatedDateTime
    this.isCatchCertificateRequired = obj.isCatchCertificateRequired
    this.isGVMSRoute = obj.isGVMSRoute
    this.billingInformation = getIfDefined(obj, 'billingInformation', BillingInformation)
    this.commonUserCharge = getIfDefined(obj, 'commonUserCharge', CommonUserCharge)
    this.isChargeable = obj.isChargeable
    this.wasChargeable = obj.wasChargeable
    this.provideCtcMrn = obj.provideCtcMrn

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

const getIfDefined = (obj, property, ClassType) =>{
  return _.get(obj, property) ? new ClassType(obj[property]) : undefined
}

const getConsignmentValidation = inList => {

  const consignmentValidationList = []
  _.forEach(inList, consignmentValidation => {
    consignmentValidationList.push(
      new ConsignmentValidation(consignmentValidation))
  })
  return consignmentValidationList
}
