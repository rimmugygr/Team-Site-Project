import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {IRunnerShow} from '../../../model/IRunnerShow';

@Component({
  selector: 'app-team-members',
  templateUrl: './members-view.component.html',
  styleUrls: ['./members-view.component.css']
})
export class MembersViewComponent implements OnInit {
  public runnersShow: IRunnerShow[];

  constructor(private runnerService: RunnerService) { }

  ngOnInit(): void {
    this.getMember();
  }

  getMember() {
    this.runnerService.getRunnersShow().subscribe(
      data => { this.runnersShow = (data as IRunnerShow[]); },
      err => console.error(err),
      () => console.log('runners show loaded')
    );
  }

}
