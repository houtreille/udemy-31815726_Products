import {Category} from "./category.model";

export class Product {
  productId?: number;
  productName?: string;
  productPrice?: number;
  creationDate?: Date;
  category: Category = new Category();
}
