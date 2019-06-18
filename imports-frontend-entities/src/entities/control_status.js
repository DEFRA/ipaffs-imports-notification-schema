module.exports = class ControlStatus {
  constructor() {
    return Object.freeze({
      REQUIRED: 'Required',
      COMPLETED: 'Complete'
    })
  }
}