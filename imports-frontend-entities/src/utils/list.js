const _ = require('lodash')

const getList = (inList, type) => {
  return _.map(inList, item => new type(item))
}

module.exports = {
  getList
}