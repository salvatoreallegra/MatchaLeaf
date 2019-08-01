import React from 'react'
import fileIcon from '../../image_source/fileIcon.png'
import downloadIcon from '../../image_source/downloadIcon.png'
import trashIcon from '../../image_source/trashIcon.png'
import restoreIcon from '../../image_source/restoreIcon.png'

const File = (isTrash, files, folders, toggleTrash, moveOrDeleteFile) => (
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
        {console.log(file.id)}
        <img src={fileIcon} alt='file' />
        {file.name}
        {isTrash ? null : <img src={downloadIcon} alt='download' />}
        <img
          src={isTrash ? restoreIcon : trashIcon}
          alt='trash'
          onClick={() => toggleTrash(file.id)}
        />
        {isTrash ? (
          <img
            src={trashIcon}
            alt='trash'
            onClick={() => moveOrDeleteFile(file.id)}
          />
        ) : null}
        {isTrash ? null : (
          <select onChange={event => moveOrDeleteFile(file.id, event.target.value)}>
            <option value='' defaultValue hidden>
              Move to
            </option>
            {folders.map(folder => (
              <option value={folder.id} key={folder.id}>
                {folder.name}
              </option>
            ))}
          </select>
        )}
      </div>
    ))}
  </div>
)
export default File
