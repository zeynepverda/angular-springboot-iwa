import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  imports: [],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {
result1!: number;
result2!: number;
result3!: number;
result4!: number;
result5!: number;

  addition(a:number, b:number):void {
  this.result1 = a + b;
  console.log("addition operation: result=" + this.result1);
}

subtraction(c:number, d:number):void {
    this.result2=c-d;
    console.log("subtraction operation: result=" + this.result2);
}

  multiplication(e:number, f:number):void {
    this.result3=e*f;
    console.log("multiplication operation: result=" + this.result3);
  }

  division(g:number, h:number):void{
    this.result4=g/h;
    console.log("division operation: result=" + this.result4);
  }

  fibonacci(n: number): void {
    if (n <= 0) {
      this.result5 = 0;
    } else if (n === 1) {
      this.result5 = 1;
    } else {
      let a = 0, b = 1, temp;
      for (let i = 2; i <= n; i++) {
        temp = a + b;
        a = b;
        b = temp;
      }
      this.result5 = b;
    }
    console.log("fibonacci operation: result=" + this.result5);
  }

}
