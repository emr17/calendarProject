import React from 'react'
import { Calendar } from 'react-big-calendar'
import { Container } from 'semantic-ui-react'
import Navi from './layouts/Navi'
import { Button, Dropdown, Menu } from 'semantic-ui-react'
import './App.css';
import Dashboard from './layouts/Dashboard'




export default function App() {


  return (
    <div className="App">
      <Navi />

      <Container className='main' >
        <Dashboard/>
      </Container>

    </div>
  )
  
}
