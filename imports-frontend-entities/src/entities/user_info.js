const handler = require('./base/handler')

module.exports = class UserInfo {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.displayName = obj.displayName
    this.firstName = obj.firstName
    this.lastName = obj.lastName
    this.name = obj.name
    this.uniqueName = obj.uniqueName
    this.id = obj.id
    this.address = obj.address
    this.county = obj.county
    this.postCode = obj.postCode
    this.country = obj.country
    this.city = obj.city
    this.email = obj.email
    this.phone = obj.phone
    this.fax = obj.fax
    this.companyId = obj.companyId
    this.tokenType = obj.tokenType
    this.companyDisplayName = obj.companyDisplayName
    this.tracesUnitNumber = obj.tracesUnitNumber
    this.organisations = obj.organisations

    return Object.seal(new Proxy(this, handler))
  }
}