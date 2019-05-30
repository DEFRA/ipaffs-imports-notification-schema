const chai = require('chai')

const handler = require('../base/handler')

describe('Entities handler tests', () => {
  let encapsulatedObject;
  beforeEach(() => {
    encapsulatedObject = {
      fieldOne: 0
    }
  })

  it('should prevent adding new property to entity', () => {
    handler.set(encapsulatedObject, 'fieldTwo', 1)

    chai.assert.isFalse('fieldTwo' in encapsulatedObject)
    chai.assert.isUndefined(handler.get(encapsulatedObject, 'fieldTwo'))
  })

  it('should allow setting existing properties values', () => {
    handler.set(encapsulatedObject, 'fieldOne', 1)

    chai.assert.equal(handler.get(encapsulatedObject, 'fieldOne'), 1)
  })
})