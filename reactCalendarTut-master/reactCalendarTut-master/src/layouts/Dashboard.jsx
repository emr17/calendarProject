import React from 'react'
import { Grid, GridColumn } from 'semantic-ui-react'
import { Route, Routes } from 'react-router-dom'
import{ToastContainer} from 'react-toastify' 
import SignIn from '../pages/SignIn'
import SignUp from '../pages/SingUp'

import Aaa from './Aaa'


export default function Dashboard() {
  return (
    <div>
      <ToastContainer position="bottom-right" />
      <Grid>
        <Grid.Row>
          

          <Grid.Column width={16}>
            {/* / yani ansayfayadaysa ProductLisiti aç
                ROUTE YANİ COMPONENTLERİN NEREDE GÖSTERİLECEĞİ
                exact önemli
            */}
              <Route exact path="/" component={SignIn}/>
              {/* DİKKAT PARAMETRE */}
              <Route  path="/calendar/:id" component={Aaa}/>
              <Route  path="/signup" component={SignUp}/>


              {/* :id parametre yani ne versem vereyim çalışır */}

              
          </Grid.Column>
        </Grid.Row>

      </Grid>
    </div>

  )
}
