const _ = require('lodash')
const handler = require('./base/handler')
const Transporter = require('./transporter')

module.exports = class Transport {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.transporter = new Transporter(
        _.get(obj, 'transporter', new Transporter()))
    this.transporterName = obj.transporterName
    this.deliveryAddress = obj.deliveryAddress
    this.country = obj.country
    this.arrivalDate = obj.arrivalDate
    this.arrivalTime = obj.arrivalTime
    this.transportMethod = obj.transportMethod
    this.sealNumber = obj.sealNumber
    this.containerNumber = obj.containerNumber
    this.importPurpose = obj.importPurpose

    return Object.seal(new Proxy(this, handler))
  }
}