const _ = require('lodash')
const handler = require('./base/handler')
const Control = require('./control')
const ConsignmentValidation = require('./consignment_validation')
const SealCheck = require('./seal_check')
const InspectionOverride = require('./inspection_override')

module.exports = class PartThree {

  constructor(obj = {}) {

    this.control = _.get(obj, 'control') ? new Control(obj.control) : undefined
    this.consignmentValidation = getConsignmentValidation(
        _.get(obj, 'consignmentValidation', []))
    this.controlStatus = obj.controlStatus
    this.sealCheckRequired = obj.sealCheckRequired
    this.sealCheck = obj.sealCheck
      ? new SealCheck(obj.sealCheck)
      : undefined
    this.sealCheckOverride = obj.sealCheckOverride
      ? new InspectionOverride(obj.sealCheckOverride)
      : undefined

    return Object.seal(new Proxy(this, handler))
  }
}

const getConsignmentValidation = inList => {

  const consignmentValidationList = []
  _.forEach(inList, consignmentValidation => {
    consignmentValidationList.push(
        new ConsignmentValidation(consignmentValidation))
  })

  return consignmentValidationList
}