import React from 'react'
import fileIcon from '../../image_source/fileIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const File = (files, sendToTrash) => (
  <div>
    {files.map(file => (
      <div
        key={file.id}
        style={{
          background: 'white',
          margin: '10px',
          boxShadow: '1px 1px 5px rgba(000, 000, 000, 0.2)'
        }}
      >
        <img src={fileIcon} alt='file' />
        {file.name}
        <img src={downloadIcon} alt='download' />
        <img src={trashIcon} alt='trash' onClick={() => sendToTrash(file.id)} />
      </div>
    ))}
  </div>
)
export default File
