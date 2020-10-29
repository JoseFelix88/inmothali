export class EndPoint {
    
    private servidor: string = 'http://localhost:';
    private port: string = '8080';
    private versionApi: string = 'v1';
    private urlBase: string = this.servidor + this.port + '/api/' + this.versionApi + '/inmo/';

    private _embedded = "_embedded";
    private _urlOauthToken: string = "oauth/token";
    private _arrendatario: string = "arrendatario";
    private _propietario: string = "propietario";
    private _contrato: string = "contrato";
    private _pagocontrato: string = "pagocontrato";
    private _prediopropietario: string = "prediopropietario";
    
    public get embedded() {
        return this._embedded;
    }

    get urlOauthToken(): string {
        return this.urlBase + this._urlOauthToken;
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
