import { Component, ChangeDetectorRef, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-dashboard-side-bar',
  templateUrl: './dashboard-side-bar.component.html',
  styleUrls: ['./dashboard-side-bar.component.scss']
})
export class DashboardSideBarComponent {

@Output() dataEvent = new EventEmitter<void>();
@Output() dataEvent2 = new EventEmitter<void>();
@Output() dataEvent3 = new EventEmitter<void>();

  constructor(private cdRef: ChangeDetectorRef) {

  }

  isDvdTableVisible = false;
  isClientTableVisible = false;
  isSaleTableVisible = false;

  showDvdTable() {
    this.isDvdTableVisible = true;
    this.isClientTableVisible = false;
    this.isSaleTableVisible = false;
    this.dataEvent.emit();
    this.cdRef.detectChanges();
  }

  showClientTable() {
    this.isDvdTableVisible = true;
    this.isClientTableVisible = false;
    this.isSaleTableVisible = false;
    this.dataEvent2.emit();
    this.cdRef.detectChanges();
  }

  showSaleTable() {
    this.isDvdTableVisible = true;
    this.isClientTableVisible = false;
    this.isSaleTableVisible = false;
    this.dataEvent3.emit();
    this.cdRef.detectChanges();
  }

}
