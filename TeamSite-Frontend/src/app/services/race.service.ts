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
//    return this.httpClient.get('/server/race', {headers : new HttpHeaders({'authorization': 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ii13aEJ3WHRiRkc2eHRxanA3eERXUyJ9.eyJpc3MiOiJodHRwczovL3RlYW1zaXRlLmV1LmF1dGgwLmNvbS8iLCJzdWIiOiJpZFU0QU5HN2ZpbEhBVVJxTGd3MW45aDI4bmoyZTBtVEBjbGllbnRzIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwLyIsImlhdCI6MTU5MzU0MDU4NSwiZXhwIjoxNTkzNjI2OTg1LCJhenAiOiJpZFU0QU5HN2ZpbEhBVVJxTGd3MW45aDI4bmoyZTBtVCIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyJ9.UrhUzzOgMQdWr6fw1JfFF0AVlB8tZu8HVcCA7CZzBdMX7W0JTUMUt3Yhqa-Se1PI4jhoM39ADBByRlytZ_ge1ch4aeef4lXdqsxx5qZJQ0hhpAZ19zjKMix39Ic_ldBgMo57KeRlrUmXbI4ZrXwVl82pBAUxgHKeAG7DP6eJXkAq-KY0C8fQG4NKiTcm8zZMYVZH7wV7euw2ocgtv4Etp8RvXmTWIUEh7PTtHVRaCYC0LvM3ylOsNuB_iBdAaPpZv5VgaInk_c9LOU9itWQqJo3UKbgMuiGFs7kt-_Co4eUxVvsNpMfN4yubov5khCxvcLfQTDWW2ohuZX606a2sjw'})});
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
