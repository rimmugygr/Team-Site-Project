import { Injectable } from '@angular/core';
import {IRunner} from '../components/IRunner';
import {AuthSPAService} from './auth-spa.service';
import {RunnerService} from './runner.service';
import {Observable, Subscription} from 'rxjs';
import {Profile} from './profile';

@Injectable({
  providedIn: 'root'
})
export class LoginProfileService {
  profileInit = false;
  profile = new Profile();

  constructor(private auth: AuthSPAService, private runnerService: RunnerService) { }

  public getProfile(): Observable<any> {
    this.initProfile();
    let profile: Observable<any>;
    this.auth.userProfile$.subscribe(
      data =>
      {
         profile = this.runnerService.getRunner(data.sub.replace(`facebook|`, ''));
      }
    );
    return profile;
  }

  public initProfile() {
    let profileId: string;
    if (this.profileInit === false) {
      this.auth.userProfile$.subscribe(data => {
        profileId = data.sub.replace(`facebook|`, '');
        this.runnerService.getRunner(profileId).subscribe(
          data => {
            this.profile = (data as Profile);
          },
          error => console.error(error),
          () => {
            console.log('load profile ' + this.profile.id);
            if (this.profile.surname === 'DEFAULT' && this.profile.firstName === 'DEFAULT' && this.profile.id === null) {
              this.newMember(profileId);
            }
            this.profileInit = true;
          }
        );
      });
    }
  }

  private newMember(profileId) {
    this.auth.userProfile$.subscribe(
      data => {
        this.profile.firstName = data.given_name;
        this.profile.secondName = data.family_name;
        this.profile.surname = data.nickname;
        this.profile.picture = data.picture;
        this.profile.id = profileId;
        this.runnerService.createRunnerRegistration(this.profile).subscribe(
          () => {
            return true;
          },
          error => {
            console.log(error);
          }
        );
      },
      error => console.error(error)
    );
  }
}
