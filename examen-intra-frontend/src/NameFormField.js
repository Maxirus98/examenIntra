import React from "react";
import { useState, useEffect } from "react";
const NameFormField = ({ handleFormChange }) => {
  const [nom, setNom] = useState("");

  const handleNameChange = (event) => {
    setNom(event.target.value);
    handleFormChange(event);
  };
  return (
    <>
      <label htmlFor="nom">Votre Nom </label>
      <input
        type="text"
        name="nom"
        id="nom"
        onChangeCapture={handleNameChange}
      />
    </>
  );
};

export default NameFormField;
