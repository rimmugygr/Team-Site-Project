import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {IRunner} from '../../../model/IRunner';
import {RaceService} from '../../../services/race.service';
import {IRace} from '../../../model/IRace';
import {AuthSPAService} from '../../../services/auth/auth-spa.service';
import {LoginProfileService} from '../../../services/auth/login-profile.service';
import {IProfile} from '../../../model/IProfile';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-team-race',
  templateUrl: './race.component.html',
  styleUrls: ['./race.component.css']
})
export class RaceComponent implements OnInit {
  public runners: IRunner[];
  public races: IRace[];
  public profileId: number = null;
  raceStartForm: FormGroup;
  public statusEnum = [ `GoingTo`, `Interested`, `NotGoingTo`];
  enableForm: number = null;

  constructor(
    private runnerService: RunnerService,
    private raceService: RaceService,
    public auth: AuthSPAService,
    private profileService: LoginProfileService
  ) { }

  ngOnInit(): void {
    this.getRunners();
    this.getRaces();
    this.getProfileId();
  }

  private getProfileId() {
    this.profileService.getProfile().subscribe(
      data => this.profileId = data.id,
      error => console.log(error)
    );
  }

  getRunners() {
    this.runnerService.getRunners().subscribe(
      data => { this.runners = (data as IRunner[]); },
      err => console.error(err),
      () => console.log('runners loaded')
    );
  }
  getRaces() {
    this.raceService.getRaces().subscribe(
      data => { this.races = (data as IRace[]); },
      err => console.error(err),
      () => console.log('races loaded')
    );
  }

  isUserInRace(race: IRace): boolean {
    return race.raceStarts.map(x => x.idRunner).indexOf(this.profileId) === -1;
  }

  createFormStart(raceId: number) {
    this.raceStartForm = new FormGroup({
      description: new FormControl(''),
      status: new FormControl('', Validators.required)
    });
    this.enableForm = raceId;
  }

  submitFormRaceStart(raceId: number) {
    this.raceService.addRaceStart(this.raceStartForm.value, this.profileId, raceId).subscribe(
      null,
      error => console.log(error),
      () => console.log(`success add user start`)
    );
  }

  disableForm() {
    this.enableForm = null;
  }
}
