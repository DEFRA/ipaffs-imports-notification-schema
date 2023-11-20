const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class AccompanyingDocument {
  constructor(obj = {}) {

    this.documentType = obj.documentType
    this.documentReference = obj.documentReference
    this.documentIssueDate = obj.documentIssueDate
    this.attachmentId = obj.attachmentId
    this.attachmentFilename = obj.attachmentFilename
    this.attachmentContentType = obj.attachmentContentType
    this.uploadUserId = obj.uploadUserId
    this.uploadOrganisationId = obj.uploadOrganisationId
    this.externalReference = obj.externalReference
    this.flagState = obj.flagState

    return Object.seal(new Proxy(this, handler))
  }
}
