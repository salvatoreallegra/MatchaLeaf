import React from 'react'
import Btn from '../../Elements/Btn'

const UploadButton = ({ openModal }) => (
  <div>
    <Btn type='button' onClick={openModal} />
  </div>
)

export default UploadButton
