import { Dog } from "./class/dog.js";

const dogSubmit = document.querySelector("#btn-submit");
const dogSelect = document.querySelector("#dog-select");
const dogSelectOutput = document.querySelector("#selectOutput");

const dogName = document.querySelector("#dog-name");
const dogBreed = document.querySelector("#dog-breed");
const dogAge = document.querySelector("#dog-age");

let dogList = Array();

let submitName;
let submitBreed;
let submitAge;

function updateList(){
    dogSelect.innerHTML = '<option value="0">Sélectionnez un chien</option>';

    for (let i=0; i < dogList.length; i++){
        const dog = dogList[i];
        dogSelect.innerHTML += `<option value="${i + 1}">${dog.name}</option>`;
    }
}

function showDogInfo(){
    const selectedDog = dogList[this.value - 1]
    dogSelectOutput.textContent = `id : ${this.value}, name : ${selectedDog.name}, breed : ${selectedDog.breed}, age : ${selectedDog.age}`
}

dogSubmit.addEventListener("click",(e) => {

    e.preventDefault();

    submitName = dogName.value;
    submitBreed = dogBreed.value;
    submitAge = dogAge.value;

    let dog = new Dog(submitName,submitBreed,submitAge);
    console.log(`${dog.name}, ${dog.breed}, ${dog.age}`);

    dogList.push(dog);
    updateList();
});

dogSelect.addEventListener("change",showDogInfo);