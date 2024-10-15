import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  count: number = 0

  

  colorGreen: string = 'green'
  colorRed: string = 'red'

  isPair: boolean = true

  pairCheck () {
    if(this.count%2 == 0){
      this.isPair = true;
    } else {
      this.isPair = false;
    }
  }

  incrementer(){
    this.count++
    this.pairCheck ()
  }

  decrementer(){
    this.count--
    this.pairCheck ()
  }

  
}
