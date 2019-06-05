const handler = require('./base/handler')

module.exports = class ConsignmentValidation {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.field = obj.field
    this.message = obj.message
    this.code = obj.code

    return Object.seal(new Proxy(this, handler))
  }
}