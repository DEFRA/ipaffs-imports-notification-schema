const _ = require('lodash')
const Ajv = require('ajv')

const notificationJsonSchema = require('../../etc/notification-schema.json')
const PartOne = require('./part_one')
const PartTwo = require('./part_two')
const PartThree = require('./part_three')
const Document = require('./document')
const ConsignmentValidation = require('./consignment_validation')

module.exports = class Notification {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    validate(obj)

    this.id = obj.id
    this.etag = obj.etag
    this.referenceNumber = obj.referenceNumber
    this.version = obj.version
    this.lastUpdated = obj.lastUpdated
    this.type = obj.type
    this.status = obj.status
    this.partOne = _.get(obj, 'partOne') ? new PartOne(obj.partOne) : undefined
    this.partTwo = _.get(obj, 'partTwo') ? new PartTwo(obj.partTwo) : undefined
    this.partThree = _.get(obj, 'partThree') ? new PartThree(obj.partThree)
        : undefined
    this.decisionBy = obj.decisionBy
    this.decisionDate = obj.decisionDate
    this.documents = getDocuments(_.get(obj, 'documents', []))
    this.consignmentValidation = getConsignmentValidation(
        _.get(obj, 'consignmentValidation', []))
    this.replaces = obj.replaces
    this.replacedBy = obj.replacedBy
    this.lastUpdatedBy = obj.lastUpdatedBy

    validate(this)

    return Object.seal(new Proxy(this, {
      get(target, name) {
        if (String(name).split('').every(c => +c < 10)) {
          return target._items[+name]
        }

        return target[name]
      },
      set(target, name, value) {
        if (String(name).split('').every(c => +c < 10)) {
          target._items[+name] = value
        } else {
          target[name] = value
        }
      }
    }))

  }
}

const validate = obj => {

  let validate = new Ajv().compile(notificationJsonSchema)
  if (!validate(obj)) {
    throw Error('Notification constructor: ' + JSON.stringify(validate.errors))
  }
}

const getDocuments = inList => {

  const documentList = []
  _.forEach(inList, document => {
    documentList.push(new Document(document))
  })

  return documentList
}

const getConsignmentValidation = inList => {

  const consignmentValidationList = []
  _.forEach(inList, consignmentValidation => {
    consignmentValidationList.push(
        new ConsignmentValidation(consignmentValidation))
  })

  return consignmentValidationList
}