import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CargoService } from './services/cargo/cargo.service';
import { MercanciaService } from './services/mercancia/mercancia.service';
import { RegistroService } from './services/registro/registro.service';
import { UsuarioService } from './services/usuario/usuario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  mercanciaForm: FormGroup;
  currentDate : Date =new Date();
  usuarios: any;
  

  constructor(
    public fb: FormBuilder,
    public cargoService: CargoService,
    public mercanciaService: MercanciaService,
    public registroService: RegistroService,
    public usuarioService: UsuarioService
  ) {

  }
  ngOnInit(): void {
    

    this.mercanciaForm = this.fb.group({
      idMercancia: ['', Validators.required],
      cantidad: ['', Validators.required],
      fCreacion: ['', Validators.required],
      usuario: ['', Validators.required],
    });;

    this.usuarioService.getAllUsuarios().subscribe(resp=>{
      this.usuarios = resp;
    },
    error=>{console.error(error)}
    )
  }

  guardar(): void {

  }


}
