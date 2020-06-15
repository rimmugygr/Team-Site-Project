import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersViewComponent} from './components/all/members-view/members-view.component';
import {MemberViewComponent} from './components/all/member-view/member-view.component';
import {HomeComponent} from './components/all/home/home.component';
import {PostViewComponent} from './components/all/post-view/post-view.component';
import {CallbackComponent} from './components/team/callback/callback.component';
import {TeamProfileComponent} from './components/team/team-profile/team-profile.component';
import {AuthGuard} from './services/auth.guard';
import {TeamPostAddComponent} from './components/team/team-post-add/team-post-add.component';
import {TeamRaceComponent} from './components/team/team-race/team-race.component';
import {TeamRaceAddComponent} from './components/team/team-race-add/team-race-add.component';
import {TeamProfileEditComponent} from './components/team/team-profile-edit/team-profile-edit.component';

const routes: Routes = [
  {
    path: 'races/new',
    component: TeamRaceAddComponent
  },
  {
    path: 'races',
    component: TeamRaceComponent
  },
  {
    path: 'team',
    component: TeamProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'posts/new',
    component: TeamPostAddComponent
  },
  {
    path: 'members/new',
    component: TeamProfileEditComponent
  },
  {
    path: 'members/view/:id',
    component: MemberViewComponent
  },
  {
    path: 'members',
    component: MembersViewComponent
  },
  {
    path: 'posts',
    component: PostViewComponent
  },
  {
    path: 'callback',
    component: CallbackComponent
  },
  {
    path: '',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  // ,
  // providers: [
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: InterceptorService,
    //   multi: true
    // }
  // ]
})
export class AppRoutingModule { }
