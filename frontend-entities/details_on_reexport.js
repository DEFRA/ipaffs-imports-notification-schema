const handler = require('./base/handler')

module.exports = class DetailsOnReExport {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.date = obj.date
    this.meansOfTransportNo = obj.meansOfTransportNo
    this.transportType = obj.transportType
    this.document = obj.document
    this.countryOfReDispatching = obj.countryOfReDispatching

    return Object.seal(new Proxy(this, handler))
  }
}