import { TipoPersona } from '../utils/enums/tipo-persona.enum';
import { DireccionArrendatario } from './direccion-arrendatario';
import { TelefonoArrendatario } from './telefono-arrendatario';

export class Arrendatario {
    codigoArrendatario?: number;
    numeroDocumento: number;
    primerApellido: string;
    segundoApellido: string;
    primerNombre: string;
    segundoNombre: string;
    razonSocial?: string;
    tipoDocumento: string;
    tipoPersona: TipoPersona;
    correoElectronico: string;
    telefonos: TelefonoArrendatario[] = [];
    direcciones: DireccionArrendatario[] = [];
    
}
