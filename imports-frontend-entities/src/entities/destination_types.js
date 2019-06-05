module.exports = class DestinationTypes {
  constructor() {
    return Object.freeze({
      BALAI: 'Balai',
      QUARANTINE: 'Quarantine',
      BIRD_QUARANTINE: 'Bird Quarantine',
      ABP: 'ABP',
      OTHER_CONTROLLED_DESTINATION: 'Other Controlled Destination'
    })
  }
}