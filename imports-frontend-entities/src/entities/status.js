module.exports = class Status {
  constructor() {
    return Object.freeze({
      DRAFT: 'Draft',
      SUBMITTED: 'New',
      AMEND: 'Amend',
      MODIFY: 'Modify',
      IN_PROGRESS: 'In Progress',
      VALIDATED: 'Valid',
      REJECTED: 'Rejected',
      CANCELLED: 'Cancelled',
      REPLACED: 'Replaced',
      PARTIALLY_REJECTED: 'Partially Rejected',
      SPLIT_CONSIGNMENT: 'Split Consignment',
      TO_PROCESS: 'To Process'
    })
  }
}