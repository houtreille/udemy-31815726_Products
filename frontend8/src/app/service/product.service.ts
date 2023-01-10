import { Injectable } from '@angular/core';
import {Product} from "../model/product.model";
import {Category} from "../model/category.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  products: Product[];
  categories: Category[];

  constructor() {

    this.categories = [
      {idCategory : 1, categoryName : "Category1", description : "Categorie 1 Descriptiom"},
      {idCategory : 2, categoryName : "Category2", description : "Categorie 2 Descriptiom"}
    ]

    this.products = [
      {productId : 1, productName : "ASUS", productPrice : 1000, creationDate : new Date("01/15/2022")      , category : this.categories[0]},
      {productId : 2, productName : "IPad Pro", productPrice : 2000, creationDate : new Date("06/15/2022")  , category : this.categories[0]},
      {productId : 3, productName : "Drone DJI3", productPrice : 600, creationDate : new Date("03/15/2022") , category : this.categories[1]}
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

  listCategories():Category[]{
    return this.categories;
  }

  getCategory(id : number) : Category {
    var categoryFind: Category = new Category();

    for (let i = 0; i < this.categories.length; i++) {
      if(this.categories[i].idCategory == id) {
        categoryFind = this.categories[i];
      }
    }
    return  categoryFind;
  }


}



