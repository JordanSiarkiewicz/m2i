import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

class Book {
  title: string;
  author: string;
  isRead: boolean;
  img: string

  constructor(title: string, author: string, isRead: boolean, img: string){
    this.title = title;
    this.author = author;
    this.isRead = isRead
    this.img = img
  }
}

@Component({
  selector: 'app-library',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './library.component.html',
  styleUrl: './library.component.css'
})

export class LibraryComponent {

  book : Book = {
    title: "",
    author: "",
    isRead: false,
    img: ""
  }

  books : Book[]= [
    {
      title: "Fondation",
      author: "Isaac Asimov",
      isRead: false,
      img: "https://media.senscritique.com/media/000016623850/300/fondation_le_cycle_de_fondation_tome_1.png"
    },

    {
      title: "Rendez-vous avec Rama",
      author: "Arthur C. Clark",
      isRead: false,
      img: "https://media.senscritique.com/media/000000074085/300/rendez_vous_avec_rama_rama_tome_1.jpg"
    },

    {
      title: "Conan",
      author: "Robert E. Howard",
      isRead: false,
      img: "data:image/jpeg;base64,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"
    },

    {
      title: "L'appel de Cthulhu",
      author: "H. P. Lovecraft",
      isRead: false,
      img: "https://images.journaux.fr/articles/full/M1077-14.jpg"
    },

    {
      title: "Le meilleur des mondes",
      author: "Aldous Huxley",
      isRead: false,
      img: "https://media.senscritique.com/media/000009127977/300/le_meilleur_des_mondes.jpg"
    },

    {
      title: "Le cycle des robots",
      author: "Isaac Asimov",
      isRead: false,
      img: "https://media.senscritique.com/media/000000138934/300/un_defile_de_robots_le_cycle_des_robots_tome_2.jpg"
    },

    {
      title: "Le problème à trois corps",
      author: "Liu Cixin",
      isRead: false,
      img: "https://media.senscritique.com/media/000022001413/300/le_probleme_a_trois_corps.png"
    },

    {
      title: "Hyperion",
      author: "Dan Simmons",
      isRead: false,
      img: "https://media.senscritique.com/media/000007607303/300/hyperion.jpg"
    },

    {
      title: "Dune",
      author: "Frank Herbert",
      isRead: false,
      img: "https://media.senscritique.com/media/000020354712/300/dune.jpg"
    },

    {
      title: "1984",
      author: "George Orwell",
      isRead: false,
      img: "https://media.senscritique.com/media/000004731893/300/1984.jpg"
    },

    {
      title: "La nuit des temps",
      author: "René Barjavel",
      isRead: false,
      img: "https://media.senscritique.com/media/000016623783/300/la_nuit_des_temps.jpg"
    },

    {
      title: "La horde du contrevent",
      author: "Alain Damasio",
      isRead: false,
      img: "https://media.senscritique.com/media/000017346551/300/la_horde_du_contrevent.jpg"
    },

    {
      title: "Le guide du voyageur galactique",
      author: "Douglas Adams",
      isRead: false,
      img: "https://media.senscritique.com/media/000009003337/300/le_guide_du_voyageur_galactique_h2g2_tome_1.jpg"
    },
    
  ]

  read(books: Book){
    books.isRead = !books.isRead
  }
  
  isSubmitted : boolean = false

  submitBook() : void {
    this.isSubmitted = true
    this.books.push(this.book);
    this.resetForm()
  }

  resetForm() {
    this.book = {
      title: "",
      author: "",
      isRead: false,
      img: ""
    }
  }

}
