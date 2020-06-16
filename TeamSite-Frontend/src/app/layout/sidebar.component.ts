import { Component, OnInit } from '@angular/core';
import {AuthSPAService} from '../services/auth/auth-spa.service';

@Component({
  selector: 'app-sidebar',
  template: `
  <div class="bg-light border-right" id="sidebar-wrapper">
    <div class="sidebar-heading">Menu:</div>
    <div class="list-group list-group-flush">
      <a routerLink="" class="list-group-item list-group-item-action bg-light">Home</a>
      <a routerLink="members" class="list-group-item list-group-item-action bg-light">Members</a>
      <a routerLink="posts" class="list-group-item list-group-item-action bg-light">Posts</a>
      <a routerLink="team" class="list-group-item list-group-item-action bg-light" *ngIf="auth.loggedIn">Profile</a>
      <a routerLink="races" class="list-group-item list-group-item-action bg-light" >Races</a>

    </div>
  </div>
  `
})
export class SidebarComponent {

  constructor(public auth: AuthSPAService) {
  }

}
