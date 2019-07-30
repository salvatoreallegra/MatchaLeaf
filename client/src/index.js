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
    --main-color: #FFFFFF;
    --second-color: #6FCF97;
    background: var(--main-color);                                                          /* fallback for old browsers */
    background: -webkit-linear-gradient(to bottom, var(--main-color), var(--second-color)); /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(125.92deg, var(--main-color) 57.13%, var(--second-color) 98.8%);  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
    width: 100vw;
    height: 100vh;
    overflow: hidden;
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
