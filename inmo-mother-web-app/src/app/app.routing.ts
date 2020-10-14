import { RouterModule } from '@angular/router';
import { MenuComponent } from "./share/menu/menu.component";
import { LoginComponent } from './usuario/login/login.component';



const APP_ROUTES = [
    {path: 'login', component: LoginComponent},
    {path: 'menu', component: MenuComponent},
    { path: '',   redirectTo: '/login', pathMatch: 'full' },
];

export const routing = RouterModule.forRoot(APP_ROUTES, { enableTracing: false });