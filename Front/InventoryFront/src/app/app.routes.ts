import {RouterModule, Routes} from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { MercanciaComponent } from './components/mercancia/mercancia.component';
import { RegistroComponent } from './components/registro/registro.component';

const app_routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'mercancia', component: MercanciaComponent }, 
    { path: 'registro', component: RegistroComponent },
    { path: '**', pathMatch: 'full', redirectTo: 'home'}
];

export const app_routing = RouterModule.forRoot(app_routes);