import React from "react";
import { Formik, Form, useField, ErrorMessage } from "formik";
import { object, string, ref } from "yup";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import axios from "axios";
import { useHistory } from 'react-router-dom'
import GatewayService from "../services/gatewayService";
import { useEffect } from "react";
import { useState } from "react";


const RegisterValidation = object().shape({
  name: string().required("Required"),
  email: string()
    .required("Valid email required")
    .email("Valid email required"),
  password: string().min(8, "Min 8 characters").required("Required"),

});

const Input = ({ name, label, ...props }) => {
  const [field, meta] = useField(name);
  return (
    <div className="mb-4">
      <label className="block text-gray-700 text-sm font-bold" for={field.name}>
        {label}
      </label>
      <input
        className={`${
          meta.error && meta.touched ? "border-red-500" : ""
        } shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline`}
        {...field}
        {...props}
      />
      <ErrorMessage
        name={field.name}
        component="div"
        className="text-red-500 text-xs"
      />
    </div>
  );
};

function SignIn() {

  const [users, setUsers] = useState([]); // use state içi ilk state oluyor
  //setPRoducts productsa ekleyecek use state ilk state boş array

  //component yüklendiğinde çalışmasını istediğimiz kodu buraya yazıyoruz
  useEffect(()=>{
    let gatewayService = new GatewayService;
    //başarılı olursa then başarısız olursa catch
    //
    gatewayService.getAllUsers().then(result=>setUsers(result))
  },[])




const history = useHistory()

  const handleSignIn = (values) => {

    console.log(users);
    let user=users.data.find(c=>c.email===values.email && c.password===values.password );
    console.log(user);
    if(user){
      console.log(user.id);
      
      history.push("calendar/"+ user.id)
      

    }
    else{
      
    }

  };

  return (
    <div className="h-screen flex items-center justify-center flex-col bg-gray-100">
      <Formik
        initialValues={{
          email: "",
          password: "",
        }}
        onSubmit={handleSignIn}
        
      >
        {() => {
          return (
            <Form className="bg-white w-6/12 shadow-md rounded px-8 pt-6 pb-8">
              <Input name="email" label="Email" /><br></br>
              <Input name="password" label="Password" type="password" /><br></br>
              
              <div className="flex items-center justify-between">
                <button
                  className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                  type="submit"
                >
                  Sign In
                </button>
                <br></br>

                <Link to="/signup">
                Not registered? Register
                </Link>
              </div>
            </Form>
          );
        }}
      </Formik>
    </div>
  );
}

export default SignIn;