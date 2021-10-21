import React from "react";

const PlayedGames = ({ games }) => {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        textAlign: "center",
      }}
    >
      <table style={{ border: "1px solid", textAlign: "center" }}>
        <thead>
          <tr>
            <th>Nom</th>
            <th>Guess Utilisateur</th>
            <th>Numéro Random</th>
          </tr>
        </thead>
        <tbody>
          {games.map((game, key) => {
            console.log("game1", game);
            console.log("name", game.name);
            return (
              <tr key={key}>
                <td>{game.name}</td>
                <td>{game.userGuess}</td>
                <td>{game.randomNumber}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default PlayedGames;
