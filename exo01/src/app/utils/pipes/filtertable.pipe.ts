import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtertable',
  standalone: true
})
export class FiltertablePipe implements PipeTransform {

  transform(value: string[], order : string): string[] {
    if(order == "asc"){
      return value.sort();
    } else if (order == "desc") {
      return value.sort().reverse();
    } else {
      return value
    }
  }

}
