import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'
import ContentDiv from '../../Elements/ContentDiv'

// need to import the actions to dispatch

class Trash extends React.Component {
  componentDidMount (prevProps) {
    this.props.loadFolder(2)
  }

  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <ContentDiv>
        <h3>{this.props.folderName}</h3>
        <h2>Files</h2>
        <hr />
        {File(files)}
        <h2>Folders</h2>
        <hr />
        {Folder(folders)}
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

export default connect(mapStateToProps)(Trash)
