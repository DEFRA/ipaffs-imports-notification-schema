const _ = require('lodash')
const handler = require('./base/handler')
const Address = require('./economic_operator_address')

module.exports = class EconomicOperator {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.id = obj.id
    this.type = obj.type
    this.status = obj.status
    this.companyName = obj.companyName
    this.individualName = obj.individualName
    this.address = _.get(obj, 'address') ? new Address(obj.address) : undefined
    this.approvalNumber = obj.approvalNumber
    this.otherIdentifier = obj.otherIdentifier
    this.tracesId = obj.tracesId

    return Object.seal(new Proxy(this, handler))
  }
}