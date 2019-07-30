import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'
import UploadButton from '../../Components/UploadButton'
import ContentDiv from '../../Elements/ContentDiv'
import Modal from '../../Components/Modal'

// need to import the actions to dispatch
import {
  fetchFolder,
  newFolder,
  folderToTrash,
  fileToTrash
} from '../../ducks/folder.duck'

class Home extends React.Component {
  state = { show: false }

  showModal = () => {
    this.setState({ show: true })
  }

  hideModal = () => {
    this.setState({ show: false })
  }

  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <>
        <ContentDiv>
          <h3>{this.props.folderName}</h3>
          <h2>Files</h2>
          <hr />
          {files === undefined ? null : File(files, this.props.fileToTrash)}
          <h2>Folders</h2>
          <hr />
          {folders === undefined
            ? null
            : Folder(folders, this.props.loadFolder, this.props.folderToTrash)}
        </ContentDiv>
        <div
          style={{
            display: this.state.show ? 'block' : 'none',
            gridRowStart: '1',
            gridRowEnd: '6',
            gridColumnStart: '1',
            gridColumnEnd: '6',
            background: 'rgba(000, 000, 000, .7)',
            margin: '-10px'
          }}
        />
        <UploadButton
          openModal={this.showModal}
          style={{ cursor: 'pointer' }}
        />

        <div
          style={{
            display: this.state.show ? 'flex' : 'none',
            gridRowStart: '3',
            gridRowEnd: '4',
            gridColumnStart: '3',
            gridColumnEnd: '4',
            background: '#6FCF97',
            justifyContent: 'center',
            alignItems: 'center',
            flexDirection: 'column'
          }}
        >
          <Modal hideModal={this.hideModal} />
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
  createFolder: (folderName, parentId) =>
    dispatch(newFolder(folderName, parentId)),
  folderToTrash: folderId => dispatch(folderToTrash(folderId)),
  fileToTrash: fileId => dispatch(fileToTrash(fileId))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Home)
