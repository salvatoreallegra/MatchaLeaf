import React from 'react'
import Btn from '../../Elements/Btn'

const UploadButton = ({ openModal }) => (
  <div
    style={{
      display: 'flex',
      justifyContent: 'flex-end',
      alignItems: 'cross-start',
      gridRowStart: '5',
      gridRowEnd: '5',
      gridColumnStart: '5',
      gridColumnEnd: '5'
    }}
  >
    <Btn type='button' onClick={openModal} />
  </div>
)

export default UploadButton
