import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/clases';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  modulo = inject(HttpClient);

  constructor(private http: HttpClient) {}

  getPosts(): Observable<any> {
    let url = 'https://dummyjson.com/posts/';
    return this.modulo.get(url);
  }
}
