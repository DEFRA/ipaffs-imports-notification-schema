const handler = require('./base/handler')

module.exports = class InternationalTelephone {

  constructor(obj = {}) {

    this.countryCode = obj.countryCode
    this.subscriberNumber = obj.subscriberNumber

    return Object.seal(new Proxy(this, handler))
  }
}