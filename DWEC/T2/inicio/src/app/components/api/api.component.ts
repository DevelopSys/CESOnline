import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { Post } from '../../model/clases';

@Component({
  selector: 'app-api',
  standalone: false,
  templateUrl: './api.component.html',
  styleUrl: './api.component.css',
})
export class ApiComponent {
  posts?: Post[] = [];
  constructor(private servicio: ApiService) {
    this.servicio.getPosts().subscribe((data) => {
      console.log(data);
      this.posts = data.posts;
    });
  }
}
