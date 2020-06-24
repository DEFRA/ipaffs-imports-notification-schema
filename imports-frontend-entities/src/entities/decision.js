const _ = require('lodash')
const handler = require('./base/handler')
const Party = require('./party')

module.exports = class Decision {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.consignmentAcceptable = obj.consignmentAcceptable
    this.notAcceptableAction = obj.notAcceptableAction
    this.notAcceptableDestructionReason = obj.notAcceptableDestructionReason
    this.notAcceptableActionOtherReason = obj.notAcceptableActionOtherReason
    this.notAcceptableActionByDate = obj.notAcceptableActionByDate
    this.notAcceptableReasons = _.get(obj, 'notAcceptableReasons', [])
    this.chedppNotAcceptableReasons = _.get(obj, 'chedppNotAcceptableReasons', [])
    this.notAcceptableCountry = obj.notAcceptableCountry
    this.notAcceptableEstablishment = obj.notAcceptableEstablishment
    this.notAcceptableOtherReason = obj.notAcceptableOtherReason
    this.detailsOfControlledDestinations = obj.detailsOfControlledDestinations
        ? new Party(obj.detailsOfControlledDestinations) : undefined
    this.specificWarehouseNonConformingConsignment = obj.specificWarehouseNonConformingConsignment
    this.temporaryDeadline = obj.temporaryDeadline
    this.decision = obj.decision
    this.freeCirculationPurpose = obj.freeCirculationPurpose
    this.definitiveImportPurpose = obj.definitiveImportPurpose
    this.ifChanneledOption = obj.ifChanneledOption
    this.customWarehouseRegisteredNumber = obj.customWarehouseRegisteredNumber
    this.freeWarehouseRegisteredNumber = obj.freeWarehouseRegisteredNumber
    this.shipName = obj.shipName
    this.shipPortOfExit = obj.shipPortOfExit
    this.shipSupplierRegisteredNumber = obj.shipSupplierRegisteredNumber
    this.transhipmentBip = obj.transhipmentBip
    this.transhipmentThirdCountry = obj.transhipmentThirdCountry
    this.transitExitBip = obj.transitExitBip
    this.transitThirdCountry = obj.transitThirdCountry
    this.transitDestinationThirdCountry = obj.transitDestinationThirdCountry
    this.temporaryExitBip = obj.temporaryExitBip
    this.horseReentry = obj.horseReentry
    this.transhipmentEuOrThirdCountry = obj.transhipmentEuOrThirdCountry

    return Object.seal(new Proxy(this, handler))
  }
}
