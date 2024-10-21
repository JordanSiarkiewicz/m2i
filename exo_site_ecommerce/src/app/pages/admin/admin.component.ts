import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductcardComponent } from "../../components/productcard/productcard.component";
import { ProductServiceService } from '../../utils/product-service.service';
import { ProductType } from '../../types/product-type.type';


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
  selector: 'app-admin',
  standalone: true,
  imports: [ReactiveFormsModule, ProductcardComponent],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})

export class AdminComponent implements OnInit {

  // product: Product = {
  //   nom: "",
  //   description: "",
  //   marque: "",
  //   prix: 0,
  //   stock: 0,
  //   isAvailable: true
  // }

  productList: ProductType[] = [];

  constructor(private productService: ProductServiceService) {}

  ngOnInit(): void {
    this.productList = this.productService.productList
  }

  addProduct() : void {
    this.productService.addProduct(this.productForm.value)
  }

  productForm: FormGroup = new FormGroup({
    nom: new FormControl("", [Validators.required]),
    description: new FormControl("", [Validators.required]),
    marque: new FormControl("", [Validators.required]),
    prix: new FormControl("", [Validators.required]),
    stock: new FormControl("", [Validators.required]),
    isAvailable: new FormControl("", [Validators.required]),
    img: new FormControl("", [Validators.required])
  })

  // onSubmit(): void {
  //   console.log(this.productForm.value);
  //   console.log(typeof(this.productForm.value.nom))
  //   this.productList.push(this.productForm.value);
  //   localStorage.setItem("products", JSON.stringify(this.productList))
  //   this.productForm.reset()
  // }

  deleteProduct(product : ProductType): void {
    const index = this.productList.indexOf(product)
    this.productList.splice(index, 1)
    this.updateStorage()

  }

  updateStorage(){
    localStorage.setItem("products", JSON.stringify(this.productList))
  }

}
