const handler = require('./base/handler')

module.exports = class Commodity {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.commodityID = obj.commodityID
    this.commodityName = obj.commodityName
    this.numberOfPackages = obj.numberOfPackages
    this.numberOfAnimals = obj.numberOfAnimals
    this.typeOfPackages = obj.typeOfPackages
    this.temperature = obj.temperature
    this.invasiveAlienSpecies = obj.invasiveAlienSpecies
    this.allowed = obj.allowed
    this.netWeight = obj.netWeight
    this.grossWeight = obj.grossWeight
    this.countryOfOrigin = obj.countryOfOrigin
    this.regionOfOrigin = obj.regionOfOrigin
    this.consignedCountry = obj.consignedCountry
    this.animalCertification = obj.animalCertification

    return Object.seal(new Proxy(this, handler))
  }
}
