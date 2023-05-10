const handler = require('./base/handler')

module.exports = class CommodityRiskResult {
  constructor(obj = {}) {

    this.riskDecision = obj.riskDecision
    this.hmiDecision = obj.hmiDecision
    this.phsiDecision = obj.phsiDecision
    this.phsiClassification = obj.phsiClassification
    this.phsi = obj.phsi
    this.uniqueId = obj.uniqueId
    this.eppoCode = obj.eppoCode
    this.variety = obj.variety
    this.isWoody = obj.isWoody
    this.indoorOutdoor = obj.indoorOutdoor
    this.propagation = obj.propagation
    this.phsiRuleType = obj.phsiRuleType

    return Object.seal(new Proxy(this, handler))
  }
}