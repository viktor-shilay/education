import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersListComponent } from './components/user/users-list/users-list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {UserDetailsComponent} from './components/user/user-details/user-details.component';
import {AddUserComponent} from './components/user/add-user/add-user.component';
import { LoginComponent } from './components/login/login.component';
import { PageAdminComponent } from './components/page-admin/page-admin.component';
import { PageStudentComponent } from './components/page-student/page-student.component';
import { PageProfessorComponent } from './components/page-professor/page-professor.component';
import { PageTeacherComponent } from './components/page-teacher/page-teacher.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import {authInterceptorProviders} from './services/auth/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    UsersListComponent,
    UserDetailsComponent,
    AddUserComponent,
    LoginComponent,
    PageAdminComponent,
    PageStudentComponent,
    PageProfessorComponent,
    PageTeacherComponent,
    HomeComponent,
    ProfileComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
