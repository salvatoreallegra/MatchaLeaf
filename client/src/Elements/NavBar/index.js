import styled from 'styled-components'

const StyledNavBar = styled.nav`
  grid-row-start: 1;
  grid-row-end: 5;
  grid-column-start: 1;
  grid-column-end: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: Roboto;
  font-style: normal;
  font-size: 24px;
  line-height: 28px;
  height: 100vh;
  border-right: 1px solid #000;
  margin-top: -10px;
`
export default StyledNavBar
