import React from 'react'
import styled from 'styled-components'

const Section = styled.section`
  position: fixed;
  background: white;
  width: 80%;
  height: auto;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
`

const Modal = handleClose => {
  return (
    <div
      style={{
        display: 'block',
        gridRowStart: '1',
        gridRowEnd: '5',
        gridColumnStart: '1',
        gridColumnEnd: '5'
      }}
    >
      <Section>
        <button onClick={handleClose}>close</button>
      </Section>
    </div>
  )
}
export default Modal
