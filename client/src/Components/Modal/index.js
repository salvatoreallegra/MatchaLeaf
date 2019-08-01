import React, { useState } from 'react'
import connect from 'react-redux/es/connect/connect'
import StyledModal from '../../Elements/Modal'
import { newFolder } from '../../ducks/folder.duck'

const Modal = props => {
  const [flag, setFlag] = useState(true)
  const [folderName, setFolderName] = useState('')

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
              <input type='file' name='file[]' multiple />
              <input type='submit' value='Upload File' name='submit' />
            </form>
          ) : (
            <form method='post' encType='multipart/form-data'>
              <input
                type='folder'
                name='folder'
                multiple
                onChange={event => {
                  event.persist()
                  setFolderName(event)
                }}
              />
              <input
                type='submit'
                value='Create folder'
                name='submit'
                onClick={event => {
                  event.preventDefault()
                  console.log(folderName.target.value)
                  console.log(props.folder.id)
                  props.createFolder(folderName.target.value, props.folder.id)
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
    dispatch(newFolder(folderName, parentId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Modal)
