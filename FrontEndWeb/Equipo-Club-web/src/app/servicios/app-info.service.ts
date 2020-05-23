import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppInfoService {

  constructor() { }

  getVersionApp(){
    return '0.1';
  }

  getNombreAutor(){
    return 'Sergio Espejel Ortigüela';
  }

  getNombreApp(){
    return 'EQUIIPO DE CLUB';
  }
}
