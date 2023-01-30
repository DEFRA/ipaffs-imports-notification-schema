const handler = require('./base/handler')

module.exports = class ConsignmentCheck {

  constructor(obj = {}) {

    this.euStandard = obj.euStandard
    this.documentCheckResult = obj.documentCheckResult
    this.additionalGuarantees = obj.additionalGuarantees
    this.nationalRequirements = obj.nationalRequirements
    this.identityCheckDone = obj.identityCheckDone
    this.identityCheckType = obj.identityCheckType
    this.identityCheckResult = obj.identityCheckResult
    this.physicalCheckDone = obj.physicalCheckDone
    this.physicalCheckResult = obj.physicalCheckResult
    this.physicalCheckNotDoneReason = obj.physicalCheckNotDoneReason
    this.physicalCheckOtherText = obj.physicalCheckOtherText
    this.welfareCheck = obj.welfareCheck
    this.numberOfAnimalsChecked = obj.numberOfAnimalsChecked
    this.laboratoryCheckDone = obj.laboratoryCheckDone
    this.laboratoryCheckResult = obj.laboratoryCheckResult
    this.identityCheckNotDoneReason = obj.identityCheckNotDoneReason

    return Object.seal(new Proxy(this, handler))
  }
}