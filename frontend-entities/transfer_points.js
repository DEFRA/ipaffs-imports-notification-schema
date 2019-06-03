const _ = require('lodash')
const handler = require('./base/handler')
const Party = require('./party')

module.exports = class TranserPoints {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.plannedControlOrTransferPoint = new Party(
        _.get(obj, 'plannedControlOrTransferPoint', new Party()))
    this.date = obj.date
    this.time = obj.time

    return Object.seal(new Proxy(this, handler))
  }
}