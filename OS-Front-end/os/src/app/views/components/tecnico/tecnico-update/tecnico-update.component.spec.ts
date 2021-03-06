import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TecnicoUpdateComponent } from './tecnico-update.component';

describe('TecnicoUpdateComponent', () => {
  let component: TecnicoUpdateComponent;
  let fixture: ComponentFixture<TecnicoUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TecnicoUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TecnicoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
