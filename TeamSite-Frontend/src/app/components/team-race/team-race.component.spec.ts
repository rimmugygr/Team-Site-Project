import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamRaceComponent } from './team-race.component';

describe('TeamRaceComponent', () => {
  let component: TeamRaceComponent;
  let fixture: ComponentFixture<TeamRaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamRaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamRaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
