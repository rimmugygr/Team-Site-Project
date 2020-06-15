import { Component, OnInit } from '@angular/core';
import {RunnerService} from '../../../services/runner.service';
import {ActivatedRoute} from '@angular/router';
import {IRunner} from '../../../model/IRunner';
import {IRunnerShow} from '../../../model/IRunnerShow';

@Component({
  selector: 'app-team-view-member',
  templateUrl: './member-view.component.html',
  styleUrls: ['./member-view.component.css']
})
export class MemberViewComponent implements OnInit {
  public runnerShow: IRunnerShow;

  constructor(private runnerService: RunnerService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getRunnerShow(this.activatedRoute.snapshot.params.id);
  }

  getRunnerShow(id: number) {
    this.runnerService.getRunnerShow(id).subscribe(
      data => {
        this.runnerShow = (data as IRunnerShow);
      },
      error => console.error(error),
      () => console.log('load runner show ' + this.runnerShow.id)
    );
  }
}
