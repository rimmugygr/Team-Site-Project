import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamNewMemberComponent } from './team-new-member.component';

describe('TeamNewmemberComponent', () => {
  let component: TeamNewMemberComponent;
  let fixture: ComponentFixture<TeamNewMemberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamNewMemberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamNewMemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
