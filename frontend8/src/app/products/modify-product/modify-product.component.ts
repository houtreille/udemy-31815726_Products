import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html'
})
export class ModifyProductComponent implements OnInit {


  productToModify: Product;
  productService: ProductService;

  constructor(activatedRoute : ActivatedRoute, productService: ProductService) {
    this.productService = productService;
    var id: number = +activatedRoute.snapshot.params['id'];
    this.productToModify = productService.getProduct(id);

  }

  ngOnInit(): void {

  }

  modifyProduct(productToModify: Product) {
    this.productService.modifyProduct(productToModify);
  }
}
