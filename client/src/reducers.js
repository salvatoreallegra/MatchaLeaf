import { combineReducers } from 'redux'
import folderReducer from './ducks/folder.duck'
import fileReducer from './ducks/file.duck'

export default function createReducer () {
  return combineReducers({
    folder: folderReducer,
    file: fileReducer
  })
}
