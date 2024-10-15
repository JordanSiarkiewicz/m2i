import { Component } from '@angular/core';

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  series: string[] = ["Breaking bad", "Game of thrones", "The penguin", "Les anneaux de pouvoir"]

  delete(index: number){
    delete this.series[index]
  }
}
