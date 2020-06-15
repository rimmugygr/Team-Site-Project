import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MembersViewComponent } from './components/all/members-view/members-view.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { TeamProfileEditComponent } from './components/team/team-profile-edit/team-profile-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MemberViewComponent } from './components/all/member-view/member-view.component';
import { HomeComponent } from './components/all/home/home.component';
import { WhenDirective } from './directive/when.directive';
import { FooterComponent } from './layout/footer.component';
import { NavbarComponent } from './layout/navbar.component';
import {SidebarComponent} from './layout/sidebar.component';
import { AttachToDirective } from './directive/attach-to.directive';
import { AddTargetDirective } from './directive/add-target.directive';
import { PostViewComponent } from './components/all/post-view/post-view.component';
import { CallbackComponent } from './components/team/callback/callback.component';
import {TeamPostAddComponent} from './components/team/team-post-add/team-post-add.component';
import {TeamProfileComponent} from './components/team/team-profile/team-profile.component';
import { TeamRaceComponent } from './components/team/team-race/team-race.component';
import { TeamRaceAddComponent } from './components/team/team-race-add/team-race-add.component';


@NgModule({
  declarations: [
    AppComponent,
    MembersViewComponent,
    TeamProfileEditComponent,
    MemberViewComponent,
    HomeComponent,
    WhenDirective,
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    AttachToDirective,
    AddTargetDirective,
    PostViewComponent,
    CallbackComponent,
    TeamPostAddComponent,
    TeamProfileComponent,
    TeamRaceComponent,
    TeamRaceAddComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
