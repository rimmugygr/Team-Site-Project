import { Component, OnInit } from '@angular/core';
import {AuthSPAService} from '../../../services/auth-spa.service';
import {RunnerService} from '../../../services/runner.service';
import {LoginProfileService} from '../../../services/login-profile.service';
import {IRunner} from '../../../model/IRunner';

@Component({
  selector: 'app-team-home',
  templateUrl: './team-home.component.html',
  styleUrls: ['./team-home.component.css']
})
export class TeamHomeComponent implements OnInit {
  profile: IRunner;
  constructor(private runnerService: RunnerService, public loginProfile: LoginProfileService) { }

  ngOnInit(): void {
    this.loginProfile.getProfile().subscribe(
      data => this.profile = data,
      error => console.log(error)
    );
  }

}
