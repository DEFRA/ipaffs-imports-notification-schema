//@ts-check
const Type = require('./type')

module.exports = {
  get(target, name) {
    if (String(name) in target) {
      return target[name]
    }

    if (String(name) === 'getType') {
      return () => Type.getType(target)
    }

    return undefined
  },
  set(target, name, value) {
    if (String(name) in target) {
      target[name] = value
    }
  }
}
