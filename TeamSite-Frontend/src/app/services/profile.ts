import {IRunner} from '../components/IRunner';

export class Profile implements IRunner{
  birdDate: any;
  description: any;
  email: any;
  public firstName: string;
  gender: any;
  id: string | number;
  picture: any;
  secondName: any;
  surname: string;


  setValue(firstName: string, id: string | number, picture: any, secondName: any, surname: string) {
    this.firstName = firstName;
    this.id = id;
    this.picture = picture;
    this.secondName = secondName;
    this.surname = surname;
  }
}
