const handler = require('./base/handler')

module.exports = class NominatedContact {
  constructor(obj = {}) {

    this.name = obj.name
    this.email = obj.email
    this.telephone = obj.telephone

    return Object.seal(new Proxy(this, handler))
  }
}
