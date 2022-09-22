const _ = require('lodash')

const InspectionCheck = require('./inspection_check')
const handler = require('./base/handler')
const { getList } = require('../utils/list')

module.exports = class CommodityChecks {

  constructor(obj = {}) {

    this.uniqueComplementId = obj.uniqueComplementId
    this.checks = getList(_.get(obj, 'checks', []), InspectionCheck)
    this.validityPeriod = obj.validityPeriod

    return Object.seal(new Proxy(this, handler))
  }
}