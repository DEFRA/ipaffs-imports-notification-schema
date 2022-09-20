const _ = require('lodash')
const handler = require('./base/handler')
const SingleLaboratoryTests = require('./singlelaboratory_tests')

module.exports = class LaboratoryTests {

  constructor(obj = {}) {

    this.testDate = obj.testDate
    this.testReason = obj.testReason
    this.singleLaboratoryTests = _.get(obj, 'singleLaboratoryTests')
        ? getSingleLaboratoryTests(
            _.get(obj, 'singleLaboratoryTests')) : undefined
    return Object.seal(new Proxy(this, handler))
  }
}

const getSingleLaboratoryTests = (inList) => {

  const singleLaboratoryTests = []
  _.forEach(inList, singleLaboratoryTest => {
    singleLaboratoryTests.push(new SingleLaboratoryTests(singleLaboratoryTest))
  })
  return singleLaboratoryTests
}