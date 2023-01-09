import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProductComponent} from "./products/list-product/list-product.component";
import {AddProductComponent} from "./products/add-product/add-product.component";
import {ModifyProductComponent} from "./products/modify-product/modify-product.component";

const routes: Routes = [
  {path : "products/list-product" ,     component : ListProductComponent},
  {path : "products/add-product" ,      component : AddProductComponent},
  {path : "products/modify-product/:id" ,  component : ModifyProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
