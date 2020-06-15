import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {IRunner} from '../../../model/IRunner';
import {RaceService} from '../../../services/race.service';
import {IRace} from '../../../model/IRace';
import {IStart} from '../../../model/IStart';
import {race} from 'rxjs';
import {AuthSPAService} from '../../../services/auth-spa.service';

@Component({
  selector: 'app-team-race',
  templateUrl: './team-race.component.html',
  styleUrls: ['./team-race.component.css']
})
export class TeamRaceComponent implements OnInit {
  public runners: IRunner[];
  public races: IRace[];

  constructor(
    private runnerService: RunnerService,
    private raceService: RaceService,
    public auth: AuthSPAService
  ) { }

  ngOnInit(): void {
    this.getRunners();
    this.getRaces();
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
  setSurname() {
    for (let race of this.races)
    {
      for (let raceStart of race.raceStarts) {
        raceStart.runnerSurname = this.runners.find(runner => runner.id === raceStart.runnerIdStart).surname;
      }
    }
  }
}
