import { Component, Input, Output, EventEmitter } from '@angular/core';

class Pokemon {
  nom: string;
  description: string;
  type: string[];
  attackList: [
    {
    nom: string,
    description: string,
    degats: number
    }
  ];
  zone : [
    {
    nom: string,
    region: string
    }
  ];

  constructor(nom: string, description: string, type: string[], attackList: [{nom: string, description: string, degats:number}], zone: [{nom: string, region: string}]){
    this.nom = nom,
    this.description = description,
    this.type = type,
    this.attackList = attackList,
    this.zone = zone
  }
}

@Component({
  selector: 'app-pokemon-card',
  standalone: true,
  imports: [],
  templateUrl: './pokemon-card.component.html',
  styleUrl: './pokemon-card.component.css'
})
export class PokemonCardComponent {
  @Input() pokemon!: Pokemon;

  @Output() dataEmitted = new EventEmitter<string>()

  sendData() {
    this.dataEmitted.emit('Hello depuis le composant enfant !')
  }
  
}
