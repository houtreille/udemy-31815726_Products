import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  messageConfirmation!: string;
  newProduct = new Product();
  newIdCat!: number;
  categories !:Category[];

  constructor(private productService: ProductService,
              private router: Router) {
    this.categories = productService.listCategories();
    this.router = router;
  }

  ngOnInit(): void {
  }

  addProduct(product: Product){
    var category = this.productService.getCategory(this.newIdCat);
    product.category = category;
    this.productService.addProduct(product);
    this.messageConfirmation = "Product "+product.productName+" has been successful added with " + this.newIdCat;
    this.router.navigate(["/products/list-product"]);
  }

}
