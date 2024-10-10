import { Contact } from "./class/contact.js";

const submitForm = document.querySelector("#submitForm");
const contactsTable = document.querySelector("#result");

const contactGender =  document.querySelector('input[name=titre]');
const contactName = document.querySelector("#contact-name");
const contactSurname = document.querySelector("#contact-surname");
const contactBirthdate = document.querySelector("#contact-birthdate");
const contactPhoneNumber = document.querySelector("#contact-phone");
const contactMail = document.querySelector("#contact-mail");

const genderTable =  document.querySelector("#genderTable");
const nameTable = document.querySelector("#nameTable");
const surnameTable = document.querySelector("#surnameTable");
const birthdateTable = document.querySelector("#birthdateTable");
const phoneTable = document.querySelector("#phoneTable");
const mailTable = document.querySelector("#mailTable");

let submitGender, submitName, submitSurname, submitBirthdate, submitPhoneNumber, submitMail;

let contactsList = Array();

submitForm.addEventListener("click",(e) => {
    e.preventDefault();

    submitGender = contactGender.value;
    submitName = contactName.value;
    submitSurname = contactSurname.value;
    submitBirthdate = contactBirthdate.value;
    submitPhoneNumber = contactPhoneNumber.value;
    submitMail = contactMail.value;

    let contact = new Contact(submitGender,submitName, submitSurname, submitBirthdate, submitPhoneNumber, submitMail)

    contactsList.push(contact);
    console.log(contactsList);

    contactsTable.innerHTML += 
    `<tr>
    <th scope="col">${contact.gender}</th>
    <th scope="col">${contact.name}</th>
    <th scope="col">${contact.surname}</th>
    <th scope="col">${contact.birthDate}</th>
    <th scope="col">${contact.phoneNumber}</th>
    <th scope="col">${contact.mail}</th>
    </tr>`
});

