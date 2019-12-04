const handler = require('./base/handler')
const InternationalTelephone = require('./international_telephone')
const _ = require('lodash')

module.exports = class EconomicOperatorAddress {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.addressLine1 = obj.addressLine1
    this.addressLine2 = obj.addressLine2
    this.addressLine3 = obj.addressLine3
    this.city = obj.city
    this.postalZipCode = obj.postalZipCode
    this.countryISOCode = obj.countryISOCode
    this.internationalTelephone = _.get(obj, 'internationalTelephone')
        ? new InternationalTelephone(obj.internationalTelephone) : undefined
    this.email = obj.email
    this.ukTelephone = obj.ukTelephone
    this.telephone = obj.telephone
    return Object.seal(new Proxy(this, handler))
  }
}