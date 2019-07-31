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
        files: [...state.files, action.payload]
      }
    case REMOVE_FILE:
      return {
        ...state,
        files: state.files.filter(folder => folder.id !== action.payload)
      }
    case REMOVE_FOLDER:
      return {
        ...state,
        folders: state.folders.filter(file => file.id !== action.payload)
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

export const createFolder = (folderName, folderId) => ({
  type: CREATE_FOLDER,
  payload: { folderName, folderId }
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

export const newFolder = (folderName, parentId) => dispatch =>
  axios
    .post(`${API_ROOT}folders/`, {
      name: folderName,
      parent: parentId
    })
    .then(result => dispatch(createFolder(folderName, result)))
    .catch(err => console.log(`impossible to create: ${err}`))

// API CALLS TO SEND AND RESTORE FILE AND FOLDERS FROM TRASH
export const folderToTrash = folderId => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/trash`)
    .then(result => {
      console.log('calling folderToTrash')
      console.log(folderId)
      dispatch(removeFolder(folderId))
    })
    .catch(err => console.log(`operation invalid: ${err}`))

export const fileToTrash = fileId => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/trash`)
    .then(result => {
      console.log('calling fileToTrash')
      dispatch(removeFile(fileId))
    })
    .catch(err => console.log(`operation invalid: ${err}`))

export const restoreFolder = folderId => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/restorefolder`)
    .then(result => {
      console.log('calling restoreFolder')
      dispatch(removeFolder(folderId))
    })
    .catch(err => console.log(`operation invalid: ${err}`))

export const restoreFile = fileId => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/restore`)
    .then(result => {
      console.log('calling restoreFile')
      dispatch(removeFile(fileId))
    })
    .catch(err => console.log(`operation invalid: ${err}`))
