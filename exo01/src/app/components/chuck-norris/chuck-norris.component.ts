import { Component, OnInit } from '@angular/core';
import { ChuckNorrisService } from '../../services/chuck-norris.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-chuck-norris',
  standalone: true,
  imports: [],
  templateUrl: './chuck-norris.component.html',
  styleUrl: './chuck-norris.component.css'
})
export class ChuckNorrisComponent implements OnInit {
  joke!: string

  constructor(private chuckService: ChuckNorrisService) {}

  ngOnInit(): void {
    this.getFact()
  }

  getFact() {
    this.chuckService.getRandomFact().subscribe((data: string) => {
      this.joke = data
    })
  }

}
