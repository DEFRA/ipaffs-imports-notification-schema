const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class ApprovedEstablishment {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }
    this.name = obj.name
    this.country = obj.country
    this.approvalNumber = obj.approvalNumber
    this.types = _.get(obj, 'types', [])
    this.section = obj.section
    return Object.seal(new Proxy(this, handler))
  }
}