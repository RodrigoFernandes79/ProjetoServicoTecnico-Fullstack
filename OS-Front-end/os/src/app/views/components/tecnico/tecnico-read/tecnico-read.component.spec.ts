import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TecnicoReadComponent } from './tecnico-read.component';

describe('TecnicoReadComponent', () => {
  let component: TecnicoReadComponent;
  let fixture: ComponentFixture<TecnicoReadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TecnicoReadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TecnicoReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
