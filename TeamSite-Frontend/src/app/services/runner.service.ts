import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpRequest} from '@angular/common/http';

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
}
