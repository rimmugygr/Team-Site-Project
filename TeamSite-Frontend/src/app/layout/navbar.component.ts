import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  template: `
  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom d-flex justify-content-center">
    <form class="form-inline">
        <ng-container appAddTarget="header"></ng-container>
    </form>
  </nav>
  `
})
export class NavbarComponent {

}
