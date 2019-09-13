const _ = require('lodash')

const handler = require('./base/handler')
const CommodityComplement = require('./complement')

module.exports = class Commodities {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.totalGrossWeight = obj.totalGrossWeight
    this.totalNetWeight = obj.totalNetWeight
    this.numberOfPackages = obj.numberOfPackages
    this.temperature = obj.temperature
    this.numberOfAnimals = obj.numberOfAnimals
    this.commodityComplement = getComplements(
        _.get(obj, 'commodityComplement', []))
    this.complementParameterSet = _.get(obj, 'complementParameterSet', [])
    this.includeNonAblactedAnimals = obj.includeNonAblactedAnimals
    this.countryOfOrigin = obj.countryOfOrigin
    this.regionOfOrigin = obj.regionOfOrigin
    this.consignedCountry = obj.consignedCountry
    this.animalsCertifiedAs = obj.animalsCertifiedAs
    this.commodityIntendedFor = obj.commodityIntendedFor

    return Object.seal(new Proxy(this, handler))
  }

}

const getComplements = inList => {
  const complementList = []
  _.forEach(inList, function (complement) {
    complementList.push(new CommodityComplement(complement))
  })

  return complementList
}