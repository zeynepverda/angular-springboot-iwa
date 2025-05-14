import { Routes } from '@angular/router';
import { HelloworldComponent} from './helloworld/helloworld.component';
import {CalculatorComponent} from './calculator/calculator.component';

export const routes: Routes = [
  {path: 'hello', component: HelloworldComponent},
  {path: 'calculator', component: CalculatorComponent}
];
