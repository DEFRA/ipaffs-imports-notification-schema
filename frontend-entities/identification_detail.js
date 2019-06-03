const handler = require('./base/handler')

module.exports = class IdentificationDetails {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.identificationDetail = obj.identificationDetail
    this.identificationDescription = obj.identificationDescription

    return Object.seal(new Proxy(this, handler))
  }
}