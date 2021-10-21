import React from "react";
import { useState, useEffect } from "react";
const GuessFormField = ({ handleFormChange }) => {
  const [guess, setGuess] = useState(null);
  const handleGuessChange = (event) => {
    setGuess(event.target.value);
    handleFormChange(event);
  };
  return (
    <>
      <label htmlFor="guess">Votre Guess </label>
      <input
        type="number"
        name="guess"
        id="guess"
        onChangeCapture={handleGuessChange}
      />
    </>
  );
};

export default GuessFormField;
