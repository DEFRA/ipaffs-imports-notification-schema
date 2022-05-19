const handler = require('./base/handler')

module.exports = class InspectionOverride {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.originalDecision = obj.originalDecision
    this.overriddenOn = obj.overriddenOn
    this.overriddenBy = obj.overriddenBy
    this.overrideReason = obj.overrideReason
    this.overrideReasonOther = obj.overrideReasonOther()

    return Object.seal(new Proxy(this, handler))
  }
}