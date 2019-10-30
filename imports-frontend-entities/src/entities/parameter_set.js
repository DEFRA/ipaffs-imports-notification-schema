const _ = require('lodash')

const handler = require('./base/handler')
const KeyDataPair = require('./key_data_pair')
const Identifiers = require('./identifiers')
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

    return Object.seal(new Proxy(this, handler))
  }
}