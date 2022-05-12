import React ,{useState} from 'react'
import { Button, Dropdown, Menu, Container } from 'semantic-ui-react'
import SignedOut from './SignedOut'
import SignedIn from './SignedIn'
import { useHistory } from 'react-router-dom'




export default function Navi() {
  
  const [isAuthenticated, setIsAuthenticated] = useState(true)

  const history = useHistory()
  // history olayı mesela sepet detayındayken çıkış yaparsa ansayfaya dönsün diye
  function handleSignOut() {
    setIsAuthenticated(false);
    history.push("/")
  }
  function handleSignIn() {
    setIsAuthenticated(true);
  }

  return (
    <div>
      <Menu inverted fixed='top'>
        <Container>
          
        

          <Menu.Menu position='right'>
            {/* cartItems boşsa cartsummary göstermicem */}
          
          {/*prop yani değer gönderme prototype gibi  */}
          {isAuthenticated?<SignedIn signOut={handleSignOut} bisey={1}/>:<SignedOut signIn={handleSignIn}/>}

            
          </Menu.Menu>


        </Container>  
      </Menu>
    </div>
  )
}
