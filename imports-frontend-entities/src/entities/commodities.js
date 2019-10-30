const _ = require('lodash')

const handler = require('./base/handler')
const CommodityComplement = require('./complement')
const ComplementParameterSet = require('./parameter_set')
const {getList} = require('../utils/list')

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
    this.commodityComplement = getList(
        _.get(obj, 'commodityComplement', []), CommodityComplement)
    this.complementParameterSet = getList(
      _.get(obj, 'complementParameterSet', []), ComplementParameterSet)
    this.includeNonAblactedAnimals = obj.includeNonAblactedAnimals
    this.countryOfOrigin = obj.countryOfOrigin
    this.regionOfOrigin = obj.regionOfOrigin
    this.consignedCountry = obj.consignedCountry
    this.animalsCertifiedAs = obj.animalsCertifiedAs
    this.commodityIntendedFor = obj.commodityIntendedFor

    return Object.seal(new Proxy(this, handler))
  }
}