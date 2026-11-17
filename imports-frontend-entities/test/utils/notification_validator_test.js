const chai = require('chai')

const {notificationValidator} = require('../../src/utils/notification_validator')

describe('notification validator', () => {
  it('should validate an empty object correctly', () => {

    const errors = notificationValidator.validate({})
    chai.expect(errors.length).to.equal(0)
  })

  it('should find errors in an invalid object', () => {

    const invalidNotification = {
      key: 'text'
    }

    const errors = notificationValidator.validate(invalidNotification)
    chai.expect(errors.length).to.equal(1)
  })

  it('should not find errors in a valid object', () => {

    const validNotification = {
      referenceNumber: 'CHEDP.GB.2020.1985327'
    }

    const errors = notificationValidator.validate(validNotification)
    chai.expect(errors.length).to.equal(0)
  })

  it('should accept a valid date format', () => {

    const notification = {
      partOne: { portOfExitDate: '2026-01-31' }
    }

    const errors = notificationValidator.validate(notification)
    chai.expect(errors.length).to.equal(0)
  })

  it('should reject a date that does not match the date format', () => {

    const notification = {
      partOne: { portOfExitDate: '31/01/2026' }
    }

    const errors = notificationValidator.validate(notification)
    chai.expect(errors.length).to.equal(1)
    chai.expect(errors[0].keyword).to.equal('format')
    chai.expect(errors[0].instancePath).to.equal('/partOne/portOfExitDate')
  })

  it('should accept a valid economic operator id', () => {

    const notification = {
      partOne: { consignor: { id: '3f2b8c1e-9a4d-4e7f-8b6a-1c2d3e4f5a6b' } }
    }

    const errors = notificationValidator.validate(notification)
    chai.expect(errors.length).to.equal(0)
  })

  it('should reject an invalid economic operator id', () => {

    const notification = {
      partOne: { consignor: { id: '[' } }
    }

    const errors = notificationValidator.validate(notification)
    chai.expect(errors.length).to.equal(1)
  })
})
