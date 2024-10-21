import { Component } from '@angular/core';
import { FiltertablePipe } from '../../utils/pipes/filtertable.pipe';

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [FiltertablePipe],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})



export class SeriesComponent {
  series: string[] = ["Breaking bad", "Game of thrones", "The penguin", "Les anneaux de pouvoir", "Berserk", "Mandalorian", "Great Teacher Onizuka", "Cowboy Bebop"]

  delete(index: number){
    this.series.splice(index,1)
  }

  filterTable: string = ""

  filterasc(){
    this.filterTable = "asc"
  }

  filterdesc(){
    this.filterTable = "desc"
  }


}
