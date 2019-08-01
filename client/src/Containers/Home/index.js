import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'
import UploadButton from '../../Components/UploadButton'
import ContentDiv from '../../Elements/ContentDiv'
import Modal from '../../Components/Modal'

// import the actions to dispatch
import {
  fetchFolder,
  newFolder,
  folderToTrash,
  fileToTrash,
  moveFolder,
  moveFile
} from '../../ducks/folder.duck'

class Home extends React.Component {
  state = { show: false, isTrash: false }

  showModal = () => {
    this.setState({ ...this.state, show: true })
  }

  hideModal = () => {
    this.setState({ ...this.state, show: false })
  }

  componentDidMount (prevProps) {
    this.props.loadFolder(1)
  }

  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <>
        <ContentDiv>
          <h3>
            /{this.props.folderName === 'root' ? '' : this.props.folderName}
          </h3>
          <h2 style={{ margin: '5px' }}>Files</h2>
          {files === undefined
            ? null
            : File(
              this.state.isTrash,
              files,
              folders,
              this.props.fileToTrash,
              this.props.moveFile
            )}
          <h2 style={{ marginBottom: '5px' }}>Folders</h2>
          {folders === undefined
            ? null
            : Folder(
              this.state.isTrash,
              folders,
              this.props.folderToTrash,
              this.props.loadFolder,
              this.props.moveFolder
            )}
        </ContentDiv>
        <div
          style={{
            display: this.state.show ? 'block' : 'none',
          }}
        />
        <UploadButton
          openModal={this.showModal}
          style={{ cursor: 'pointer' }}
        />
        <div
          style={{
            display: this.state.show ? 'flex' : 'none',
            background: '#6FCF97',
          }}
        >
          <Modal hideModal={this.hideModal} create={this.props.createFolder} />
        </div>
      </>
    )
  }
}

Home.propTypes = {}

const mapStateToProps = state => ({
  folderId: state.folder.id,
  folderName: state.folder.name,
  folderList: state.folder.folders,
  fileList: state.folder.files
})

const mapDispatchToProps = dispatch => ({
  loadFolder: folderId => dispatch(fetchFolder(folderId)),
  folderToTrash: folderId => dispatch(folderToTrash(folderId)),
  fileToTrash: fileId => dispatch(fileToTrash(fileId)),
  moveFolder: (folderId, newParent) =>
    dispatch(moveFolder(folderId, newParent)),
  moveFile: (fileId, newParent) => dispatch(moveFile(fileId, newParent)),
  createFolder: (folderName, parentId) =>
    dispatch(newFolder(folderName, parentId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Home)
