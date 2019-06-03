const handler = require('./base/handler')

module.exports = class Error {

  constructor(joiErrorObj) {

    if (!joiErrorObj) {
      joiErrorObj = {}
    }

    this.description = joiErrorObj.message,
    this.path = joiErrorObj.path,
    this.field = joiErrorObj.path

    return Object.seal(new Proxy(this, handler))
  }
}
