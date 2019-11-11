const _ = require('lodash')
const handler = require('./base/handler')
const UserInfo = require('./user_info')

module.exports = class User {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.accessToken = obj.accessToken
    this.roles = _.get(obj, 'roles', [])
    this.conversationId = obj.conversationId
    this.conversationIp = obj.conversationIp
    this.landingPage = obj.landingPage
    this.userInfo = _.get(obj, 'userInfo') ? new UserInfo(obj.userInfo)
        : undefined

    return Object.seal(new Proxy(this, handler))
  }
}
