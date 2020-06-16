import {AfterViewInit, Component, ElementRef, TemplateRef, ViewChild, ViewContainerRef, ViewRef} from '@angular/core';
import {AuthSPAService} from './services/auth/auth-spa.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  constructor(public auth: AuthSPAService) {
  }
  ngAfterViewInit(): void {
  }
}
