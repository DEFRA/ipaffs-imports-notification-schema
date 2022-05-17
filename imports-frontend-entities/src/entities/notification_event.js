const _ = require('lodash')

const handler = require('./base/handler')
const {getList} = require('../utils/list')

const NotificationEventData = require('./notification_event_data')

module.exports = class NotificationEvent {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.eventType = obj.eventType
    this.createdAt = obj.createdAt
    this.data = getList(_.get(obj, 'NotificationEventData', []), NotificationEventData)

    return Object.seal(new Proxy(this, handler))
  }
}