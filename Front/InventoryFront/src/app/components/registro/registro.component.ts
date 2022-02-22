import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CargoService } from 'src/app/services/cargo/cargo.service';
import { MercanciaService } from 'src/app/services/mercancia/mercancia.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { RegistroService } from 'src/app/services/registro/registro.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  mercanciaForm: FormGroup;
  eliminarForm: FormGroup;
  fCreacion: Date = new Date();
  usuarios: any;
  mercancias: any;


  constructor(
    public fb: FormBuilder,
    public cargoService: CargoService,
    public mercanciaService: MercanciaService,
    public usuarioService: UsuarioService,
    public registroService: RegistroService
  ) {

  }
  ngOnInit(): void {
    this.mercanciaForm = this.fb.group({
      idMercancia: ['', Validators.required],
      cantidad: ['', Validators.required],
      fCreacion: ['', Validators.required],
      usuario: ['', Validators.required],
    });;

    this.eliminarForm = this.fb.group({
      usuario: ['', Validators.required],
    })

    this.usuarioService.getAllUsuarios().subscribe(resp => {
      this.usuarios = resp;
    },
      error => { console.error(error) }
    );

    this.mercanciaService.getAllMercancias().subscribe(resp => {
      this.mercancias = resp;
    },
      error => { console.error(error) }
    );
    this.mercanciaService.getAllMercancias().subscribe(resp => {
      this.mercancias = resp;
    },
      error => { console.error(error) }
    );

    this.eliminarForm.get('usuario').valueChanges.subscribe(value => {
      this.mercanciaService.getAllMercanciasByUsuario(value.idUsuario).subscribe(resp => {
        this.mercancias = resp;
      })
    })
  }

  guardar(): void {
    this.mercanciaService.save(this.mercanciaForm.value).subscribe(resp => {
      this.mercanciaForm.reset();
      this.mercancias.push(resp);
    },
      error => { console.error(error) }
    )
  }

  eliminar(id) {
    this.mercanciaService.delete(id).subscribe(res => {
      this.mercanciaService.getAllMercancias().subscribe(response => this.mercancias = response)
    },
      error => { console.error(error) }
    )
  }

  editar(mercancia) {
    this.mercanciaForm.setValue({
      idMercancia: mercancia.idMercancia,
      cantidad: mercancia.cantidad,
      fCreacion: mercancia.fCreacion,
      usuario: mercancia.usuario,
    })
  }

  guardarRegistro(): void {
    this.registroService.saveRegistro(this.mercanciaForm.value).subscribe(resp => {
      this.mercanciaForm.reset();
      this.mercancias.push(resp);
    },
      error => { console.error(error) }
    )
  }

}
