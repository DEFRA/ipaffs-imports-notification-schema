const handler = require('./base/handler')

module.exports = class NotificationSealsContainers {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.sealNumber = obj.sealNumber
    this.containerNumber = obj.containerNumber

    return Object.seal(new Proxy(this, handler))
  }
}
