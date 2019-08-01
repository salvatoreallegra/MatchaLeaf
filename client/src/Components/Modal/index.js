import React, { useState } from 'react'
import connect from 'react-redux/es/connect/connect'
import StyledModal from '../../Elements/Modal'
import { newFolder, uploadFile } from '../../ducks/folder.duck'

const Modal = props => {
  const [flag, setFlag] = useState(true)
  const [folderName, setFolderName] = useState('')
  const [data, setData] = useState('')

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
          {flag ? (
            <form method='post' encType='multipart/form-data'>
              <input
                type='file'
                name='file[]'
                multiple
                onChange={event => {
                  event.persist()
                  console.log(event)
                  console.log(event.target.files)
                  setData(event.target.files[0])
                }}
              />
              <input
                type='submit'
                value='Upload File'
                name='submit'
                onClick={event => {
                  event.preventDefault()
                  props.uploadFile(data, props.folder.id)
                }}
              />
            </form>
          ) : (
            <form method='post' encType='multipart/form-data'>
              <input
                type='folder'
                name='folder'
                multiple
                onChange={event => {
                  event.persist()
                  setFolderName(event.target.value)
                }}
              />
              <input
                type='submit'
                value='Create folder'
                name='submit'
                onClick={event => {
                  event.preventDefault()
                  props.createFolder(folderName, props.folder.id)
                }}
              />
            </form>
          )}
        </div>
        <button onClick={() => props.hideModal()}>cancel</button>
      </div>
    </StyledModal>
  )
}

const mapStateToProps = state => ({
  folder: state.folder
})

const mapDispatchToProps = dispatch => ({
  createFolder: (folderName, parentId) =>
    dispatch(newFolder(folderName, parentId)),
  uploadFile: (file, parentFolderId) =>
    dispatch(uploadFile(file, parentFolderId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Modal)
