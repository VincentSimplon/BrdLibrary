import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {  MatAutocompleteModule, 
  MatBadgeModule, 
  MatBottomSheetModule, 
  MatButtonModule, 
  MatButtonToggleModule, 
  MatCardModule, 
  MatCheckboxModule,
  MatChipsModule, 
  MatDatepickerModule, 
  MatDialogModule, 
  MatDividerModule, 
  MatExpansionModule, 
  MatFormFieldModule,
  MatGridListModule, 
  MatIconModule,
  MatInputModule, 
  MatListModule, 
  MatMenuModule, 
  MatNativeDateModule, 
  MatPaginatorModule, 
  MatProgressBarModule, 
  MatProgressSpinnerModule,
  MatRadioModule, 
  MatRippleModule, 
  MatSelectModule, 
  MatSidenavModule, 
  MatSliderModule, 
  MatSlideToggleModule, 
  MatSnackBarModule,
  MatSortModule, 
  MatStepperModule, 
  MatTableModule, 
  MatTabsModule, 
  MatToolbarModule, 
  MatTooltipModule,
  MatTreeModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UserListComponent } from './user-list/user-list.component';
import { FlexLayoutModule } from "@angular/flex-layout";
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { JwtInterceptor } from './http-interceptor/jwt.interceptor';
import { AdminGuard } from './guards/admin.guard';
import { UserGuard } from './guards/user.guard';
import { ProfilComponent } from './profil/profil.component';




@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MovieListComponent,
    AddUserComponent,
    UserListComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    ProfilComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatAutocompleteModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    FlexLayoutModule,
    MatButtonToggleModule,
    ReactiveFormsModule
  ],
  providers: [AdminGuard, UserGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}