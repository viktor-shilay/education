import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsersListComponent} from './components/user/users-list/users-list.component';
import {UserDetailsComponent} from './components/user/user-details/user-details.component';
import {AddUserComponent} from './components/user/add-user/add-user.component';

const routes: Routes = [
  { path: '', redirectTo: 'users', pathMatch: 'full'},
  { path: 'users', component: UsersListComponent},
  { path: 'users/:id', component: UserDetailsComponent},
  { path: 'add', component: AddUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
