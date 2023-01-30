const handler = require('./base/handler')

module.exports = class NotificationSealsContainers {
  constructor(obj = {}) {

    this.sealNumber = obj.sealNumber
    this.containerNumber = obj.containerNumber
    this.officialSeal = obj.officialSeal
    this.resealedSealNumber = obj.resealedSealNumber

    return Object.seal(new Proxy(this, handler))
  }
}