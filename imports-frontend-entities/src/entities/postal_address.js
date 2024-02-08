const handler = require('./base/handler')

module.exports = class PostalAddress {

  constructor(obj = {}) {

    this.addressLine1 = obj.addressLine1
    this.addressLine2 = obj.addressLine2
    this.county = obj.county
    this.cityOrTown = obj.cityOrTown
    this.postalCode = obj.postalCode
    return Object.seal(new Proxy(this, handler))
  }
}
