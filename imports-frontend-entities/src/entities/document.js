const handler = require('./base/handler')

module.exports = class Document {
  constructor(obj = {}) {

    this.dateOfIssue = obj.dateOfIssue
    this.documentNumber = obj.documentNumber

    return Object.seal(new Proxy(this, handler))
  }
}