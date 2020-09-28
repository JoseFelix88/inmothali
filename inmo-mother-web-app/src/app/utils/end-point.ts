export class EndPoint {
    
    private servidor: string = 'http:\\localhost:';
    private port: string = '8080';
    private versionApi: string = 'v1';
    private urlBase: string = this.servidor + this.port + '\\api\\' + this.versionApi + '\\inmo\\';

    private _token: string = "oauth\\token";
    private _arrendatario: string = "arrendatario";
    private _propietario: string = "propietario";
    private _contrato: string = "contrato";
    private _pagocontrato: string = "pagocontrato";
    private _prediopropietario: string = "prediopropietario";



    get token(): string {
        return this.urlBase + this._token;
    }

    get arrendatario(): string {
        return this.urlBase + this._arrendatario;
    }
    
    get propietario(): string {
        return this.urlBase + this._propietario;
    }

    get contrato(): string {
        return this.urlBase + this._contrato;
    }

    get pagocontrato(): string {
        return this.urlBase + this._pagocontrato;
    }

    get prediopropietario(): string {
        return this.urlBase + this._prediopropietario;
    }

    

}
