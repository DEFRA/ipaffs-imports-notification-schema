const _ = require('lodash')
const handler = require('./base/handler')
const Applicant = require('./applicant')
const LaboratoryTestResult = require('./laboratory_test_result')

module.exports = class SingleLaboratoryTests {

  constructor(obj = {}) {

    this.commodityCode = obj.commodityCode
    this.speciesID = obj.speciesID
    this.tracesID = obj.tracesID
    this.testName = obj.testName
    this.speciesName = obj.speciesName
    this.applicant = _.get(obj, 'applicant') ? new Applicant(obj.applicant)
        : undefined
    this.laboratoryTestResult = _.get(obj, 'laboratoryTestResult')
        ? new LaboratoryTestResult(obj.laboratoryTestResult) : undefined
    return Object.seal(new Proxy(this, handler))
  }
}