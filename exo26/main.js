import { Contact } from "./class/contact.js";

const submitForm = document.querySelector("#submitForm");

const contactGender = document.querySelector("");
const contactName = document.querySelector("#contact-name");
const contactSurname = document.querySelector("#contact-surname");
const contactBirthdate = document.querySelector("#contact-birthdate");
const contactPhoneNumber = document.querySelector("#contact-phone");
const contactMail = document.querySelector("#contact-mail");

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

    let contact = new Contact("Non-binary",submitName, submitSurname, submitBirthdate, submitPhoneNumber, submitMail)

    contactsList.push(contact);
});