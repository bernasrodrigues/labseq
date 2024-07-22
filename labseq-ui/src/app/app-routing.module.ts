import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LabseqComponent } from './labseq/labseq.component'; // Ensure the correct path

const routes: Routes = [
  { path: '', redirectTo: '/labseq', pathMatch: 'full' },
  { path: 'labseq', component: LabseqComponent },
  { path: '**', redirectTo: '/labseq' } // Redirect unknown routes to the labseq component
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
