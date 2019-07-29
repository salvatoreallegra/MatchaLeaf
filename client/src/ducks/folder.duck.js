import initialState from './mockState'
import axios from 'axios'
const API_ROOT = 'localhost:8000/'

// actions
export const LOAD_FOLDER = 'cooksys/matchaleaf/Folder/LOAD_FOLDER'
export const CREATE_FOLDER = 'cooksys/matchaleaf/Folder/CREATE_FOLDER'
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
        ...state
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

export const createFolder = folder => ({
  type: CREATE_FOLDER,
  payload: folder
})

export const deleteFolder = folderId => ({
  type: DELETE_FOLDER,
  payload: folderId
})

export const fetchFolder = folderId => dispatch =>
  axios
    .get(`${API_ROOT}folders/${folderId}`)
    .then(result => dispatch(loadFolder(result)))
    .catch(err => console.log(`Oops... ${err}`))
