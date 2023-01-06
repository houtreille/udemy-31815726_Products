import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public clicks=0;
  title = 'frontend8 '+ this.clicks;


  public clicked()
  {
    this.clicks++
    document.location.href = '/products';
  }


}
