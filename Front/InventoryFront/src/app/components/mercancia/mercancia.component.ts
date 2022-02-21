import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CargoService } from 'src/app/services/cargo/cargo.service';
import { MercanciaService } from 'src/app/services/mercancia/mercancia.service';
import { RegistroService } from 'src/app/services/registro/registro.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';


@Component({
  selector: 'app-mercancia',
  templateUrl: './mercancia.component.html',
  styleUrls: ['./mercancia.component.css']
})
export class MercanciaComponent implements OnInit {

  mercanciaForm: FormGroup;
  fCreacion: Date = new Date();
  usuarios: any;
  mercancias: any;


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

    // this.mercanciaForm.get('usuario').valueChanges.subscribe(value => {
    //   this.mercanciaService.getAllMercanciasByUsuario(value.idUsuario).subscribe(resp => {
    //     this.mercancias = resp;
    //   })
    // })

  }

  guardar(): void {
    this.mercanciaService.save(this.mercanciaForm.value).subscribe(resp => {
      this.mercanciaForm.reset();
      this.mercancias.push(resp);
    },
      error => { console.error(error) }
    )
  }
}
