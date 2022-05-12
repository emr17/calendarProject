import React from 'react'
import { Dropdown, Image, Menu } from 'semantic-ui-react'

export default function SignedIn({signOut}) {// istersek parantez içine props yazıp aşağıda props.signOut olarak da kullanabiliriz
                                        // onun yerine obje destructringi kullanıcaz {}
  return (
    <div>
        <Menu.Item>
            <Image avatar spaced="right" src="https://image.shutterstock.com/image-vector/emergency-exit-sign-icon-door-600w-222002968.jpg" />
            <Dropdown pointing="top left" text='Exit'> 
                <Dropdown.Menu>
                    <Dropdown.Item onClick={signOut} text="Çıkış" icon="sign-out "></Dropdown.Item>

                    
                </Dropdown.Menu>
            </Dropdown>
        </Menu.Item>
    </div>
  )
}
