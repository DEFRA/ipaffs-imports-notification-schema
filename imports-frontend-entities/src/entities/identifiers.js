const _ = require('lodash')

const handler = require('./base/handler')

module.exports = class Identifiers {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.speciesNumber = obj.speciesNumber
    this.data = _.get(obj, 'data', {})

    return Object.seal(new Proxy(this, handler))
  }
}


