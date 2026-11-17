const Ajv = require('ajv')
const addFormats = require('ajv-formats')
const notificationJsonSchema = require('../../etc/notification-schema.json')
const schemaDef = require('../../etc/schema-definition.json')

class NotificationValidator {
  constructor() {
    // strict mode is off as the schema carries javaType for the Java generator
    const ajv = new Ajv({ strict: false })
    // fast mode matches the format checks ajv 6 ran by default
    addFormats(ajv, { mode: 'fast', formats: ['date', 'regex'] })
    this.validator = ajv.addMetaSchema(schemaDef).compile(notificationJsonSchema)
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
