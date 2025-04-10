import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { FormComponent } from './components/form/form.component';
import { CommonModule } from '@angular/common';
import { UsuariosService } from './services/usuarios.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [UsuariosService],
})
export class AppComponent {
  title = 'Borja';

  constructor(private navegador: Router) {}
  navegar(ruta: string) {
    this.navegador.navigate([ruta]);
  }
}
