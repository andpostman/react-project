import React from 'react'

export default function ErrorMessage(props){
    return (
        <p className="error-message">{ props.error }</p>
    )
}