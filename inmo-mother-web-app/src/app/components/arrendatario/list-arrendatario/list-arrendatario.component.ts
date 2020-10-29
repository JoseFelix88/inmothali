import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { Arrendatario } from 'src/app/models/arrendatario';
import { ArrendatarioService } from 'src/app/services/arrendatario.service';
import { Notificacion } from 'src/app/utils/notificacion';
import Swal from 'sweetalert2';

export interface UserData {
  id: string;
  name: string;
  progress: string;
  color: string;
}

/** Constants used to fill up our data base. */
const COLORS: string[] = [
  'maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple', 'fuchsia', 'lime', 'teal',
  'aqua', 'blue', 'navy', 'black', 'gray'
];
const NAMES: string[] = [
  'Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack', 'Charlotte', 'Theodore', 'Isla', 'Oliver',
  'Isabella', 'Jasper', 'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'
];

@Component({
  selector: 'app-list-arrendatario',
  templateUrl: './list-arrendatario.component.html',
  styleUrls: ['./list-arrendatario.component.css']
})
export class ListArrendatarioComponent implements OnInit  {
  public listArrendatarios: any[] = []
  
  public flagLoading: boolean;
  public messangeError: string;

  displayedColumns: string[] = ['numeroDocumento', 
              'nombreApellido', 
              'tipoDocumento',
              'tipoPersona',
              'estadoContrato'];
  dataSource: MatTableDataSource<Arrendatario>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort , {static: true}) sort: MatSort;

  constructor(private _arrendatarioService: ArrendatarioService) { 
    this.flagLoading = true;
   }

  ngOnInit(): void {
    this._arrendatarioService.listarArrendatarios().subscribe(
      listData => {
          this.dataSource.data = listData;
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator;
          this.flagLoading = false;
      }, error => {
        this.flagLoading = false;
        if (error.ok === false && error.status === 0) {
          let messange = new String(`No se pudo establecer conexión con el servidor.
          El servicio no se encuentra disponible.`);
          this.messangeError = messange.concat(`El error presentado es el siguiente: ${error.message}`);
        } else {
          this.messangeError = `Se presento el siguiente error: ${error.message}`;
        }
        Swal.fire('ERROR', this.messangeError, 'error');
      });
  }

  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}