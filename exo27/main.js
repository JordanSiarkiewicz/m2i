const urlPokemon = "https://pokeapi.co/api/v2/pokemon/";

const searchPokemon = document.querySelector("#pokemon-search");
const pokemonName = document.querySelector("#pokemon-name");
const pokemonWeight = document.querySelector("#pokemon-weight");
const pokemonHeight = document.querySelector("#pokemon-height");


const NameDisplayResult = (data) => {
    pokemonName.textContent = `Name:${JSON.stringify(data, null, 2)} `;
};
const WeightDisplayResult = (data) => {
    pokemonWeight.textContent = `Weight:${JSON.stringify(data, null, 2)} `;
};
const HeightDisplayResult = (data) => {
    pokemonHeight.textContent = `Height:${JSON.stringify(data, null, 2)} `;
};

const getPokemon = async () => {
    const pokemonSearchInput = document.querySelector("#search-input").value;
    const input = `${pokemonSearchInput}`;

    if (input) {
        try {
            const response = await fetch(`${urlPokemon}${input}`);
            console.log(response)
            const data = await response.json();
            NameDisplayResult(data.name);
            WeightDisplayResult(data.weight);
            HeightDisplayResult(data.height);
           
        } catch (error) {
            DisplayResult({ error: `Erreur lors de la récupération du post ${input}` });
        }
    }
};

searchPokemon.addEventListener("submit", getPokemon);

