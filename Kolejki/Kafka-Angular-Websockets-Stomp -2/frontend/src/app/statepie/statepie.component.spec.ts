import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatepieComponent } from './statepie.component';

describe('StatepieComponent', () => {
  let component: StatepieComponent;
  let fixture: ComponentFixture<StatepieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StatepieComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StatepieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
