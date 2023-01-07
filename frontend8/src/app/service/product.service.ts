import { Injectable } from '@angular/core';
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[];

  constructor() {
    this.products = [
      {productId : 1, productName : "ASUS", productPrice : 1000, creationDate : new Date("01/15/2022")},
      {productId : 2, productName : "IPad Pro", productPrice : 2000, creationDate : new Date("06/15/2022")},
      {productId : 3, productName : "Drone DJI3", productPrice : 600, creationDate : new Date("03/15/2022")}
    ]
  }

  listProducts():Product[]{
    return this.products;
  }

  addProduct(productToAdd : Product) {
    this.products.push(productToAdd);
  }

  modidyProduct(productToModify : Product) {
    //this.products.
    console.log("Modify " + productToModify.productName);
    document.location.href = '/products/add-product/'+productToModify.productId;
  }

   deleteProduct(productToDelete : Product) : string {

    const index = this.products.indexOf(productToDelete);

    this.products.splice(index, 1);

    return productToDelete.productName + " has been successfully deleted";
  }


}



