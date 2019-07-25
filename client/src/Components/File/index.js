import React from 'react'
import fileIcon from '../../image_source/fileIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const File = files => (
  <div>
    {files.map(file => (
      <div key={file.id} style={{ background: 'white', margin: '5px' }}>
        <img src={fileIcon} />
        {file.name}
        <img src={downloadIcon} />
        <img src={trashIcon} />
      </div>
    ))}
  </div>
)
export default File
