const _ = require('lodash')
const handler = require('./base/handler')
const DetailsOnReExport = require('./details_on_reexport')
const FeedbackInformation = require('./feedback_information')
const OfficialInspector = require('./official_inspector')

module.exports = class Control {

  constructor(obj = {}) {

    this.consignmentLeave = _.get(obj, 'consignmentLeave')
    this.detailsOnReExport = _.get(obj, 'detailsOnReExport')
        ? new DetailsOnReExport(obj.detailsOnReExport) : undefined
    this.feedbackInformation = _.get(obj, 'feedbackInformation')
        ? new FeedbackInformation(obj.feedbackInformation) : undefined
    this.officialInspector = _.get(obj, 'officialInspector')
        ? new OfficialInspector(obj.officialInspector) : undefined

    return Object.seal(new Proxy(this, handler))
  }
}