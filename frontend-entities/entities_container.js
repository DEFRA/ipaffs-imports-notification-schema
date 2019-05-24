module.exports = class EntitiesContainer {
  constructor(obj) {
    if (obj) {
      if (typeof obj.length !== 'undefined') {
        this._items = []
        obj.forEach(i => this.push(i))
      } else {
        Object.assign(this, obj)
      }
    }

    if (typeof this._items === 'undefined') {
      this._items = []
    }

    Object.seal(this)

    return new Proxy(this, {
      get(target, name) {
        if (String(name).split('').every(c => +c < 10)) {
          return target._items[+name]
        }

        return target[name]
      },
      set(target, name, value) {
        if (String(name).split('').every(c => +c < 10)) {
          target._items[+name] = value
        } else {
          target[name] = value
        }
      }
    })
  }

  get length() {
    return this._items.length
  }

  find(predicate) {
    return this._items.find(predicate)
  }

  every(predicate) {
    return this._items.every(predicate)
  }

  forEach(predicate) {
    return this._items.forEach(predicate)
  }

  first() {
    return this._items[0]
  }

  last() {
    if (this._items.length >= 1) {
      return this._items[this._items.length - 1]
    }
    return undefined
  }

  push(commodity) {
    this._items.push(commodity)
  }
}