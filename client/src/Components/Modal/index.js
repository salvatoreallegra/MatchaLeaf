import React from 'react'

const Modal = ({ hideModal }) => {
  return (
    <div>
      <form method='post' enctype='multipart/form-data'>
        <input type='file' name='files[]' multiple />
        <input type='submit' value='Upload File' name='submit' />
      </form>
      <button onClick={hideModal}>close</button>
    </div>
  )
}
export default Modal
