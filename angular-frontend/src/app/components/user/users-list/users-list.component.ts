import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user/user';
import {UserService} from '../../../services/user/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  constructor(private userService: UserService) { }

  users?: User[];
  currentUser?: User;
  currentIndex = -1;
  name = '';

  ngOnInit(): void {
    this.retrieveUsers();
  }

  retrieveUsers(): void{
    this.userService.getAll().subscribe(data => {
      this.users = data;
      console.log(data);
    }, error => {
      console.log(error);
    });
  }

  refreshList(): void {
    this.retrieveUsers();
    this.currentUser = undefined;
    this.currentIndex = -1;
  }

  setActiveUser(user: User, index: number): void {
    this.currentUser = user;
    this.currentIndex = index;
  }

  searchName(): void {
    this.currentUser = undefined;
    this.currentIndex = -1;

    this.userService.findByName(this.name)
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
