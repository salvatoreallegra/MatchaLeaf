import initialState from './mockState'
import axios from 'axios'
const API_ROOT = 'http://localhost:8080/'

// actions
export const LOAD_FOLDER = 'cooksys/matchaleaf/Folder/LOAD_FOLDER'
export const CREATE_FOLDER = 'cooksys/matchaleaf/Folder/CREATE_FOLDER'
export const SEND_FOLDER_TRASH = 'cooksys/matchaleaf/Folder/SEND_FOLDER_TRASH'
export const DELETE_FOLDER = 'cooksys/matchaleaf/Folder/DELETE_FOLDER'

// initial state
// const initialState = {
//   id: 1,
//   name: '/',
//   files: [],
//   folders: []
// }

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
    case DELETE_FOLDER:
      return {
        ...state
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

export const folderToTrash = folderId => ({
  type: SEND_FOLDER_TRASH,
  payload: folderId
})
export const deleteFolder = folderId => ({
  type: DELETE_FOLDER,
  payload: folderId
})

// api calls
export const fetchFolder = folderId => dispatch =>
  axios
    .get(`${API_ROOT}folders/${folderId}`)
    .then(result => dispatch(loadFolder(result)))
    .catch(err => console.log(`Oops... ${err}`))

export const newFolder = (folderName, parentId) => dispatch =>
  axios
    .post(`${API_ROOT}folders/`, {
      name: folderName,
      parent: parentId
    })
    .then(result => dispatch(createFolder(folderName, result)))
    .catch(err => console.log(`impossible to create: ${err}`))

export const sendFolderToTrash = folderId => dispatch =>
  axios
    .patch(`${API_ROOT}folders/${folderId}/trash`)
    .then(result => dispatch(folderToTrash(folderId)))
    .catch(err => console.log(`operation invalid: ${err}`))

export const sendFileToTrash = fileId => dispatch =>
  axios
    .patch(`${API_ROOT}files/${fileId}/trash`)
    .then(result => dispatch(folderToTrash(fileId)))
    .catch(err => console.log(`operation invalid: ${err}`))
