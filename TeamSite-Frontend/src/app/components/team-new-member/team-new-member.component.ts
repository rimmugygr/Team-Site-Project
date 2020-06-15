import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../services/runner.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-team-new-member',
  templateUrl: './team-new-member.component.html',
  styleUrls: ['./team-new-member.component.css']
})
export class TeamNewMemberComponent implements OnInit {
  gender: string[] = ['male', 'female'];
  newMemberForm: FormGroup;
  validMessage = '';

  constructor(private runnerService: RunnerService) { }

  ngOnInit(): void {
    this.newMemberForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      secondName: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      birdDate: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      contact: new FormControl()
      });
  }

  submitRegistration() {
    if (this.newMemberForm.valid) {
      this.validMessage = 'Added new member of team';
      this.runnerService.createRunnerRegistration(this.newMemberForm.value).subscribe(
        data => {
          this.newMemberForm.reset();
          return true;
        },
        error => {
          console.log(error);
        }
      );
    } else {
        this.validMessage = 'Pleas fill form !';
    }
  }
}
