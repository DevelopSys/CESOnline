import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // Base URL for the API

  private url = 'https://dummyjson.com/posts';

  constructor() {}

  /* public getAllPosts(): Promise<Response> {
    return fetch(this.url);
  } */

  public async getAllPosts() {
    let response = await fetch(this.url);
    let data = await response.json();
    // console.log(data.posts);
    // return fetch(this.url);
    return data;
  }

  /* public getAllPosts(): Observable<any> {
    // return this.modulo.get(this.url);
  } */
}
