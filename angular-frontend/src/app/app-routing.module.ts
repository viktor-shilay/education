import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsersListComponent} from './components/user/users-list/users-list.component';
import {UserDetailsComponent} from './components/user/user-details/user-details.component';
import {AddUserComponent} from './components/user/add-user/add-user.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {ProfileComponent} from './components/profile/profile.component';
import {PageAdminComponent} from './components/page-admin/page-admin.component';
import {PageProfessorComponent} from './components/page-professor/page-professor.component';
import {PageStudentComponent} from './components/page-student/page-student.component';
import {DisciplinesListComponent} from './components/disciplines/disciplines-list/disciplines-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'users', component: UsersListComponent},
  { path: 'users/:id', component: UserDetailsComponent},
  { path: 'add', component: AddUserComponent},


  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'admin', component: PageAdminComponent},
  { path: 'professor', component: PageProfessorComponent},
  { path: 'student', component: PageStudentComponent},
  { path: 'teacher', component: PageStudentComponent},
  { path: 'disciplines/user', component: DisciplinesListComponent}
  // { path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
