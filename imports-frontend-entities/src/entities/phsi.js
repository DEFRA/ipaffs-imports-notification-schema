const handler = require('./base/handler')

module.exports = class Phsi {
  constructor(obj = {}) {

    this.documentCheck = obj.documentCheck
    this.identityCheck = obj.identityCheck
    this.physicalCheck = obj.physicalCheck

    return Object.seal(new Proxy(this, handler))
  }
}