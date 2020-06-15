import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpRequest} from '@angular/common/http';
import {IRunner} from '../components/IRunner';

@Injectable({
  providedIn: 'root'
})
export class RunnerService {
  constructor(private httpClient: HttpClient) { }

  getRunners() {
    return this.httpClient.get('/server/runner');
  }

  getRunner(id: number | string){
    return this.httpClient.get('/server/runner/' + id);
  }

  createRunnerRegistration(runner) {
    return this.httpClient.post(
      '/server/runner',
      JSON.stringify(runner),
      {headers : new HttpHeaders({'Content-Type': 'application/json'})});
  }

  editProfile(profileRunner: IRunner) {
    return this.httpClient.patch(`/server/runner`, profileRunner);
  }
}
