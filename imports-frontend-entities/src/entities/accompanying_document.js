const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class AccompanyingDocument {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.documentType = obj.documentType
    this.documentReference = obj.documentReference
    this.documentIssueDate = obj.documentIssueDate

    return Object.seal(new Proxy(this, handler))
  }
}