import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(movies: any, title: any):any {
    if(title === undefined) return movies;
    return movies.filter(function (movie) {
      return movie.title.toLowerCase().includes(title.toLowerCase())

    })
  }

}
