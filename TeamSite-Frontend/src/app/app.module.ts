import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MembersComponent } from './components/members/members.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { TeamEditProfileComponent } from './components/team-edit-profile/team-edit-profile.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TeamViewMemberComponent } from './components/team-view-member/team-view-member.component';
import { HomeComponent } from './components/home/home.component';
import { WhenDirective } from './directive/when.directive';
import { FooterComponent } from './layout/footer.component';
import { NavbarComponent } from './layout/navbar.component';
import {SidebarComponent} from './layout/sidebar.component';
import { AttachToDirective } from './directive/attach-to.directive';
import { AddTargetDirective } from './directive/add-target.directive';
import { PostViewComponent } from './components/post-view/post-view.component';
import { CallbackComponent } from './components/callback/callback.component';
import {TeamPostAddComponent} from './components/team-post-add/team-post-add.component';
import {TeamHomeComponent} from './components/team-home/team-home.component';
import { TeamRaceComponent } from './components/team-race/team-race.component';
import { TeamRaceAddComponent } from './components/team-race-add/team-race-add.component';


@NgModule({
  declarations: [
    AppComponent,
    MembersComponent,
    TeamEditProfileComponent,
    TeamViewMemberComponent,
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
    TeamHomeComponent,
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
