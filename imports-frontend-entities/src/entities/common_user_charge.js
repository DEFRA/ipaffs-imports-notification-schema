const handler = require('./base/handler')
module.exports = class CommonUserCharge {

  constructor(obj = {}) {

    this.wasSentToTradeCharge = obj.wasSentToTradeCharge

    return Object.seal(new Proxy(this, handler))
  }
}