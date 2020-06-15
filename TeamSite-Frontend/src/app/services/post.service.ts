import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) {}

  getPosts() {
    return this.httpClient.get('/server/post');
  }

  getPost(id: number){
    return this.httpClient.get('/server/post/' + id);
  }

  createPostAdd(post) {
    return this.httpClient.post(
      '/server/post',
      JSON.stringify(post),
      {headers : new HttpHeaders({'Content-Type': 'application/json'})}
    );
  }

}
