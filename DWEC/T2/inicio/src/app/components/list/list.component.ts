import { Component } from '@angular/core';
import { Usuario } from '../../model/clases';
import Swal from 'sweetalert2';
import { DataService } from '../../service/data.service';

@Component({
  selector: 'app-list',
  standalone: false,
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent {
  usuarios?: Usuario[];

  constructor(private dataService: DataService) {
    this.usuarios = this.dataService.getUsuarios();
    // this.usuarios = JSON.parse(localStorage.getItem('usuarios') || '[]');
  }
}
