import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieListComponent } from './movie-list/movie-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UserListComponent } from './user-list/user-list.component';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AddLibraryComponent } from './add-library/add-library.component';
import { ProfilComponent } from './profil/profil.component';
import { LibrariesListComponent } from './libraries-list/libraries-list.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { LibraryDetailComponent } from './library-detail/library-detail.component'

const routes: Routes = [
  { path: 'movie-list/:libraryId', component: MovieListComponent },
  { path: 'add-user', component: AddUserComponent },
  { path: 'user-list', component: UserListComponent },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'add-library', component: AddLibraryComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'libraries-list', component: LibrariesListComponent },
  { path: 'add-movie/:libraryId', component: AddMovieComponent },
  { path: 'library-detail/:libraryId', component: LibraryDetailComponent }
];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }