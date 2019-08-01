import React from 'react'
import fileIcon from '../../image_source/fileIcon2.png'
import downloadIcon from '../../image_source/downloadIcon2.png'
import trashIcon from '../../image_source/trashIcon2.png'
import restoreIcon from '../../image_source/restoreIcon2.png'

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
        <span
          style={{
            display:'flex',
            flexDirection:'row',
            justifyContent: 'space-between'
          }}>
          <span>
            <img style={{ margin: '2px 5px 0 5px' }} src={fileIcon} alt='file' />
            {file.name}
          </span>
          <span>
            {isTrash ? null : <img style={{ marginTop: '2px' }} src={downloadIcon} alt='download' />}
            <img
              style={{ marginTop: '2px' }}
              src={isTrash ? restoreIcon : trashIcon}
              alt='trash'
              onClick={() => toggleTrash(file.id)}
            />
            {isTrash ? (
              <img
                style={{ marginTop: '2px' }}
                src={trashIcon}
                alt='trash'
                onClick={() => moveOrDeleteFile(file.id)}
              />
            ) : null}
            {isTrash ? null : (
              <select
                style={{ border:'none'}}
                onChange={event => moveOrDeleteFile(file.id, event.target.value)}
              >
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
          </span>
      </span>
      </div>
    ))}
  </div>
)
export default File
