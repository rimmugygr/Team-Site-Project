import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamRaceAddComponent } from './team-race-add.component';

describe('TeamRaceAddComponent', () => {
  let component: TeamRaceAddComponent;
  let fixture: ComponentFixture<TeamRaceAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamRaceAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamRaceAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
