import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {IStart} from '../model/IStart';

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

  addRaceStart(start: IStart, runnerId: number, raceId: number) {
    const data = {description: start.description, status: start.status};
    return this.httpClient.post(`/server/race/start/` + runnerId + `/` + raceId, data);
  }

  editRaceStart(start: IStart, runnerId: number, raceId: number) {
    const data = {description: start.description, status: start.status};
    return this.httpClient.patch(`/server/race/start/` + runnerId + `/` + raceId, data);
  }

  createRaceRegistration(race) {
    return this.httpClient.post(
      '/server/race',
      JSON.stringify(race),
      {headers : new HttpHeaders({'Content-Type': 'application/json'})});
  }
}
