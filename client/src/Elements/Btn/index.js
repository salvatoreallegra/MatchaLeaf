import styled from 'styled-components'

const Btn = styled.button`
  grid-row-start: 5;
  grid-row-end: 5;
  grid-column-start: 5;
  grid-column-end: 5;
  border: 2px solid lightgrey;
  background-color: var(--main-color);
  font-size: 22px;
  height: 2.5em;
  width: 2.5em;
  border-radius: 999px;
  position: relative;
  box-shadow: 3px 3px 10px rgba(000, 000, 000, 0.7);

  &:after,
  &:before {
    content: '';
    display: block;
    background-color: black;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  &:before {
    height: 1em;
    width: 0.2em;
  }

  &:after {
    height: 0.2em;
    width: 1em;
  }
  &:hover {
    background: var(--second-color);
  }
`

export default Btn
