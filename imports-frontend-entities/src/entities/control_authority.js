const _ = require('lodash')
const handler = require('./base/handler')
const OfficialVeterinarian = require('./official_veterinarian')

module.exports = class ControlAuthority {

  constructor(obj = {}) {

    this.controlAuthority = obj.controlAuthority
    this.officialVeterinarian = _.get(obj, 'officialVeterinarian')
        ? new OfficialVeterinarian(obj.officialVeterinarian) : undefined
    this.customsReferenceNo = obj.customsReferenceNo
    this.containerResealed = obj.containerResealed
    this.newSealNumber = obj.newSealNumber
    this.iuuFishingReference = obj.iuuFishingReference
    this.iuuCheckRequired = obj.iuuCheckRequired
    this.iuuOption = obj.iuuOption

    return Object.seal(new Proxy(this, handler))
  }
}
