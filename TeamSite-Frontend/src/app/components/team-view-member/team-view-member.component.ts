import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../services/runner.service';
import {ActivatedRoute} from '@angular/router';
import {IRunner} from '../IRunner';

@Component({
  selector: 'app-team-view-member',
  templateUrl: './team-view-member.component.html',
  styleUrls: ['./team-view-member.component.css']
})
export class TeamViewMemberComponent implements OnInit {
  public runner: IRunner;

  constructor(private runnerService: RunnerService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getRunner(this.activatedRoute.snapshot.params.id);
  }

  getRunner(id: number) {
    this.runnerService.getRunner(id).subscribe(
      data => {
        this.runner = (data as IRunner);
      },
      error => console.error(error),
      () => console.log('load runner ' + this.runner.id)
    );
  }
}
