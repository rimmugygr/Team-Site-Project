import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamViewMemberComponent } from './team-view-member.component';

describe('TeamViewMemberComponent', () => {
  let component: TeamViewMemberComponent;
  let fixture: ComponentFixture<TeamViewMemberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamViewMemberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamViewMemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
