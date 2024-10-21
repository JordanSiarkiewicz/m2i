import { Injectable } from '@angular/core';
import { ProductType } from '../types/product-type.type';

@Injectable({
  providedIn: 'root'
})

export class ProductServiceService {
  productList: ProductType[] = []

  basketList: ProductType[] = []

  constructor() {
    const stored = localStorage.getItem('products')
    if(stored) {
      this.productList = JSON.parse(stored)
    }

    const storedbasket = localStorage.getItem('basket')
    if(storedbasket) {
      this.basketList = JSON.parse(storedbasket)
    }
   }

   addProduct(product: ProductType){
    this.productList.push(product)
    localStorage.setItem("products", JSON.stringify(this.productList))
   }

   addProductToBasket(product: ProductType){
    this.basketList.push(product)
    localStorage.setItem("basket", JSON.stringify(this.basketList))
   }
   
}
