import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { PokemonCardComponent } from '../pokemon-card/pokemon-card.component';

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
  selector: 'app-pokemon',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule,PokemonCardComponent],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {

  pokemon : Pokemon = {
    nom: "",
    description: "",
    type: [],
    attackList: [
      {
      nom: "",
      description: "",
      degats: 0
      }
    ],
    zone : [
      {
      nom: "",
      region: ""
      }
    ]
  }

  pokemonList: Pokemon[] = []

  pokemon_form: FormGroup = new FormGroup(
    {
      nom: new FormControl("", [Validators.required]),

      description: new FormControl("", [Validators.required]),

      zone: new FormGroup({
        nom: new FormControl(''),
        region: new FormControl('')
      }),

      modules: new FormArray([
        new FormGroup({
                nom: new FormControl(''),
                description: new FormControl(''),
                degats: new FormControl(''),
          })
      ]),

      types: new FormArray([
        new FormGroup({
                nom : new FormControl(''),
        })
      ])
    }, 
    
  )

  get modules() {
    return this.pokemon_form.controls['modules'] as FormArray;
  }

  get types() {
    return this.pokemon_form.controls['types'] as FormArray;
  }

  addModule(): void{  
    this.modules.push(new FormGroup({
      nom: new FormControl(''),
      description: new FormControl(''),
      degats: new FormControl(''),
    }))
  }

  addType(): void{  
    this.types.push(new FormGroup({
      nom: new FormControl(''),
    }))
  }

  save_pokemon() : void {
    if(this.pokemon_form.valid) {    
      console.log('Sauvegarde du Pokemon', this.pokemon_form.value);
      this.pokemonList.push(this.pokemon_form.value);
      this.pokemon_form.reset()
    }
  }
}
