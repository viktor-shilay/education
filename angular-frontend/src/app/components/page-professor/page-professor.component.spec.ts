import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageProfessorComponent } from './page-professor.component';

describe('PageProfessorComponent', () => {
  let component: PageProfessorComponent;
  let fixture: ComponentFixture<PageProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageProfessorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
