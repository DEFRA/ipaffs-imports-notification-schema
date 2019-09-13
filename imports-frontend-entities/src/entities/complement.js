const handler = require('./base/handler')

module.exports = class CommodityComplement {
  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.commodityDescription = obj.commodityDescription
    this.commodityID = obj.commodityID
    this.complementID = obj.complementID
    this.speciesID = obj.speciesID
    this.speciesName = obj.speciesName
    this.speciesTypeName = obj.speciesTypeName
    this.speciesType = obj.speciesType
    this.speciesClassName = obj.speciesClassName
    this.speciesClass = obj.speciesClass
    this.speciesFamilyName = obj.speciesFamilyName
    this.speciesFamily = obj.speciesFamily
    this.speciesNomination = obj.speciesNomination

    return Object.seal(new Proxy(this, handler))
  }
}