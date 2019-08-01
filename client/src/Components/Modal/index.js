import React, { useState } from 'react'
import StyledModal from '../../Elements/Modal'

const createFileForm = () => {
  return (
    <form method='post' encType='multipart/form-data'>
      <input type='file' name='file[]' multiple />
      <input type='submit' value='Upload File' name='submit' />
    </form>
  )
}

const createFolderForm = createFolder => {
  return (
    <form method='post' encType='multipart/form-data'>
      <input type='folder' name='folder' multiple />
      <input type='submit' value='Create folder' name='submit' />
    </form>
  )
}

const Modal = ({ hideModal }, create) => {
  const [flag, setFlag] = useState(true)

  return (
    <StyledModal>
      <div>
        <nav
          style={{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'space-evenly',
            width: '100%',
            height: '8vh',
            marginBottom: '5vh'
          }}
        >
          <button
            onClick={() => setFlag(true)}
            style={{ width: '50%', backgroundColor: '#FFFFFF' }}
          >
            File
          </button>
          <button
            onClick={() => setFlag(false)}
            style={{ width: '50%', backgroundColor: '#FFFFFF' }}
          >
            Folder
          </button>
        </nav>
        <div style={{ width: '25vw' }}>
          {flag ? createFileForm() : createFolderForm(create)}
        </div>
        <button onClick={hideModal}>cancel</button>
      </div>
    </StyledModal>
  )
}
export default Modal
