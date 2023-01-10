import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category.model";

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html'
})
export class ModifyProductComponent implements OnInit {


  productToModify: Product;
  categoryOfProductToModify: Category = new Category;

  productService: ProductService;
  categories: Category[] = [];
  router : Router;


  constructor(activatedRoute : ActivatedRoute,
              productService: ProductService,
              router : Router) {
    this.productService = productService;
    this.router = router;
    var id: number = +activatedRoute.snapshot.params['id'];
    this.productToModify = productService.getProduct(id);

    if(this.productToModify.category != null) {
      this.categoryOfProductToModify = productService.getCategory(this.productToModify.category.idCategory)
    }

  }

  ngOnInit(): void {
    this.categories = this.productService.listCategories();
  }

  modifyProduct(productToModify: Product) {
    this.productService.modifyProduct(productToModify);
    this.router.navigate(["/products/list-product"]);
  }
}
