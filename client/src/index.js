import React from 'react'
import ReactDOM from 'react-dom'
import App from './Containers/App/App'
import { createGlobalStyle } from 'styled-components'

const GlobalStyle = createGlobalStyle`
body {
    background-image: url('');
    background: rgb(255,255,255);
    background: linear-gradient(90deg, rgba(255,255,255,0.5) 0%, rgba(255,255,255,0.5) 44%, rgba(118,189,7,0.5) 100%);
}
`

ReactDOM.render(
  <>
    <GlobalStyle />
    <App />
  </>,
  document.getElementById('root')
)
