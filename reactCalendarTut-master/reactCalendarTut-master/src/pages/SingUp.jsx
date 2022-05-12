import React from "react";
import { Formik, Form, useField, ErrorMessage } from "formik";
import { object, string } from "yup";
import axios from "axios";
import GatewayService from "../services/gatewayService";


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

function SignUp() {
  const handleSubmit = (values) => {
    console.log(values);
    
    axios.post('http://localhost:5555/gateway/user/add', values)
                    .then(console.log("Eklendi"));
  };

  return (
    <div className="h-screen flex items-center justify-center flex-col bg-gray-100">
      <Formik
        initialValues={{
          name: "",
          email: "",
          password: "",
         
        }}
        onSubmit={handleSubmit}
        validationSchema={RegisterValidation}
      >
        {() => {
          return (
            <Form className="bg-white w-6/12 shadow-md rounded px-8 pt-6 pb-8">
              <Input name="name" label="Name" /><br></br>
              <Input name="email" label="Email" /><br></br>
              <Input name="password" label="Password" type="password" /><br></br>
             <br></br>
              <div className="flex items-center justify-between">
                <button
                  className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                  type="submit"
                >
                  Register
                </button>
              </div>
            </Form>
          );
        }}
      </Formik>
    </div>
  );
}

export default SignUp;