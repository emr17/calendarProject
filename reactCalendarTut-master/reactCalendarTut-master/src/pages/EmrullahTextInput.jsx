import { useField } from 'formik'
import React from 'react'
import { FormField, Label } from 'semantic-ui-react'
// kaç değer geleceğini bilmediğimizden  obje olarak alacaz
export default function EmrullahTextInput({ ...props }) {
    // props = {...props}  
    // hook kullanıcaz
    const [field, meta] = useField(props)
    console.log(field)

    return (// !! metin varsa true döner 
        <FormField error={meta.touched && !!meta.error}>
            <input {...field} {...props} />
            {/* Dikkat süslü içinde jsx yazmak için normal parantez açılır */}
            {meta.touched && !!meta.error ? (
                <Label pointing basic color='red' content={meta.error}>{meta.error} </Label>

            ):null}
        </FormField>
    )
}
