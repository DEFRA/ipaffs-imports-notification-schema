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

    this.personResponsible = _.get(obj, 'personResponsible') ? new Party(
        obj.personResponsible) : undefined

    this.customsReferenceNumber = obj.customsReferenceNumber
    this.containsWoodPackaging = obj.containsWoodPackaging
    this.consignmentArrived = obj.consignmentArrived

    this.consignor = _.get(obj, 'consignor') ? new EconomicOperator(
        obj.consignor) : undefined
    this.consignorTwo = _.get(obj, 'consignorTwo') ? new EconomicOperator(
      obj.consignorTwo) : undefined
    this.packer = _.get(obj, 'packer') ? new EconomicOperator(obj.packer) : undefined
    this.consignee = _.get(obj, 'consignee') ? new EconomicOperator(
        obj.consignee) : undefined
    this.importer = _.get(obj, 'importer') ? new EconomicOperator(obj.importer)
        : undefined
    this.placeOfDestination = _.get(obj, 'placeOfDestination')
        ? new EconomicOperator(obj.placeOfDestination) : undefined
    this.pod = _.get(obj, 'pod') ? new EconomicOperator(obj.pod) : undefined
    this.placeOfOriginHarvest = _.get(obj, 'placeOfOriginHarvest')
      ? new EconomicOperator(obj.placeOfOriginHarvest) : undefined
    this.additionalPermanentAddresses = getList(_.get(obj, 'additionalPermanentAddresses', []), EconomicOperator)

    this.cphNumber = obj.cphNumber
    this.importingFromCharity = obj.importingFromCharity
    this.isPlaceOfDestinationThePermanentAddress = obj.isPlaceOfDestinationThePermanentAddress
    this.commodities = _.get(obj, 'commodities') ? new Commodities(
        obj.commodities) : undefined
    this.purpose = _.get(obj, 'purpose') ? new Purpose(obj.purpose) : undefined
    this.pointOfEntry = obj.pointOfEntry
    this.pointOfEntryControlPoint = obj.pointOfEntryControlPoint
    this.arrivalDate = obj.arrivalDate
    this.arrivalTime = obj.arrivalTime
    this.meansOfTransport = _.get(obj, 'meansOfTransport')
        ? new MeansOfTransport(obj.meansOfTransport) : undefined
    this.transporter = _.get(obj, 'transporter') ? new EconomicOperator(
        obj.transporter) : undefined
    this.transporterDetailsRequired = obj.transporterDetailsRequired
    this.departureDate = obj.departureDate
    this.departureTime = obj.departureTime
    this.estimatedJourneyTimeInMinutes = obj.estimatedJourneyTimeInMinutes
    this.responsibleForTransport = obj.responsibleForTransport
    this.meansOfTransportFromEntryPoint = _.get(obj,
        'meansOfTransportFromEntryPoint') ? new MeansOfTransport(
            obj.meansOfTransportFromEntryPoint) : undefined
    this.veterinaryInformation = _.get(obj, 'veterinaryInformation')
        ? new VeterinaryInformation(obj.veterinaryInformation) : undefined
    this.importerLocalReferenceNumber = obj.importerLocalReferenceNumber
    this.route = _.get(obj, 'route') ? new Route(obj.route) : undefined
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
    this.billingInformation = obj.billingInformation ? new BillingInformation(obj.billingInformation) : undefined
    this.commonUserCharge = obj.commonUserCharge ? new CommonUserCharge(obj.commonUserCharge) : undefined
    this.isChargeable = obj.isChargeable

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

