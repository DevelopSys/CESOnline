import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NuevoComponent } from './component/nuevo/nuevo.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NuevoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'inicio';
}
