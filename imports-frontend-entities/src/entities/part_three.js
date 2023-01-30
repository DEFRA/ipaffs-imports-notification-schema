const _ = require('lodash')
const handler = require('./base/handler')
const Control = require('./control')
const ConsignmentValidation = require('./consignment_validation')

module.exports = class PartThree {

  constructor(obj = {}) {

    this.control = _.get(obj, 'control') ? new Control(obj.control) : undefined
    this.consignmentValidation = getConsignmentValidation(
        _.get(obj, 'consignmentValidation', []))
    this.controlStatus = obj.controlStatus

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