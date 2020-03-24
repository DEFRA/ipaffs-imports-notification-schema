const _ = require('lodash')

const handler = require('./base/handler')

module.exports = class CatchCertificate {
    constructor(obj) {

        if (!obj) {
            obj = {}
        }

        this.certificateNumber = obj.certificateNumber
        this.weight = obj.weight

        return Object.seal(new Proxy(this, handler))
    }
}

