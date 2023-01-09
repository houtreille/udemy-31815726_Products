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

  feedback: string = "";

  constructor(private productService: ProductService) {
    this.products = productService.listProducts();
  }

  ngOnInit(): void {
  }

  modify(product : Product) {
    this.productService.modifyProduct(product);
  }

  delete(product : Product)  {

    if(confirm("Are you sure you want to delete " + product.productName)) {
      this.feedback = this.productService.deleteProduct(product);
    }
  }
}
