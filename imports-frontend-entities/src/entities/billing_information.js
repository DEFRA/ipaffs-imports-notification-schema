const handler = require('./base/handler')
const PostalAddress = require('./postal_address')

module.exports = class BillingInformation {

  constructor(obj = {}) {

    this.isConfirmed = obj.isConfirmed
    this.emailAddress = obj.emailAddress
    this.phoneNumber = obj.phoneNumber
    this.contactName = obj.contactName
    this.postalAddress = obj.postalAddress ? new PostalAddress(obj.postalAddress) : undefined

    return Object.seal(new Proxy(this, handler))
  }
}