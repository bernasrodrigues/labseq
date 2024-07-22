import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // Import the routing module
import { AppComponent } from './app.component';
import { LabseqComponent } from './labseq/labseq.component'; // Import the component

@NgModule({
  declarations: [

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppComponent,
    LabseqComponent,
    // Add the routing module here
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
