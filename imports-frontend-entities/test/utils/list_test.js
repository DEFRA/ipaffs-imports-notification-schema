const chai = require('chai')

const KeyDataPair = require('../../src/entities/key_data_pair')
const {getList} = require('../../src/utils/list')

describe('list util - getList', () => {
  it('should add items to the list of the supplied type', () => {
    const keyDataPairs = [{
      key: 'key1',
      data: 'data1'
    }, {
      key: 'key2',
      data: 'data2'
    }]

    const listOfKeyDataPairs = getList(keyDataPairs, KeyDataPair)
    chai.expect(listOfKeyDataPairs).to.deep.equal(keyDataPairs)
    chai.expect(listOfKeyDataPairs[0]).to.be.an.instanceOf(KeyDataPair)
    chai.expect(listOfKeyDataPairs[1]).to.be.an.instanceOf(KeyDataPair)
    chai.expect(listOfKeyDataPairs[0].constructor.name).to.equal('keyDataPair')
    chai.expect(listOfKeyDataPairs[1].constructor.name).to.equal('keyDataPair')
  })
})