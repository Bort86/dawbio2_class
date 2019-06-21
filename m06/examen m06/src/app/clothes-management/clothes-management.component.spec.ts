import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClothesManagementComponent } from './clothes-management.component';

describe('ClothesManagementComponent', () => {
  let component: ClothesManagementComponent;
  let fixture: ComponentFixture<ClothesManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClothesManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClothesManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
