import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products : Product[];

  constructor(private productService: ProductService) {
    this.products = productService.listProducts();
  }

  ngOnInit(): void {
  }

  modify(product : Product) {
    this.productService.modidyProduct(product);
  }

  delete(product : Product) {
    this.productService.deleteProduct(product);
  }
}
