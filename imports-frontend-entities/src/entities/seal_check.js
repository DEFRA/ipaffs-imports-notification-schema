const handler = require('./base/handler')
const OfficialInspector = require('./official_inspector')

module.exports = class SealCheck {

  constructor (obj = {}) {

    this.satisfactory = obj.satisfactory
    this.reason = obj.reason
    this.officialInspector = obj.officialInspector
      ? new OfficialInspector(obj.officialInspector)
      : undefined
    this.dateTimeOfCheck = obj.dateTimeOfCheck

    return Object.seal(new Proxy(this, handler))
  }
}