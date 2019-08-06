const handler = require('./base/handler')

module.exports = class LaboratoryTestResult {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.sampleUseByDate = obj.sampleUseByDate
    this.releasedDate = obj.releasedDate
    this.laboratoryTestMethod = obj.laboratoryTestMethod
    this.results = obj.results
    this.conclusion = obj.conclusion
    this.labTestCreatedDate = obj.labTestCreatedDate

    return Object.seal(new Proxy(this, handler))
  }
}