const _ = require('lodash')

module.exports = class Type {
  static getType(obj) {
    if (!obj || _.isNil(obj)) {
      return new Type({
        name: 'void',
        memberFields: [],
        isPrimitive: true
      })
    }

    let input = {
      name: typeof obj,
      memberFields: [],
      isPrimitive: true
    }

    if (_.isObject(obj)) {
      input.name = obj.constructor.name
      input.isPrimitive = false
    }

    const allKeys = Object.keys(obj)
    for (let key of allKeys) {
      if (isNaN(+key) && typeof obj[key] !== 'function') {
        input.memberFields.push(key)
      }
    }

    return new Type(input)
  }

  constructor(obj) {
    this.name = obj.name
    this.memberFields = obj.memberFields
    this.isPrimitive = obj.isPrimitive

    return new Proxy(this, Object.create({
      get(target, name) {
        if (String(name) in target) {
          return target[name]
        }
      },
      set(target, name, value) {
        throw new Error('Type is immutable.')
      }
    }))
  }

  isEmpty() {
    return this.name === 'void'
        && this.memberFields.length !== undefined
        && this.memberFields.length === 0
        && this.isPrimitive === true
  }
}
