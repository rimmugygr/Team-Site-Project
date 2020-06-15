import { Component, OnInit } from '@angular/core';
import {IPost} from '../IPost';
import {PostService} from '../../services/post.service';
import {AuthSPAService} from '../../services/auth-spa.service';

@Component({
  selector: 'app-post-view',
  templateUrl: './post-view.component.html',
  styleUrls: ['./post-view.component.css']
})
export class PostViewComponent implements OnInit {
  public posts: IPost[];

  constructor(private postService: PostService, public auth: AuthSPAService) { }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts() {
    this.postService.getPosts().subscribe(
      data => this.posts = (data as IPost[]),
      error => console.error(error),
      () => console.log('post load')
    );
  }

}
