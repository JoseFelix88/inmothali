import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { Arrendatario } from 'src/app/models/arrendatario';
import { ArrendatarioService } from 'src/app/services/arrendatario.service';
import { TipoDocumento } from 'src/app/utils/enums/tipo-documento.enum';

@Component({
  selector: 'app-add-edit-arrendatario',
  templateUrl: './add-edit-arrendatario.component.html',
  styleUrls: ['./add-edit-arrendatario.component.css']
})
export class AddEditArrendatarioComponent implements OnInit {

  public formGroupArrendatario: FormGroup;
  public arrendatario: Arrendatario;
  public titleModal: string;
  public isPersonaNatural: boolean = true;

  listTipoDocumento: any[] = [
    {value: TipoDocumento.CC, viewValue: TipoDocumento.CC.valueOf()},
    {value: TipoDocumento.NIT, viewValue: TipoDocumento.NIT.valueOf()},
    {value: TipoDocumento.CE, viewValue: TipoDocumento.CE.valueOf()},
    {value: TipoDocumento.PA, viewValue: TipoDocumento.PA.valueOf()}
  ];

  constructor(private _formBuildArrendatario: FormBuilder
    , private _arrendatarioService: ArrendatarioService
    , private _dialogRef: MatDialogRef<AddEditArrendatarioComponent>) { }

  ngOnInit() {
    this.formGroupArrendatario = new FormGroup({
      codigoArrendatario: new FormControl(),
      primerApellido: new FormControl(),
      segundoApellido: new FormControl(),
      primerNombre: new FormControl(),
      segundoNombre: new FormControl(),
      razonSocial: new FormControl(),
      correoElectronico: new FormControl(),
      tipoPersona: new FormControl(),
      tipoDocumento: new FormControl()
    });
    this.arrendatario = new Arrendatario();
    this.builderFormArrendatario();
  }

  public builderFormArrendatario() {
    if(this.arrendatario == null || this.arrendatario.codigoArrendatario < 1) {
      this.formGroupArrendatario.reset;
    } else {
      this.formGroupArrendatario = this._formBuildArrendatario.group({
        codigoArrendatario: this.arrendatario.codigoArrendatario,
        numeroDocumento: [this.arrendatario.numeroDocumento, [Validators.required]],
        primerApellido: [this.arrendatario.primerApellido, [Validators.required]],
        segundoApellido: this.arrendatario.segundoApellido,
        primerNombre: [this.arrendatario.primerNombre, [Validators.required]],
        segundoNombre: this.arrendatario.segundoNombre,
        razonSocial: [this.arrendatario.razonSocial, [Validators.required]],
        correoElectronico: this.arrendatario.correoElectronico,
        tipoPersona: [this.arrendatario.tipoPersona, [Validators.required]],
        tipoDocumento: [this.arrendatario.tipoDocumento, [Validators.required]]
      });
    }
  }

  guardarArrendatario(): void {
    console.log(this.formGroupArrendatario.value);
  }

}
