import React, { Component } from 'react'
// import { Route } from 'react-router-dom'
import NavBar from '../../Components/NavBar'

class App extends Component {
  state = {
    items: [{ text: 'Home', link: '/home' }, { text: 'Trash', link: '/trash' }]
  }

  render () {
    const { items } = this.state
    return (
      <div>
        <NavBar items={items} />
        {/* <Route path='/' component={NavBar} /> */}
      </div>
    )
  }
}

export default App
