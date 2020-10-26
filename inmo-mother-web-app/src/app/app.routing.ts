import { RouterModule } from '@angular/router';
import { ListArrendatarioComponent } from './components/arrendatario/list-arrendatario/list-arrendatario.component';
import { MenuComponent } from "./share/menu/menu.component";
import { AuthGuard } from './usuario/guards/auth.guard';
import { LoginComponent } from './usuario/login/login.component';



const APP_ROUTES = [
    {path: 'login', component: LoginComponent},
    {path: 'menu', component: MenuComponent, canActivate:[AuthGuard]},
    {path: 'list-arrendatario', component: ListArrendatarioComponent, canActivate:[AuthGuard]},
    { path: '',   redirectTo: '/login', pathMatch: 'full' },
];

export const routing = RouterModule.forRoot(APP_ROUTES, { enableTracing: false });