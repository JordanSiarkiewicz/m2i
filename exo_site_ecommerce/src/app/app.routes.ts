import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { AdminComponent } from './pages/admin/admin.component';
import { PanierComponent } from './pages/panier/panier.component';

export const routes: Routes = [
    {path: '', component: AccueilComponent},
    {path: 'admin', component: AdminComponent},
    {path: 'panier', component: PanierComponent}
];
