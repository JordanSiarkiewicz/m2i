import { Component } from '@angular/core';
import { ProductType } from '../../types/product-type.type';
import { ProductServiceService } from '../../utils/product-service.service';
import { ProductcardComponent } from '../../components/productcard/productcard.component';

@Component({
  selector: 'app-panier',
  standalone: true,
  imports: [ProductcardComponent],
  templateUrl: './panier.component.html',
  styleUrl: './panier.component.css'
})
export class PanierComponent {

  productList: ProductType[] = [];

  constructor(private productService: ProductServiceService) {}

  ngOnInit(): void {
    this.productList = this.productService.basketList
  }

  deleteProduct(product : ProductType): void {
    const index = this.productList.indexOf(product)
    this.productList.splice(index, 1)
    this.updateStorage()
  }

  updateStorage(){
    localStorage.setItem("basket", JSON.stringify(this.productList))
  }

}
