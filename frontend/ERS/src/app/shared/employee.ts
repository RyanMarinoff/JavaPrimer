import { Manager } from './manager';

export class Employee extends Manager {
    public manager: Manager;
    constructor(id: number, 
                username: string, 
                password: string, 
                email: string, 
                first: string, 
                last: string,
                manager: Manager) {
        super(id, username, password, email, first, last);
        this.manager = manager;
    }
}
