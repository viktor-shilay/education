import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from './services/token/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'angular-frontend';
  isLoggedIn = false;
  showAdminPage = false;
  showProfessorPage = false;
  showStudentPage = false;
  showTeacherPage = false;
  email?: string;
  role?: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn){
      const user = this.tokenStorageService.getUser();
      this.role = user.role;
      if (this.role === 'ROLE_ADMIN'){
        this.showAdminPage = true;
      }
      if (this.role === 'ROLE_PROFESSOR'){
        this.showProfessorPage = true;
      }
      if (this.role === 'ROLE_STUDENT'){
        this.showStudentPage = true;
      }
      if (this.role === 'ROLE_TEACHER'){
        this.showTeacherPage = true;
      }
      this.email = user.email;
    }
  }

  logout(): void{
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
