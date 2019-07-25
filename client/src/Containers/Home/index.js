import React from 'react'
// import PropTypes from 'prop-types'
import connect from 'react-redux/es/connect/connect'
import File from '../../Components/File'
import Folder from '../../Components/Folder'

// need to import the actions to dispatch

class Home extends React.Component {
  render () {
    const folders = this.props.folderList
    const files = this.props.fileList

    return (
      <div>
        {File(files)}
        -----
        {Folder(folders)}
      </div>
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
