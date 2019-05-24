const handler = require('./base/handler')

module.exports = class keyDataPair {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.key = obj.key
    this.data = obj.data

    return Object.seal(new Proxy(this, handler))
  }
}


