const handler = require('./base/handler')

module.exports = class JourneyRiskCategorisation {

  constructor(obj = {}) {

    this.riskLevel = obj.riskLevel
    this.riskLevelMethod = obj.riskLevelMethod
    this.riskLevelDateTime = obj.riskLevelDateTime

    return Object.seal(new Proxy(this, handler))
  }
}