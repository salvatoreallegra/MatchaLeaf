import React from 'react'
import folderIcon from '../../image_source/folderIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const Folder = folders => (
  <div>
    {folders.map(folder => (
      <div key={folder.id} style={{ background: 'white', margin: '5px' }}>
        <img src={folderIcon} alt='folder' />
        {folder.name}
        <img src={downloadIcon} alt='download' />
        <img src={trashIcon} alt='' trash />
      </div>
    ))}
  </div>
)
export default Folder
