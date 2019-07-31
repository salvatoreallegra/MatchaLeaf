import React, { Component } from 'react'
import { Route } from 'react-router-dom'
import NavBar from '../../Components/NavBar'
import Home from '../Home'
import Trash from '../Trash'
import styled from 'styled-components'

const GridDiv = styled.div`
  display: flex;
  flex-direction: row;
`

class App extends Component {
  state = {
    items: [{ text: 'Home', link: '/home' }, { text: 'Trash', link: '/trash' }]
  }

  render () {
    const { items } = this.state
    return (
      <GridDiv>
        <NavBar items={items} />
        <Route path='/home' component={Home} />
        <Route path='/trash' component={Trash} />
      </GridDiv>
    )
  }
}

export default App
