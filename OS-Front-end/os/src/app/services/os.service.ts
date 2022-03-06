import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OS } from '../models/os';

@Injectable({
  providedIn: 'root'
})
export class OsService {
  private OSUrl:string='http://localhost:8080/ordemservico';

  constructor(private http:HttpClient) { }

  getOS():Observable<OS[]>{
    return this.http.get<OS[]>(this.OSUrl);
    
  }

  postOS(os:OS):Observable<OS>{

    return this.http.post<OS>(this.OSUrl,os);
  }

  getOSById(id:number):Observable<OS>{

return this.http.get<OS>(`${this.OSUrl}/${id}`);
  }

  updateOS(os:OS ):Observable<OS>{
    return this.http.put<OS>(`${this.OSUrl}`,os);
  }

  deleteOSById(id:number):Observable<OS>{
    return this.http.delete<OS>(`${this.OSUrl}/${id}`);
  }
}
