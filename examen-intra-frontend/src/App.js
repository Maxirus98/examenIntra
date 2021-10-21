import logo from "./logo.svg";
import "./App.css";
import { useState, useEffect } from "react";
import axios from "axios";
import NameFormField from "./NameFormField";
import GuessFormField from "./GuessFormField";
import PlayedGames from "./PlayedGames";

const App = () => {
  const [randomNumber, setRandomNumber] = useState(null);
  const [games, setGames] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
  const [form, setForm] = useState({
    name: "",
    guess: null,
  });
  const generateRandomNumber = () => {
    setRandomNumber(parseInt(Math.random() * 6 + 1));
  };

  const saveGame = async () => {
    const { nom, guess } = form;
    let response = await axios({
      method: "POST",
      url: `http://localhost:8080/game/save`,
      data: {
        name: nom,
        userGuess: guess,
        randomNumber: randomNumber,
      },
      responseType: "json",
    });
    console.log("reponse", response);
  };

  const isValid = () => {
    const { nom, guess } = form;
    return nom != "" && guess >= 0 && guess <= 6;
  };

  const tableHeads = [];

  useEffect(() => {
    const getGames = async () => {
      let response = await axios({
        method: "GET",
        url: `http://localhost:8080/game/getAll`,
        responseType: "json",
      });
      console.log("response get", response);
      console.log("games useefeec", games);
    };
    getGames();
  }, [games]);

  const handleFormChange = (event) => {
    setForm((form) => ({
      ...form,
      [event.target.id || event.target.name]: event.target.value,
    }));
  };

  return (
    <div className="App">
      <h1>Examen Intra</h1>
      <p style={{ color: "red" }}>{errorMessage}</p>
      <form action="get">
        <NameFormField handleFormChange={handleFormChange} />
        <br />
        <GuessFormField handleFormChange={handleFormChange} />
        <br />
        <button
          type="button"
          onClick={() => {
            if (isValid()) {
              generateRandomNumber();
              saveGame();
              var tmpGames = games.concat({
                name: form.nom,
                userGuess: form.guess,
                randomNumber: randomNumber,
              });
              setGames(tmpGames);
              console.log("games", games);
              return;
            }
            setErrorMessage(
              "Veuillez remplir correctement les champs avant de générer un nombre."
            );
          }}
        >
          Coup de dé
        </button>
      </form>
      <h1 style={{ color: randomNumber == form.guess ? "green" : "red" }}>
        {randomNumber}
      </h1>
      <PlayedGames games={games} />
    </div>
  );
};

export default App;
