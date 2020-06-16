import { Component, OnInit } from '@angular/core';
import {AuthSPAService} from '../../../services/auth/auth-spa.service';
import {RunnerService} from '../../../services/runner.service';
import {LoginProfileService} from '../../../services/auth/login-profile.service';
import {IRunner} from '../../../model/IRunner';

@Component({
  selector: 'app-team-home',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: IRunner;
  constructor(private runnerService: RunnerService, public loginProfile: LoginProfileService) { }

  ngOnInit(): void {
    this.loginProfile.getProfile().subscribe(
      data => this.profile = data,
      error => console.log(error)
    );
  }

}

