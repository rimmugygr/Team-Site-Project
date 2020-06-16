import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MembersViewComponent } from './components/all/members-view/members-view.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { ProfileEditComponent } from './components/team/profile-edit/profile-edit.component';
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
import {PostAddComponent} from './components/team/post-add/post-add.component';
import {ProfileComponent} from './components/team/profile/profile.component';
import { RaceComponent } from './components/team/race/race.component';
import { RaceAddComponent } from './components/team/race-add/race-add.component';


@NgModule({
  declarations: [
    AppComponent,
    MembersViewComponent,
    ProfileEditComponent,
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
    PostAddComponent,
    ProfileComponent,
    RaceComponent,
    RaceAddComponent
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
