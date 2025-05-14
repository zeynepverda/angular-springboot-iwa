import { Component } from '@angular/core';
import { RouterLink,RouterOutlet } from '@angular/router';
import {CalculatorComponent} from './calculator/calculator.component';
import {HelloworldComponent} from './helloworld/helloworld.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CalculatorComponent, HelloworldComponent,RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular19-iwa2025';
}
