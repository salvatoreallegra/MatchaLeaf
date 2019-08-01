import React from 'react'
import folderIcon from '../../image_source/folderIcon2.png'
import downloadIcon from '../../image_source/downloadIcon2.png'
import trashIcon from '../../image_source/trashIcon2.png'
import restoreIcon from '../../image_source/restoreIcon2.png'

const Folder = (
  isTrash,
  folders,
  toggleTrash,
  loadFolder,
  moveOrDeleteFolder
) => (
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
        <span
          style={{
            display:'flex',
            flexDirection:'row',
            justifyContent: 'space-between'
          }}>
          <span>
            <img style={{ margin: '2px 5px 0 5px' }} src={folderIcon} alt='folder' />
            <span
              onClick={() => loadFolder(folder.id)}
              style={{ cursor: 'pointer' }}
            >
              {folder.name}
            </span>
          </span>
          <span>
            {isTrash ? null : <img style={{ marginTop: '2px' }} src={downloadIcon} alt='download' />}
            <img
              style={{ marginTop: '2px' }}
              src={isTrash ? restoreIcon : trashIcon}
              alt='trash'
              onClick={() => toggleTrash(folder.id)}
            />
            {isTrash ? (
              <img
                style={{ marginTop: '2px' }}
                src={trashIcon}
                alt='trash'
                onClick={() => moveOrDeleteFolder(folder.id)}
              />
            ) : null}
            {isTrash ? null : (
              <select
                style={{ border:'none' }}
                onChange={event =>
                  moveOrDeleteFolder(folder.id, event.target.value)
                }
              >
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
          </span>
        </span>
      </div>
    ))}
  </div>
)

export default Folder
