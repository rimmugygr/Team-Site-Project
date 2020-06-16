import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {RaceService} from '../../../services/race.service';

@Component({
  selector: 'app-team-race-add',
  templateUrl: './race-add.component.html',
  styleUrls: ['./race-add.component.css']
})
export class RaceAddComponent implements OnInit {
  raceType: string[] = ['asphalt', 'OCR', 'trial', 'mountain', 'survival'];
  newRaceForm: FormGroup;
  validMessage = '';

  constructor(private raceService: RaceService) { }

  ngOnInit(): void {
    this.newRaceForm = new FormGroup({
      name: new FormControl('', Validators.required),
      localization: new FormControl('', Validators.required),
      date: new FormControl('', Validators.required),
      type: new FormControl('', Validators.required),
      distance: new FormControl('', Validators.required),
      contact: new FormControl()
    });
  }

  submitRegistration() {
    if (this.newRaceForm.valid) {
      this.validMessage = 'Added new race';
      this.raceService.createRaceRegistration(this.newRaceForm.value).subscribe(
        data => {
          this.newRaceForm.reset();
          return true;
        },
        error => {
          Observable.throw(error);
        }
      );
    } else {
      this.validMessage = 'Pleas fill form !';
    }
  }
}
