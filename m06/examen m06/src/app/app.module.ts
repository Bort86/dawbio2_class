import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClothesManagementComponent } from './clothes-management/clothes-management.component';
import { RouterModule,Routes } from '@angular/router';
// Pagination
import { NgxPaginationModule } from 'ngx-pagination';
import { ItemValidatorDirective } from './Directives/item-validator.directive';

const appRoutes: Routes = [
  {path:'clothes-management', component:ClothesManagementComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    ClothesManagementComponent,
    ItemValidatorDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule, //pagination
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
