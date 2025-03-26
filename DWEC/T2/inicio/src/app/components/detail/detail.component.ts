import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../../model/clases';
import { DataService } from '../../service/data.service';

@Component({
  selector: 'app-detail',
  standalone: false,
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css',
})
export class DetailComponent {
  usuario?: Usuario;
  constructor(private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe((params) => {
      this.usuario = this.dataService.getUsuarioByName(params['id']);
    });
  }
}
