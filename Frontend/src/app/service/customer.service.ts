import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'http://localhost:5000/';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  postCustomer(customer: any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/post/customer', customer);
  }

  getAllCustomers() : Observable<any>{
    return this.http.get(BASIC_URL+"api/getall");
  }

  deleteCustomer(id : number) : Observable<any>{
    return this.http.delete(BASIC_URL+"api/delete/"+id);
  }

  getCustomerById(id: number) : Observable<any>{
    return this.http.get(BASIC_URL+"api/getbyid/"+id);
  }

  updateCustomer(id:number, customer: any) : Observable<any>{
    return this.http.put(BASIC_URL+"api/update/" +id, customer);
  }


}
