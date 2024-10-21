import { Component, EventEmitter, Input, Output } from '@angular/core';

type Product = {
  nom: string;
  description: string;
  marque: string;
  prix: number;
  stock: number;
  isAvailable: boolean;
  img: string

  // constructor (nom: string, description: string, marque: string, prix: number, stock: number, isAvailable: boolean){
  //   this.nom = nom,
  //   this.description = description,
  //   this.marque = marque,
  //   this.prix = prix,
  //   this.stock = stock,
  //   this.isAvailable = isAvailable
  // }
}

@Component({
  selector: 'app-productcard',
  standalone: true,
  imports: [],
  templateUrl: './productcard.component.html',
  styleUrl: './productcard.component.css'
})
export class ProductcardComponent {

  @Input() product!: Product;

  @Output() deleteEvent = new EventEmitter<Product>()

  deleteProduct() {
    this.deleteEvent.emit(this.product)
  }

}
