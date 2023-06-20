const handler = require('./base/handler')

module.exports = class InspectionCheck {

  constructor(obj = {}) {

    this.type = obj.type
    this.status = obj.status
    this.reason = obj.reason
    this.otherReason = obj.otherReason
    this.isSelectedForChecks = obj.isSelectedForChecks
    this.hasChecksComplete = obj.hasChecksComplete

    return Object.seal(new Proxy(this, handler))
  }
}