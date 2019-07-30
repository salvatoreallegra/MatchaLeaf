import React from 'react'
import folderIcon from '../../image_source/folderIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const Folder = (isTrash, folders, toggleTrash, loadFolder) => (
  <div>
    {folders.map(folder => (
      <div
        key={folder.id}
        style={{
          background: 'white',
          margin: '10px',
          boxShadow: '1px 1px 5px rgba(000, 000, 000, 0.2)'
        }}
      >
        <img src={folderIcon} alt='folder' />
        <span
          onClick={() => loadFolder(folder.id)}
          style={{ cursor: 'pointer' }}
        >
          {folder.name}
        </span>
        {isTrash ? null : <img src={downloadIcon} alt='download' />}

        <img
          src={trashIcon}
          alt='trash'
          onClick={() => toggleTrash(folder.id)}
        />
      </div>
    ))}
  </div>
)

export default Folder
