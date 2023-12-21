import { Component } from '@angular/core';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor () {
    console.log("env", environment.production);
  }

  async getPersons() {
    try {
      const apiUrl = environment.production ? `${window.location.origin}/api` : `${environment.backendUrl}`;
      const persons = await fetch(`${apiUrl}/getall`);
      const personsJson = await persons.json();
      console.log("liste des personnes", personsJson)
    } catch(err) {
      console.log(err)
    }
  }

  async getBackend() {
    try {
      const persons = await fetch('http://127.0.0.1:8080/getall');
      const personsJson = await persons.json();
      console.log("liste des personnes", personsJson)
    } catch(err) {
      console.log(err)
    }
  }
}
