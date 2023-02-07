const _ = require('lodash')
const handler = require('./base/handler')

class Inspector {
  constructor(obj = {}) {

    this.name = obj.name
    this.phone = obj.phone
    this.email = obj.email
  }
}

module.exports = class Applicant {

  constructor(obj = {}) {

    this.laboratory = obj.laboratory
    this.analysisType = obj.analysisType
    this.laboratoryAddress = obj.laboratoryAddress
    this.laboratoryIdentification = obj.laboratoryIdentification
    this.laboratoryEmail = obj.laboratoryEmail
    this.laboratoryPhoneNumber = obj.laboratoryPhoneNumber
    this.sampleBatchNumber = obj.sampleBatchNumber
    this.numberOfSamples = obj.numberOfSamples
    this.sampleType = obj.sampleType
    this.conservationOfSample = obj.conservationOfSample
    this.inspector = _.get(obj, 'inspector') ? new Inspector(obj.inspector)
        : undefined
    this.sampleDate = obj.sampleDate
    this.sampleTime = obj.sampleTime
    return Object.seal(new Proxy(this, handler))
  }
}