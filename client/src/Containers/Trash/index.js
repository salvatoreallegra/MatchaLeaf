import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'
import ContentDiv from '../../Elements/ContentDiv'

// need to import the actions to dispatch
import {
  fetchFolder,
  restoreFolder,
  restoreFile,
  deleteFile,
  deleteFolder
} from '../../ducks/folder.duck'

class Trash extends React.Component {
  state = { isTrash: true }

  componentDidMount (prevProps) {
    this.props.loadFolder(2)
  }

  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <ContentDiv>
        <h3>
          /trash
          {this.props.folderName !== 'trash' ? `/${this.props.folderName}` : ''}
        </h3>
        <h2>Files</h2>
        <hr />
        {File(this.state.isTrash, files, folders, this.props.restoreFile, this.props.deleteFile)}
        <h2>Folders</h2>
        <hr />
        {Folder(
          this.state.isTrash,
          folders,
          this.props.restoreFolder,
          this.props.loadFolder,
          this.props.deleteFolder
        )}
      </ContentDiv>
    )
  }
}

Trash.propTypes = {}

const mapStateToProps = state => ({
  folderId: state.folder.id,
  folderName: state.folder.name,
  folderList: state.folder.folders,
  fileList: state.folder.files
})

const mapDispatchToProps = dispatch => ({
  loadFolder: folderId => dispatch(fetchFolder(folderId)),
  restoreFolder: folderId => dispatch(restoreFolder(folderId)),
  restoreFile: fileId => dispatch(restoreFile(fileId)),
  deleteFile: fileId => dispatch(deleteFile(fileId)),
  deleteFolder: folderId => dispatch(deleteFolder(folderId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Trash)
