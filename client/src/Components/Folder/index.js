import React from 'react'
import folderIcon from '../../image_source/folderIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'

const Folder = (isTrash, folders, toggleTrash, loadFolder, moveFolder) => (
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
        {isTrash ? null : (
          <select onChange={event => moveFolder(folder.id, event.target.value)}>
            <option value='' defaultValue hidden>
              Move to
            </option>
            {folders
              .filter(iterator => iterator.id !== folder.id)
              .map(obj => (
                <option value={obj.id} key={obj.id}>
                  {obj.name}
                </option>
              ))}
          </select>
        )}
      </div>
    ))}
  </div>
)

export default Folder
