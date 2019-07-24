import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'

import createReducer from './reducers'

export default function configureStore () {
  const middlewares = [thunk]

  const enhancers = [applyMiddleware(...middlewares)]

  const composeEnhancers = composeWithDevTools({
    // Specify name here, actionsBlacklist, actionsCreators and other options if needed
  })

  return createStore(createReducer(), composeEnhancers(...enhancers))
}
