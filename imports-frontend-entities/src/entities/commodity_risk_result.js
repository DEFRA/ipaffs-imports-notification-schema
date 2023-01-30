const handler = require('./base/handler')

module.exports = class CommodityRiskResult {
  constructor(obj = {}) {

    this.riskDecision = obj.riskDecision
    this.hmiDecision = obj.hmiDecision
    this.phsiDecision = obj.phsiDecision
    this.phsiClassification = obj.phsiClassification
    this.uniqueId = obj.uniqueId
    this.eppoCode = obj.eppoCode
    this.variety = obj.variety

    return Object.seal(new Proxy(this, handler))
  }
}