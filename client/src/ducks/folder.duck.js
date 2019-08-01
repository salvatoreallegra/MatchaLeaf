import axios from 'axios'
const API_ROOT = 'http://localhost:8080/'

// actions
export const LOAD_FOLDER = 'cooksys/matchaleaf/Folder/LOAD_FOLDER'
export const CREATE_FOLDER = 'cooksys/matchaleaf/Folder/CREATE_FOLDER'
export const REMOVE_FOLDER = 'cooksys/matchaleaf/Folder/REMOVE_FOLDER'
export const REMOVE_FILE = 'cooksys/matchaleaf/Folder/REMOVE_FILE'

// initial state
const initialState = {
  id: 1,
  name: '/',
  files: [],
  folders: []
}

// reducer
export default function reducer (state = initialState, action) {
  switch (action.type) {
    case LOAD_FOLDER:
      return {
        ...state,
        id: action.payload.id,
        name: action.payload.name,
        files: action.payload.files,
        folders: action.payload.folders
      }
    case CREATE_FOLDER:
      return {
        ...state,
        folders: [...state.folders, action.payload]
      }
    case REMOVE_FILE:
      return {
        ...state,
        files: state.files.filter(file => file.id !== action.payload)
      }
    case REMOVE_FOLDER:
      return {
        ...state,
        folders: state.folders.filter(folder => folder.id !== action.payload)
      }

    default:
      return state
  }
}

// action creators
export const loadFolder = folder => ({
  type: LOAD_FOLDER,
  payload: folder
})

export const createFolder = folder => ({
  type: CREATE_FOLDER,
  payload: folder
})

export const removeFile = fileId => ({
  type: REMOVE_FILE,
  payload: fileId
})

export const removeFolder = folderId => ({
  type: REMOVE_FOLDER,
  payload: folderId
})

// api calls
export const fetchFolder = folderId => dispatch =>
  axios
    .get(`${API_ROOT}folders/${folderId}`)
    .then(({ data }) => dispatch(loadFolder(data)))
    .catch(err => console.log(`Oops... ${err}`))

// API CALLS TO SEND AND RESTORE FILE AND FOLDERS FROM TRASH
export const folderToTrash = folderId => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/trash`)
    .then(result => dispatch(removeFolder(folderId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const fileToTrash = fileId => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/trash`)
    .then(result => dispatch(removeFile(fileId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const restoreFolder = folderId => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/restorefolder`)
    .then(result => dispatch(removeFolder(folderId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const restoreFile = fileId => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/restorefile`)
    .then(result => dispatch(removeFile(fileId)))
    .catch(err => console.log(`operation invalid: ${err}`))

// API calls to move folder/files to other folders
export const moveFolder = (folderId, newParent) => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/move?id=${newParent}`)
    .then(result => dispatch(removeFolder(folderId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const moveFile = (fileId, newParent) => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/move?id=${newParent}`)
    .then(result => dispatch(removeFile(fileId)))
    .catch(err => console.log(`operation invalid: ${err}`))

// API calls to upload file and create folder
export const newFolder = (folderName, parentId) => dispatch =>
  axios
    .post(`${API_ROOT}folders/`, {
      name: folderName,
      parentFolderId: parentId
    })
    .then(result => {
      console.log(result.config.data)
      dispatch(createFolder(result.config.data))
    })
    .catch(err => console.log(`operation invalid: ${err}`))

// API Call to delete file and folders definetly
export const deleteFile = fileId => dispatch =>
  axios
    .delete(`${API_ROOT}files/${fileId}/delete`)
    .then(result => dispatch(removeFile(fileId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const deleteFolder = folderId => dispatch =>
  axios
    .delete(`${API_ROOT}folders/${folderId}/delete`)
    .then(result => dispatch(removeFolder(folderId)))
    .catch(err => console.log(`operation invalid: ${err}`))
