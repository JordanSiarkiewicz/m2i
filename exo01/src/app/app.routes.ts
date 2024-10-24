import { Routes } from '@angular/router';
import { CounterComponent } from './components/counter/counter.component';
import { SeriesComponent } from './components/series/series.component';
import { LibraryComponent } from './components/library/library.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { ChuckNorrisComponent } from './components/chuck-norris/chuck-norris.component';

export const routes: Routes = [
    {path: 'counter', component: CounterComponent},
    {path: 'series', component: SeriesComponent},
    {path: 'library', component: LibraryComponent},
    {path: 'pokemon', component: PokemonComponent},
    {path: 'chuck', component: ChuckNorrisComponent},
];
