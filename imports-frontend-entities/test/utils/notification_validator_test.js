const chai = require('chai')

const {notificationValidator} = require.main.require('src/utils/notification_validator')

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
})
