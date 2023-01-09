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

  modifyProduct(productToModify : Product) {
     this.deleteProduct(productToModify);
     this.addProduct(productToModify);
  }

   deleteProduct(productToDelete : Product) : string {

    const index = this.products.indexOf(productToDelete);

    this.products.splice(index, 1);

    return productToDelete.productName + " has been successfully deleted";
  }

  getProduct(id : number) : Product {

    var productToFind: Product = new Product();

    for (let i = 0; i < this.products.length; i++) {
      if(this.products[i].productId == id) {
         productToFind = this.products[i];
      }
    }

    return  productToFind;
  }


}



