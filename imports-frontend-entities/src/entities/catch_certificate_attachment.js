const handler = require('./base/handler')
const CatchCertificateDetails = require('./catch_certificate_details')
const {getList} = require("../utils/list");

module.exports = class CatchCertificateAttachment {
    constructor(obj = {}) {

        this.attachmentId = obj.attachmentId
        this.catchCertificateDetails = getList(obj.catchCertificateDetails ?? [], CatchCertificateDetails)
        this.numberOfCatchCertificates = obj.numberOfCatchCertificates

        return Object.seal(new Proxy(this, handler))
    }
}