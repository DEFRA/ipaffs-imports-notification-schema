const _ = require('lodash')

const InspectionCheck = require('./inspection_check')
const handler = require('./base/handler')
const { getList } = require('../utils/list')

module.exports = class CommodityChecks {

  constructor(obj) {
    if (!obj) {
      obj = {}
    }

    this.uniqueComplementId = obj.uniqueComplementId
    this.checks = getList(_.get(obj, 'checks', []), InspectionCheck)

    return Object.seal(new Proxy(this, handler))
  }
}