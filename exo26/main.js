import { Contact } from "./class/contact.js";

const submitForm = document.querySelector("#submitForm");
const contactsTable = document.querySelector("#result");

submitForm.addEventListener("click",(e) => {
    e.preventDefault();

    const contactGender =  document.querySelector("input[name='titre']:checked").value;
    const contactName = document.querySelector("#contact-name").value;
    const contactSurname = document.querySelector("#contact-surname").value;
    const contactBirthdate = document.querySelector("#contact-birthdate").value;
    const contactPhoneNumber = document.querySelector("#contact-phone").value;
    const contactMail = document.querySelector("#contact-mail").value;

    let contact = new Contact(contactGender,contactName, contactSurname, contactBirthdate, contactPhoneNumber, contactMail)

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

