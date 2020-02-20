import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() navigate: EventEmitter<string>;
  selected: string;
  login = false;
  
  constructor() {
    this.navigate = new EventEmitter<string>();
    this.selected = 'login';
  }

  ngOnInit(): void {
  }

  onSelect(selected: string) {
    this.selected = selected;
    this.navigate.emit(selected);
  }

}
