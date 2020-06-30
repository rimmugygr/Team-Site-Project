import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersViewComponent} from './components/all/members-view/members-view.component';
import {MemberViewComponent} from './components/all/member-view/member-view.component';
import {HomeComponent} from './components/all/home/home.component';
import {PostViewComponent} from './components/all/post-view/post-view.component';
import {CallbackComponent} from './components/team/callback/callback.component';
import {ProfileComponent} from './components/team/profile/profile.component';
import {AuthGuard} from './services/auth/auth.guard';
import {PostAddComponent} from './components/team/post-add/post-add.component';
import {RaceComponent} from './components/team/race/race.component';
import {RaceAddComponent} from './components/team/race-add/race-add.component';
import {ProfileEditComponent} from './components/team/profile-edit/profile-edit.component';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {InterceptorService} from './services/auth/interceptor.service';

const routes: Routes = [
  {
    path: 'races/new',
    component: RaceAddComponent
  },
  {
    path: 'races',
    component: RaceComponent
  },
  {
    path: 'team',
    component: ProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'posts/new',
    component: PostAddComponent
  },
  {
    path: 'members/new',
    component: ProfileEditComponent
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
  ,
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi: true
    }
  ]
})
export class AppRoutingModule { }
