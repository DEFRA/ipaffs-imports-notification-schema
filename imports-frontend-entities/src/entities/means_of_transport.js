const handler = require('./base/handler')

module.exports = class MeansOfTransport {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.type = obj.type
    this.document = obj.document
    this.id = obj.id

    return Object.seal(new Proxy(this, handler))
  }
}