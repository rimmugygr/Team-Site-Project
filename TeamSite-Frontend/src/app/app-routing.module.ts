import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersComponent} from './components/members/members.component';
import {TeamViewMemberComponent} from './components/team-view-member/team-view-member.component';
import {HomeComponent} from './components/home/home.component';
import {PostViewComponent} from './components/post-view/post-view.component';
import {CallbackComponent} from './components/callback/callback.component';
import {TeamHomeComponent} from './components/team-home/team-home.component';
import {AuthGuard} from './services/auth.guard';
import {TeamPostAddComponent} from './components/team-post-add/team-post-add.component';
import {TeamRaceComponent} from './components/team-race/team-race.component';
import {TeamRaceAddComponent} from './components/team-race-add/team-race-add.component';
import {TeamNewMemberComponent} from './components/team-new-member/team-new-member.component';

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
    component: TeamHomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'posts/new',
    component: TeamPostAddComponent
  },
  {
    path: 'members/new',
    component: TeamNewMemberComponent
  },
  {
    path: 'members/view/:id',
    component: TeamViewMemberComponent
  },
  {
    path: 'members',
    component: MembersComponent
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
