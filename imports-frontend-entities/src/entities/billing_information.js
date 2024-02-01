const handler = require('./base/handler')

class PostalAddress {
  constructor(obj = {}) {

    this.addressLine1 = obj.addressLine1
    this.addressLine2 = obj.addressLine2
    this.addressLine3 = obj.addressLine3
    this.cityOrTown = obj.cityOrTown
    this.postalCode = obj.postalCode
  }
}

module.exports = class BillingInformation {

  constructor(obj = {}) {

    this.emailAddress = obj.emailAddress
    this.phoneNumber = obj.phoneNumber
    this.postalAddress = obj.postalAddress ? new PostalAddress(obj.postalAddress) : undefined

    return Object.seal(new Proxy(this, handler))
  }
}