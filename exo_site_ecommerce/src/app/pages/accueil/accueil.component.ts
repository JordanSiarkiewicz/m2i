import { Component } from '@angular/core';
import { AdminComponent } from '../admin/admin.component';
import { ProductcardComponent } from '../../components/productcard/productcard.component';
import { ProductServiceService } from '../../utils/product-service.service';
import { ProductType } from '../../types/product-type.type';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [ProductcardComponent, AdminComponent],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})

export class AccueilComponent {
  productList: ProductType[] = [];

  constructor(private productService: ProductServiceService) {}

  ngOnInit(): void {
    this.productList = this.productService.productList
  }

  addToBasket(product : ProductType): void {
    this.productService.addProductToBasket(product)
    console.log(this.productService.basketList)
  }
}
