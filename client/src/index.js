import React from 'react'
import * as ReactDOM from 'react-dom'
import { Provider } from 'react-redux'
import App from './Containers/App/App'
import { BrowserRouter } from 'react-router-dom'
import { createGlobalStyle } from 'styled-components'
import configureStore from './configureStore'

const store = configureStore()
const MOUNT_NODE = document.getElementById('root')

const GlobalStyle = createGlobalStyle`
body {
    background-image: url('');
    background: rgb(255,255,255);
    background: #6FCF97;
}
a {
  text-decoration: none;
}
`

ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
      <GlobalStyle />
      <App />
    </BrowserRouter>
  </Provider>,
  MOUNT_NODE
)
