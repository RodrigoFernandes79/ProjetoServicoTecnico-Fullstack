import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { OS } from 'src/app/models/os';
import { Tecnico } from 'src/app/models/tecnico';
import { ClienteService } from 'src/app/services/cliente.service';
import { OsService } from 'src/app/services/os.service';
import { TecnicoService } from 'src/app/services/tecnico.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-os-update',
  templateUrl: './os-update.component.html',
  styleUrls: ['./os-update.component.scss']
})
export class OsUpdateComponent implements OnInit {
   os:OS ={
    tecnico:'',
    cliente:'',
    status:'',
    prioridade:'',
    observacoes:''

  };
  tecnicos:Tecnico[]=[];
  clientes:Cliente[]=[];
   
  constructor(private tecnicoService:TecnicoService, private clienteService:ClienteService, 
    private osService:OsService, private router:Router, private route:ActivatedRoute) { }
  
    ngOnInit(): void {
      this.listarTecnicos();
      this.listarClientes();
      this.os.id =this.route.snapshot.params['id'];
      this.findById();
      
    }

    findById():void{
      this.osService.getOSById(this.os.id).subscribe(resposta=>{
        this.os =resposta;
      })
    }
  
    listarTecnicos():void{
     this.tecnicoService.getTecnico().subscribe(resposta =>{
      this.tecnicos=resposta;
    })
    }
  
    listarClientes():void{
      this.clienteService.getCliente().subscribe(resposta=>{
        this.clientes=resposta;
      })
    }
  
    updateOs(){
     
  this.osService.updateOS(this.os).subscribe(resposta=>{
    this.os =resposta;
    this.retornaLista();
    const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
      }
    })
    
    Toast.fire({
      icon: 'success',
      title:  'Ordem de Serviço ' +this.os.id+' Atualizada com Sucesso!'
    })
  })
    }
    retornaLista(){
      this.router.navigate(['os']);
    }
  }
  
