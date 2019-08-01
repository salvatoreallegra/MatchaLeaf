import React from 'react'
import StyledNavBar from '../../Elements/NavBar'
import Link from '../../Elements/Link'
import logo from '../../image_source/small_logo.png'


const NavBar = ({ items }) => (
  <div>
    <Link activeClassName='active' key={logo} to='/home'
      style={{ display:'flex', justifySelf: 'left' }}>
      <img key={logo} src={logo} />
    </Link>
    <StyledNavBar>
      {items.map(item => (
        <Link activeClassName='active' key={item.text} to={item.link}>
          {item.text}
        </Link>
      ))}
    </StyledNavBar>
  </div>
)

export default NavBar
