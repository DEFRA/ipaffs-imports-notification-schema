const handler = require('./base/handler')

module.exports = class Address {

  constructor(obj = {}) {

    this.street = obj.street
    this.city = obj.city
    this.country = obj.country
    this.postalCode = obj.postalCode

    return Object.seal(new Proxy(this, handler))
  }
}