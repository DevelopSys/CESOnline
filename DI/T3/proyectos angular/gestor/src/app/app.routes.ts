import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { FormComponent } from './components/form/form.component';
import { ListComponent } from './components/list/list.component';
import { FindComponent } from './components/find/find.component';
import { ListPostsComponent } from './components/list-posts/list-posts.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'form', component: FormComponent },
  { path: 'list', component: ListComponent },
  { path: 'find', component: FindComponent },
  { path: 'posts', component: ListPostsComponent },
  { path: '**', redirectTo: 'home' },
];
