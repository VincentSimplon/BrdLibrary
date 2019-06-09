import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Library } from '../model/library.model';
import { LibrariesListComponent } from '../libraries-list/libraries-list.component';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-library-detail',
  templateUrl: './library-detail.component.html',
  styleUrls: ['./library-detail.component.css']
})
export class LibraryDetailComponent implements OnInit {

  librarys: Library = new Library;
  librayId: number;

  constructor(private libraryService: LibraryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.librayId = this.route.snapshot.params.libraryId;
    
    this.libraryService.libraryDetail(this.librayId).subscribe(library => {
      this.librarys = library;
      console.log("DETAIL : " + this.librarys.name);

    })

    
    
    

  }
}


