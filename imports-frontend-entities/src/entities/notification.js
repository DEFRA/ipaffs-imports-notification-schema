const _ = require('lodash')

const { getList } = require('../utils/list')
const handler = require('./base/handler')
const { notificationValidator } = require('../utils/notification_validator')
const PartOne = require('./part_one')
const PartTwo = require('./part_two')
const PartThree = require('./part_three')
const ConsignmentValidation = require('./consignment_validation')
const ExternalReference = require('./external_reference')
const SplitConsignment = require('./split_consignment')
const RiskAssessment = require('./risk_assessment')
const JourneyRiskCategorisation = require('./journey_risk_categorisation.js')

module.exports = class Notification {
  constructor(obj = {}) {

    validate(obj)

    this.id = obj.id
    this.etag = obj.etag
    this.referenceNumber = obj.referenceNumber
    this.externalReferences = getList(_.get(obj, 'externalReferences', []), ExternalReference)
    this.version = obj.version
    this.lastUpdated = obj.lastUpdated
    this.type = obj.type
    this.status = obj.status
    this.splitConsignment = obj.splitConsignment ? new SplitConsignment(obj.splitConsignment) : undefined
    this.childNotification = obj.childNotification
    this.isHighRiskEuImport = obj.isHighRiskEuImport
    this.partOne = _.get(obj, 'partOne') ? new PartOne(obj.partOne) : undefined
    this.partTwo = _.get(obj, 'partTwo') ? new PartTwo(obj.partTwo) : undefined
    this.partThree = _.get(obj, 'partThree') ? new PartThree(obj.partThree)
        : undefined
    this.decisionBy = obj.decisionBy
    this.decisionDate = obj.decisionDate
    this.consignmentValidation = getConsignmentValidation(_.get(obj, 'consignmentValidation', []))
    this.riskAssessment = obj.riskAssessment ? new RiskAssessment(obj.riskAssessment) : undefined
    this.journeyRiskCategorisation = obj.journeyRiskCategorisation ? new JourneyRiskCategorisation(obj.journeyRiskCategorisation) : undefined
    this.replaces = obj.replaces
    this.replacedBy = obj.replacedBy
    this.lastUpdatedBy = obj.lastUpdatedBy
    this.agencyOrganisationId = obj.agencyOrganisationId
    this.riskDecisionLockingTime = obj.riskDecisionLockingTime;
    this.isRiskDecisionLocked = obj.isRiskDecisionLocked;
    this.isBulkUploadInProgress = obj.isBulkUploadInProgress;
    this.requestId = obj.requestId;
    this.isCdsFullMatched = obj.isCdsFullMatched;

    validate(this)

    return Object.seal(new Proxy(this, handler))
  }
}

const validate = obj => {

  const errors = notificationValidator.validate(obj)
  if (errors.length > 0) {
    throw new Error('Notification constructor: ' + JSON.stringify(errors))
  }
}

const getConsignmentValidation = inList => {

  const consignmentValidationList = []
  _.forEach(inList, consignmentValidation => {
    consignmentValidationList.push(
        new ConsignmentValidation(consignmentValidation))
  })

  return consignmentValidationList
}
