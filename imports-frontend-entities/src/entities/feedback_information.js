const handler = require('./base/handler')

module.exports = class FeedBackInformation {

  constructor(obj) {
    if (!obj) {
      obj = {}
    }

    this.authorityType = obj.authorityType
    this.consignmentArrival = obj.consignmentArrival
    this.consignmentConformity = obj.consignmentConformity
    this.consignmentNoArrivalReason = obj.consignmentNoArrivalReason
    this.destructionDate = obj.destructionDate

    return Object.seal(new Proxy(this, handler))
  }

}