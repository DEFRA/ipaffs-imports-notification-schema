const _ = require('lodash')
const handler = require('./base/handler')
const TransferPoints = require('./transfer_points')

module.exports = class Route {

  constructor(obj) {

    if (!obj) {
      obj = {}
    }

    this.transitingStates = _.get(obj, 'transitingStates', [])
    this.transferPoints = getTransferPoints(_.get(obj, 'transferPoints', []))

    return Object.seal(new Proxy(this, handler))
  }
}

const getTransferPoints = (inList) => {

  const transferPointsList = []
  _.forEach(inList,
      function (transferPoint) {

        transferPointsList.push(new TransferPoints(transferPoint))
      }
  )

  return transferPointsList
}

