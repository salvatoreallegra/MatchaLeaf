import React from 'react'

const Modal = ({ hideModal }) => {
  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'column'
      }}
    >
      <form method='post' enctype='multipart/form-data'>
        <input type='file' name='files[]' multiple />
        <input type='submit' value='Upload File' name='submit' />
      </form>
      <button onClick={hideModal}>cancel</button>
    </div>
  )
}
export default Modal
