const handler = require('./base/handler')

module.exports = class OfficialVeterinarian {

  constructor(obj = {}) {

    this.firstName = obj.firstName
    this.lastName = obj.lastName
    this.email = obj.email
    this.phone = obj.phone
    this.fax = obj.fax
    this.signed = obj.signed

    return Object.seal(new Proxy(this, handler))
  }
}
