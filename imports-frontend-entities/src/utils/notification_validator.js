const Ajv = require('ajv')
const notificationJsonSchema = require('../../etc/notification-schema.json')
const schemaDef = require('../../etc/schema-definition.json')

class NotificationValidator {
  constructor() {
    this.validator = new Ajv().addMetaSchema(schemaDef).compile(notificationJsonSchema)
  }

  validate(notification) {
    this.validator(notification)
    return this.validator.errors === null ? [] : this.validator.errors
  }
}

const notificationValidator = new NotificationValidator();
Object.freeze(notificationValidator);

module.exports = {
  notificationValidator
}
