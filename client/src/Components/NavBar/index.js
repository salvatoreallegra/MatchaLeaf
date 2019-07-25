import React from 'react'
import StyledNavBar from '../../Elements/NavBar'
import StyledNavLink from '../../Elements/NavLink'
import Link from '../../Elements/NavLink'

const NavBar = ({ items }) => (
  <StyledNavBar>
    {items.map(item => (
      <Link activeClassName='active' key={item.text} to={item.link}>
        <StyledNavLink>{item.text}</StyledNavLink>
      </Link>
    ))}
  </StyledNavBar>
)

export default NavBar
