import React from 'react'
import StyledNavBar from '../../Elements/NavBar'
import Link from '../../Elements/Link'

const NavBar = ({ items }) => (
  <StyledNavBar>
    {items.map(item => (
      <Link activeClassName='active' key={item.text} to={item.link}>
        {item.text}
      </Link>
    ))}
  </StyledNavBar>
)

export default NavBar
