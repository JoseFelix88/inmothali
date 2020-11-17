import { Component, OnInit } from '@angular/core';
import { MatDialog, MatPaginatorIntl, PageEvent} from '@angular/material';
import { Arrendatario } from 'src/app/models/arrendatario';
import { ArrendatarioService } from 'src/app/services/arrendatario.service';
import Swal from 'sweetalert2';
import { AddEditArrendatarioComponent } from '../add-edit-arrendatario/add-edit-arrendatario.component';

@Component({
  selector: 'app-list-arrendatario',
  templateUrl: './list-arrendatario.component.html',
  styleUrls: ['./list-arrendatario.component.css']
})
export class ListArrendatarioComponent implements OnInit {
  public listArrendatarios: Arrendatario[] = []
  totalRegistros = 0;
  paginaActual = 0;
  totalPorPagina = 5;
  pageSizeOptions: number[] = [3, 5, 10, 25, 100];
  public flagLoading: boolean;
  public messangeError: string;

  constructor(private _arrendatarioService: ArrendatarioService,
              private paginatorIntl: MatPaginatorIntl,
              private _matDialog: MatDialog) { 
    this.flagLoading = true;
    this.paginatorIntl.itemsPerPageLabel = "Items por página";
   }
  
  ngOnInit(): void {
      this.listarArrendatarios();
  }

  paginar(event: PageEvent): void {
    this.paginaActual = event.pageIndex;
    this.totalPorPagina = event.pageSize;
    this.listarArrendatarios();
  }
  private listarArrendatarios(){
    this._arrendatarioService.listarArrendatariosPaginados(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      arrendatarios => {
        this.listArrendatarios =  arrendatarios._embedded['arrendatarios'] as Arrendatario[];
        console.log(this.listArrendatarios);
        this.totalRegistros = arrendatarios.page.totalElements as number;
        this.flagLoading = false;
        console.log('encontro arrendatarios');
      }, error => {
        console.log('No encontro arrendatarios. Error:  ' + error);
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
    let listArrendatarioFilter = this.listArrendatarios;
    console.log(listArrendatarioFilter);
    
    /*this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }*/
  }

  openDialogCrearCliente(): void {
    const dialogRef = this._matDialog.open(AddEditArrendatarioComponent, {
       width: '650px',
       height:'600px'
     });
 
     dialogRef.afterClosed().subscribe(result => {
       if(result != null){
         this.ngOnInit();
       }
      });
   }

}