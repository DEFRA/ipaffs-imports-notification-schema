const _ = require('lodash')

const handler = require('./base/handler')
const KeyDataPair = require('./key_data_pair')
const Identifiers = require('./identifiers')
const CatchCertificate = require('./catch_certificate')
const {getList} = require('../utils/list')

module.exports = class ComplementParameterSet {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.complementID = obj.complementID
    this.speciesID = obj.speciesID
    this.keyDataPair = getList(
      _.get(obj, 'keyDataPair', []), KeyDataPair)
    this.identifiers = getList(
      _.get(obj, 'identifiers', []), Identifiers)
    this.catchCertificates = getList(
        _.get(obj, 'catchCertificate', []), CatchCertificate)

    return Object.seal(new Proxy(this, handler))
  }
}