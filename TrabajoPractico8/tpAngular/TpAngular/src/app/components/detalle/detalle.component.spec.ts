import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { Detalle } from "./detalle.component";

describe("GrillaProductosComponent", () => {
  let component: Detalle;
  let fixture: ComponentFixture<Detalle>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [Detalle],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Detalle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
