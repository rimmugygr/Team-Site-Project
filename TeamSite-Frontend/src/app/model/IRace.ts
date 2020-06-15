import {IStart} from './IStart';

export interface IRace {
  id: number;
  name: string;
  localization: string;
  type: string;
  distance: string;
  date: string;
  raceStarts: IStart[];
}
