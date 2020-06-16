import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {PostService} from '../../../services/post.service';
import {Router, RouterLink} from '@angular/router';

@Component({
  selector: 'app-team-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit {
  postForm: FormGroup;
  validMessage = '';

  constructor(private postService: PostService, private router: Router) { }

  ngOnInit(): void {
    this.postForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      contact: new FormControl()
    });
  }

  submitPost() {
    if (this.postForm.valid) {
      this.validMessage = 'Add post';
      this.postService.createPostAdd(this.postForm.value).subscribe(
        data => {
          this.postForm.reset();
          return true;
        },
        error => {
          Observable.throw(error);
        }
      );
      this.router.navigate(['posts']);
    } else {
      this.validMessage = 'Pleas fill form !';
    }
  }
}
