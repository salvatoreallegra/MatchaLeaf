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
  restoreFile
} from '../../ducks/folder.duck'

class Trash extends React.Component {
  state = { isTrash: false }

  componentDidMount (prevProps) {
    this.props.loadFolder(2)
  }

  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <ContentDiv>
        <h3>/trash/{this.props.folderName}</h3>
        <h2>Files</h2>
        <hr />
        {File(this.state.isTrash, files, this.props.restoreFile)}
        <h2>Folders</h2>
        <hr />
        {Folder(
          this.state.isTrash,
          folders,
          this.props.restoreFolder,
          this.props.loadFolder
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
  restoreFile: fileId => dispatch(restoreFile(fileId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Trash)
