import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html'
})
export class ModifyProductComponent implements OnInit {


  productToModify: Product;
  productService: ProductService;
  router : Router;

  constructor(activatedRoute : ActivatedRoute,
              productService: ProductService,
              router : Router) {
    this.productService = productService;
    this.router = router;
    var id: number = +activatedRoute.snapshot.params['id'];
    this.productToModify = productService.getProduct(id);

  }

  ngOnInit(): void {

  }

  modifyProduct(productToModify: Product) {
    this.productService.modifyProduct(productToModify);
    this.router.navigate(["/products/list-product"]);
  }
}
