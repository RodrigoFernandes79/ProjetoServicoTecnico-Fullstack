import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';

import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-read',
  templateUrl: './tecnico-read.component.html',
  styleUrls: ['./tecnico-read.component.scss']
})
export class TecnicoReadComponent implements AfterViewInit {

  tecnicos:Tecnico[]=[];

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'telefone'];
  dataSource = new MatTableDataSource<Tecnico>(this.tecnicos);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service:TecnicoService){}

  ngAfterViewInit() {
    
    this.listarTecnicos();
    
  }
  ngOnInit(): void {
    
    
  }

  listarTecnicos():void{
      this.service.getTecnico().subscribe(resposta=>{
      this.tecnicos =resposta;
      this.dataSource = new MatTableDataSource<Tecnico>(this.tecnicos);
      this.dataSource.paginator = this.paginator;
    })
     
     
     
  }
 
    
  }




