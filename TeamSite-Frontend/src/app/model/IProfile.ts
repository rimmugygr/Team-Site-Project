import {IRunner} from './IRunner';
import {IRunnerShow} from './IRunnerShow';

export interface  IProfile extends IRunner{
  birdDate: any;
  description: any;
  email: any;
  firstName: string;
  gender: any;
  id: string | number;
  picture: any;
  secondName: any;
  surname: string;
  runnerShow: IRunnerShow;
}
