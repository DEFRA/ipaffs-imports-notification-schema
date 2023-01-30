const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class Route {

  constructor(obj = {}) {

    this.transitingStates = _.get(obj, 'transitingStates', [])
    return Object.seal(new Proxy(this, handler))
  }
}