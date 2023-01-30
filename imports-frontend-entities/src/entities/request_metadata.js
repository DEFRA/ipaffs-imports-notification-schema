const _ = require('lodash')
const handler = require('./base/handler')
const User = require('./user')

module.exports = class RequestMetadata {
  constructor(obj = {}) {

    this.loggedInUser = _.get(obj, 'loggedInUser') ? new User(obj.loggedInUser)
        : undefined

    this.loggedInUserUsername = _.get(obj, 'loggedInUser.userInfo.displayName',
        '')
    this.conversationId = _.get(obj, 'loggedInUser.conversationId', '')
    this.conversationIp = _.get(obj, 'loggedInUser.conversationIp', '')

    return Object.seal(new Proxy(this, handler))
  }
}
