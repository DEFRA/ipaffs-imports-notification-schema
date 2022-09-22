const _ = require('lodash')

const handler = require('./base/handler')
const {getList} = require('../utils/list')

const CommodityRiskResult = require('./commodity_risk_result')

module.exports = class RiskAssessment {
  constructor(obj = {}) {

    this.commodityResults = getList(_.get(obj, 'commodityResults', []), CommodityRiskResult)
    this.assessmentDateTime = obj.assessmentDateTime

    return Object.seal(new Proxy(this, handler))
  }
}