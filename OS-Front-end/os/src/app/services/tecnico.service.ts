import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tecnico } from '../models/tecnico';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {

  private tecnicoUrl:string='http://localhost:8080/tecnicos';

  constructor(private http:HttpClient) { }

  getTecnico():Observable<Tecnico[]>{
    return this.http.get<Tecnico[]>(this.tecnicoUrl);
    
  }

  postTecnico(tecnico:Tecnico):Observable<Tecnico>{

    return this.http.post<Tecnico>(this.tecnicoUrl,tecnico);
  }

  
}
