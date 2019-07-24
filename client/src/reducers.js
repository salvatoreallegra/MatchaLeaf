import { combineReducers } from 'redux'
import folderReducer from './ducks/folder.duck'

export default function createReducer () {
  return combineReducers({
    folder: folderReducer
  })
}
