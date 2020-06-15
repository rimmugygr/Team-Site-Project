import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamPostAddComponent } from './team-post-add.component';

describe('TeamPostAddComponent', () => {
  let component: TeamPostAddComponent;
  let fixture: ComponentFixture<TeamPostAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamPostAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamPostAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
