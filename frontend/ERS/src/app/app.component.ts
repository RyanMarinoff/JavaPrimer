import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ERS';
  selected: string = 'login';

  onNavigate(select: string) {
    this.selected = select;
  }
}
