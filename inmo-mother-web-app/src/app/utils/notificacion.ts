import Swal from 'sweetalert2';

export class Notificacion {

    public static showNotifyTypeSuccess(mensaje: string): void {
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: mensaje,
            showConfirmButton: false,
            timer: 2300
        });
    }

    public static showNotifyTypeConfirm(title: string, bodyMessaje: string, typeIconMessaje: any, messageConfirmed?: string): void {
        Swal.fire({
            title: title,
            text: bodyMessaje,
            icon: typeIconMessaje,
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si'
        }).then((result) => {
            if (result.isConfirmed) {
                this.showNotifyTypeSuccess(messageConfirmed);
            }
        })
    }

}
