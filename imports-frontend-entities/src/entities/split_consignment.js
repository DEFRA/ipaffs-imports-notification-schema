const handler = require('./base/handler')

module.exports = class SplitConsignment {

  constructor(obj) {
    if (!obj) {
      obj = {}
    }

    this.validReferenceNumber = obj.validReferenceNumber
    this.rejectedReferenceNumber = obj.rejectedReferenceNumber

    return Object.seal(new Proxy(this, handler))
  }
}