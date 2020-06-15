import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../services/runner.service';
import {IRunner} from '../IRunner';

@Component({
  selector: 'app-team-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent implements OnInit {
  public runners: IRunner[];

  constructor(private runnerService: RunnerService) { }

  ngOnInit(): void {
    this.getMember();
  }

  getMember() {
    this.runnerService.getRunners().subscribe(
      data => { this.runners = (data as IRunner[]); },
      err => console.error(err),
      () => console.log('runners loaded')
    );
  }

}
