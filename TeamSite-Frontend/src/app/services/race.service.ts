import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RaceService {

  constructor(private httpClient: HttpClient) {}

  getRaces() {
    return this.httpClient.get('/server/race');
  }

  getStarts() {
    return this.httpClient.get('/server/race/start');
  }

  createRaceRegistration(race) {
    return this.httpClient.post(
      '/server/race',
      JSON.stringify(race),
      {headers : new HttpHeaders({'Content-Type': 'application/json'})});
  }
}
