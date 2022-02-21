import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MercanciaService } from 'src/app/services/mercancia/mercancia.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  mercanciaForm: FormGroup;
  usuarios: any;
  mercancias: any;

  constructor(
    public fb: FormBuilder,
    public mercanciaService: MercanciaService,
    public usuarioService: UsuarioService
  ) { }

  ngOnInit(): void {

    this.mercanciaForm = this.fb.group({
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
    this.mercanciaForm.get('usuario').valueChanges.subscribe(value => {
      this.mercanciaService.getAllMercanciasByUsuario(value.idUsuario).subscribe(resp => {
        this.mercancias = resp;
      })
    })
  }

}
