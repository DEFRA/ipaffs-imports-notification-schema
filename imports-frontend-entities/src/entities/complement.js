const handler = require('./base/handler')

module.exports = class CommodityComplement {
  constructor(obj = {}) {

    this.uniqueComplementID = obj.uniqueComplementID
    this.commodityDescription = obj.commodityDescription
    this.commodityID = obj.commodityID
    this.complementID = obj.complementID
    this.complementName = obj.complementName
    this.eppoCode = obj.eppoCode
    this.speciesID = obj.speciesID
    this.speciesName = obj.speciesName
    this.speciesTypeName = obj.speciesTypeName
    this.speciesType = obj.speciesType
    this.speciesClassName = obj.speciesClassName
    this.speciesClass = obj.speciesClass
    this.speciesFamilyName = obj.speciesFamilyName
    this.speciesFamily = obj.speciesFamily
    this.speciesNomination = obj.speciesNomination
    this.speciesCommonName = obj.speciesCommonName
    this.isCdsMatched = obj.isCdsMatched

    return Object.seal(new Proxy(this, handler))
  }
}