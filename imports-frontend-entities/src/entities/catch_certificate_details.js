const _ = require("lodash");
const handler = require("./base/handler");

module.exports = class CatchCertificateAttachment {
    constructor(obj = {}) {

        this.catchCertificateId = obj.catchCertificateId
        this.catchCertificateReference = obj.catchCertificateReference
        this.dateofIssue = obj.dateofIssue
        this.flagState = obj.flagState
        this.species = _.get(obj, 'species', [])

        return Object.seal(new Proxy(this, handler))
    }
}