const _ = require('lodash')
const handler = require('./base/handler')
const ApprovedEstablishment = require('./approved_establishment')
const IdentificationDetail = require('./identification_detail')

module.exports = class VeterinaryInformation {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.establishmentsOfOrigin = _.get(obj, 'establishmentsOfOrigin', []).map(
        x => new ApprovedEstablishment(x))
    this.veterinaryDocument = obj.veterinaryDocument
    this.veterinaryDocumentIssueDate = obj.veterinaryDocumentIssueDate
    this.accompanyingDocumentNumbers = _.get(obj, 'accompanyingDocumentNumbers',
        [])
    this.identificationDetails = getIdentificationDetails(
        _.get(obj, 'identificationDetails', []))

    return Object.seal(new Proxy(this, handler))
  }
}

const getIdentificationDetails = inList => {
  const identificationDetailsList = []
  _.forEach(inList, identificationDetail => {
    identificationDetailsList.push(
        new IdentificationDetail(identificationDetail))
  })
  return identificationDetailsList
}
