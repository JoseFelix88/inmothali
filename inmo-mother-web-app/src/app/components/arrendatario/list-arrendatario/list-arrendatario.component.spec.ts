import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListArrendatarioComponent } from './list-arrendatario.component';

describe('ListArrendatarioComponent', () => {
  let component: ListArrendatarioComponent;
  let fixture: ComponentFixture<ListArrendatarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListArrendatarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListArrendatarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
