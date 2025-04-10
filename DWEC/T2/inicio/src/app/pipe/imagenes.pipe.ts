import { Pipe, PipeTransform } from '@angular/core';
import { Usuario } from '../model/clases';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: Usuario, ...args: number[]): string {
    if (args[0] != 0) {
      if (value.genero.toLowerCase() == 'masculino') {
        return 'https://static.vecteezy.com/system/resources/previews/002/779/357/non_2x/male-symbol-a-man-stands-next-to-a-gender-icon-illustration-flat-vector.jpg';
      }
      return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSasQnKddBrrfM90xg2zXbv5Bn7UgxDeziBxw&s';
    } else {
      return 'https://media.istockphoto.com/id/863759396/es/vector/hombre-y-mujer-tocador-signo.jpg?s=612x612&w=0&k=20&c=jt4bRB6a6h8drBsMMMEzQj2nZnCPZWRg8hJR04WZd7o=';
    }
  }
}
