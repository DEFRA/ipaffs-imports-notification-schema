const _ = require('lodash')

const handler = require('./base/handler')
const EconomicOperator = require('./economic_operator')

module.exports = class Identifiers {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.speciesNumber = obj.speciesNumber
    this.data = _.get(obj, 'data', {})
    this.isPlaceOfDestinationThePermanentAddress = obj.isPlaceOfDestinationThePermanentAddress
    this.permanentAddress = _.get(obj, 'permanentAddress')
        ? new EconomicOperator(obj.permanentAddress)
        : undefined
    return Object.seal(new Proxy(this, handler))
  }
}


