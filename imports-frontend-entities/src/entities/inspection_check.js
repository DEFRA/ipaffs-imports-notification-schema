const handler = require('./base/handler')

module.exports = class InspectionCheck {

  constructor(obj) {
    if (!obj) {
      obj = {}
    }

    this.type = obj.type
    this.status = obj.status
    this.reason = obj.reason
    this.otherReason = obj.otherReason

    return Object.seal(new Proxy(this, handler))
  }
}