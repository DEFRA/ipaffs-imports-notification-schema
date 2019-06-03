const handler = require('./base/handler')

module.exports = class Purpose {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.conformsToEU = obj.conformsToEU
    this.internalMarketPurpose = obj.internalMarketPurpose
    this.thirdCountryTranshipment = obj.thirdCountryTranshipment
    this.forNonConforming = obj.forNonConforming
    this.regNumber = obj.regNumber
    this.shipName = obj.shipName
    this.shipPort = obj.shipPort
    this.exitBIP = obj.exitBIP
    this.thirdCountry = obj.thirdCountry
    this.transitThirdCountries = obj.transitThirdCountries // Array
    this.forImportOrAdmission = obj.forImportOrAdmission
    this.exitDate = obj.exitDate
    this.finalBIP = obj.finalBIP
    this.purposeGroup = obj.purposeGroup

    return Object.seal(new Proxy(this, handler))
  }
}