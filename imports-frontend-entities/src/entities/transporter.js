const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class Transporter {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }
    this.id = obj.id
    this.contactId = obj.contactId
    this.companyId = obj.companyId
    this.name = obj.name
    this.companyName = obj.companyName
    this.address = _.get(obj, 'address', [])
    this.county = obj.county
    this.postCode = obj.postCode
    this.country = obj.country
    this.city = obj.city
    this.tracesID = obj.tracesID
    this.type = obj.type
    this.approvalNumber = obj.approvalNumber
    this.phone = obj.phone
    this.fax = obj.fax
    this.email = obj.email

    return Object.seal(new Proxy(this, handler))
  }
}

