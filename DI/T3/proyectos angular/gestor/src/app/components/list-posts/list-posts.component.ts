import { Component, inject } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { CommonModule } from '@angular/common';
import { Post } from '../../model/post';

@Component({
  selector: 'app-list-posts',
  imports: [CommonModule],
  templateUrl: './list-posts.component.html',
  styleUrl: './list-posts.component.css',
})
export class ListPostsComponent {
  posts: Post[] = [];

  constructor(private api: ApiService) {
    /* api
      .getAllPosts()
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        this.posts = data.posts;
        console.log(this.posts);
      }); */
    // console.log(api.getAllPosts());
    this.api.getAllPosts().then((data) => {
      this.posts = data.posts;
    });
  }
}
