import styled from 'styled-components'

import { NavLink } from 'react-router-dom'

const Link = styled(NavLink)`
  text-align: center;
  margin-top: 20px;
  color: #6d7d7a;
  text-decoration: none;
  &.active {
    font-weight: bold;
  }
  &:hover {
    cursor: pointer;
    font-weight: bold;
  }
`
export default Link
