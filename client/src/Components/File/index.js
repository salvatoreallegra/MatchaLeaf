import React from 'react'
import fileIcon from '../../image_source/fileIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const File = files => (
  <div>
    {files.map(file => (
      <div key={file.id} style={{ background: 'white', margin: '10px' }}>
        <img src={fileIcon} alt='file' />
        {file.name}
        <img src={downloadIcon} alt='download' />
        <img src={trashIcon} alt='trash' />
      </div>
    ))}
  </div>
)
export default File
