const _ = require('lodash')
const handler = require('./base/handler')

module.exports = class ImpactOfTransportOnAnimals {

  constructor(obj = {}) {

    this.commodityID = obj.commodityID

    this.numberOfDeadAnimals = _.get(obj, 'numberOfDeadAnimals')
        ? obj.numberOfDeadAnimals : 0
    this.numberOfDeadAnimalsUnit = obj.numberOfDeadAnimalsUnit
    this.numberOfUnfitAnimals = _.get(obj, 'numberOfUnfitAnimals')
        ? obj.numberOfUnfitAnimals : 0
    this.numberOfUnfitAnimalsUnit = obj.numberOfUnfitAnimalsUnit
    this.numberOfBirthOrAbortion = obj.numberOfBirthOrAbortion

    return Object.seal(new Proxy(this, handler))
  }
}
