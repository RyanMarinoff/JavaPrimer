export class Manager {
    public id: number;
    public username: string;
    public password: string;
    public email: string;
    public first: string;
    public last: string;

    constructor(id: number,
                username: string,
                password: string,
                email: string,
                first: string,
                last: string) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first = first;
        this.last = last;
    }
}
