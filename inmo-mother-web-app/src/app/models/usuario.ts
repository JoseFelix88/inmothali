export class Usuario {

    private _access_token: string;
    private _token_type: string;
    private _refresh_token: string;
    private _expires_in: number;
    private _scope: string;
    private _user_name: string;
    private _codigo_usuario: number;
    private _nombre_usuario: string;
    private _jti: string;
    private _password: string;
    
    constructor(username: string, password: string) {
        this._user_name = username;
        this._password = password;
    }


    public get accessToken(): string {
        return this._access_token;
    }
    public set accessToken(value: string) {
        this._access_token = value;
    }

    public get tokenType(): string {
        return this._token_type;
    }
    public set tokenType(value: string) {
        this._token_type = value;
    }

    public get refreshToken(): string {
        return this._refresh_token;
    }
    public set refreshToken(value: string) {
        this._refresh_token = value;
    }

    public get expiresIn(): number {
        return this._expires_in;
    }
    public set expiresIn(value: number) {
        this._expires_in = value;
    }

    public get scope(): string {
        return this._scope;
    }
    public set scope(value: string) {
        this._scope = value;
    }

    public get userName(): string {
        return this._user_name;
    }
    public set userName(value: string) {
        this._user_name = value;
    }

    public get codigoUsuario(): number {
        return this._codigo_usuario;
    }
    public set codigoUsuario(value: number) {
        this._codigo_usuario = value;
    }

    public get nombreUsuario(): string {
        return this._nombre_usuario;
    }
    public set nombreUsuario(value: string) {
        this._nombre_usuario = value;
    }

    public get jti(): string {
        return this._jti;
    }
    public set jti(value: string) {
        this._jti = value;
    }

    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }

}
