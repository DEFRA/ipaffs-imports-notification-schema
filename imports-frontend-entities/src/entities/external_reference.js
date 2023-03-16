const _ = require('lodash')

const handler = require('./base/handler')

module.exports = class ExternalReference {
  constructor(obj = {}) {

    this.system = obj.system
    this.reference = obj.reference
    this.exactMatch = obj.exactMatch
    this.verifiedByImporter = obj.verifiedByImporter
    this.verifiedByInspector = obj.verifiedByInspector

    return Object.seal(new Proxy(this, handler))
  }
}


