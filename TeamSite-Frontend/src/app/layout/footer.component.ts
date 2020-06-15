import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `
    <footer id="footer" class="footer mt-auto py-3">
      <div class="container">
        <span class="text-muted">

            <ng-container appAddTarget="footer"></ng-container>

        </span>
      </div>
    </footer>`

})
export class FooterComponent {

}
