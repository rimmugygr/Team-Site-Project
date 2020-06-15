import {Component, OnInit} from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginProfileService} from '../../../services/login-profile.service';
import {IProfile} from '../../../model/IProfile';
import {IRunnerShow} from '../../../model/IRunnerShow';

@Component({
  selector: 'app-team-new-member',
  templateUrl: './team-profile-edit.component.html',
  styleUrls: ['./team-profile-edit.component.css']
})
export class TeamProfileEditComponent implements OnInit {
  public gender: string[] = ['male', 'female'];
  public editProfileForm: FormGroup = null;
  public validMessage = '';
  editRunnerProfile: IProfile;

  constructor(private runnerService: RunnerService,
              private loginProfileService: LoginProfileService) { }

  ngOnInit(): void {
    this.loginProfileService.getProfile().subscribe(
      data => this.editRunnerProfile = data,
      error => console.log(error),
      () => this.createFormEditProfile()
    );
  }

  private createFormEditProfile() {
    this.editProfileForm = new FormGroup({
      id: new FormControl(this.editRunnerProfile.id),
      firstName: new FormControl(this.editRunnerProfile.firstName, Validators.pattern(`[a-z,A-Z]*`)),
      secondName: new FormControl(this.editRunnerProfile.secondName, Validators.pattern(`[a-z,A-Z]*`)),
      surname: new FormControl(this.editRunnerProfile.surname),
      birdDate: new FormControl(this.editRunnerProfile.birdDate, Validators.pattern(`(^[0-9]{2}-[0-9]{2}-[0-9]{4}$){0,1}`)),
      description: new FormControl(this.editRunnerProfile.runnerShow.description),
      email: new FormControl(this.editRunnerProfile.email, Validators.pattern(`(^[a-z,A-Z,0-9]+@[a-z,A-Z,0-9,\.]+$){0,1}`)),
      gender: new FormControl()
    });
  }

  submitEditProfile() {
    if (this.editProfileForm.valid) {
      const profileChange: IProfile = this.editProfileForm.value;
      profileChange.runnerShow = {
        id: this.editRunnerProfile.runnerShow.id,
        description: this.editProfileForm.value.description,
        surname: this.editProfileForm.value.surname,
        firstName: this.editProfileForm.value.firstName,
        secondName: this.editProfileForm.value.secondName,
        picture: this.editProfileForm.value.picture
      };
      this.runnerService.editProfile(profileChange).subscribe(
        null ,
        error => {
          console.log(error);
        },
        () => {
          console.log('Success edit profile');
          this.validMessage = `Profile Edited`;
        }
      );
    } else {
        this.validMessage = 'Pleas fill form correct !';
    }
  }
}
