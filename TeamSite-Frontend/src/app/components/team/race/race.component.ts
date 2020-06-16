import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {IRunner} from '../../../model/IRunner';
import {RaceService} from '../../../services/race.service';
import {IRace} from '../../../model/IRace';
import {AuthSPAService} from '../../../services/auth/auth-spa.service';

@Component({
  selector: 'app-team-race',
  templateUrl: './race.component.html',
  styleUrls: ['./race.component.css']
})
export class RaceComponent implements OnInit {
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
}
