const handler = require('./base/handler')

module.exports = class NotificationEventData {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.NotificationEventDataKey = obj.NotificationEventDataKey
    this.data = obj.data

    return Object.seal(new Proxy(this, handler))
  }
}