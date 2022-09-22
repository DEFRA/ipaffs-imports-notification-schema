const _ = require('lodash')
const handler = require('./base/handler')
const Address = require('./address')

module.exports = class OfficialInspector {

  constructor(obj = {}) {

    this.firstName = obj.firstName
    this.lastName = obj.lastName
    this.email = obj.email
    this.phone = obj.phone
    this.fax = obj.fax
    this.address = new Address(_.get(obj, 'address', new Address()))
    this.signed = obj.signed

    return Object.seal(new Proxy(this, handler))
  }
}