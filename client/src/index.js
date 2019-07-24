import React from 'react'
import * as ReactDOM from 'react-dom'
import { Provider } from 'react-redux'
import createHistory from 'history/createBrowserHistory'
import { ConnectedRouter } from 'react-router-redux'
import App from './Containers/App/App'
import { createGlobalStyle } from 'styled-components'
import configureStore from './configureStore'

const history = createHistory()
const store = configureStore({}, history)
const MOUNT_NODE = document.getElementById('root')

const GlobalStyle = createGlobalStyle`
body {
    background-image: url('');
    background: rgb(255,255,255);
    background: linear-gradient(90deg, rgba(255,255,255,0.5) 0%, rgba(255,255,255,0.5) 44%, rgba(118,189,7,0.5) 100%);
}
`

ReactDOM.render(
  <Provider store={store}>
    <ConnectedRouter history={history}>
      <GlobalStyle />
      <App />
    </ConnectedRouter>
  </Provider>,
  MOUNT_NODE
)
