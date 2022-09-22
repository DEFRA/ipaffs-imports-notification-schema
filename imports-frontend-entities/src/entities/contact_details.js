const handler = require('./base/handler')

module.exports = class ContactDetails {
  constructor(obj = {}) {

    this.name = obj.name
    this.telephone = obj.telephone
    this.email = obj.email
    this.agent = obj.agent

    return Object.seal(new Proxy(this, handler))
  }
}
