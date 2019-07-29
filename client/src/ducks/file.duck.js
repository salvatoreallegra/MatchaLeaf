// actions
export const LOAD_FILES = 'cooksys/matchaleaf/Folder/LOAD_FILES'
export const CREATE_FILES = 'cooksys/matchaleaf/Folder/CREATE_FILES'
export const DELETE_FILES = 'cooksys/matchaleaf/Folder/DELETE_FILES'

// initial state
const initialState = {
  id: 1,
  name: '/'
}

// reducer
export default function reducer (state = initialState, action) {
  switch (action.type) {
    case LOAD_FILES:
      return {
        ...state
      }
    case CREATE_FILES:
      return {
        ...state
      }
    case DELETE_FILES:
      return {
        ...state
      }
    default:
      return state
  }
}

// action creators
export const loadFiles = file => ({
  type: LOAD_FILES,
  payload: file
})

export const createFiles = file => ({
  type: CREATE_FILES,
  payload: file
})

export const deleteFiles = fileId => ({
  type: DELETE_FILES,
  payload: fileId
})
