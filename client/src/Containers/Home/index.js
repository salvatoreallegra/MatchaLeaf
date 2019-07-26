import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'
import ContentDiv from '../../Elements/ContentDiv'

// need to import the actions to dispatch

class Home extends React.Component {
  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <ContentDiv>
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

Home.propTypes = {}

const mapStateToProps = state => ({
  folderId: state.folder.id,
  folderName: state.folder.name,
  folderList: state.folder.folders,
  fileList: state.folder.files
})

export default connect(mapStateToProps)(Home)
