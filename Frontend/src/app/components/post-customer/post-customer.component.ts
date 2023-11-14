import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-customer',
  templateUrl: './post-customer.component.html',
  styleUrls: ['./post-customer.component.css']
})
export class PostCustomerComponent {

  postCustomerForm!  : FormGroup;

constructor(private customerService : CustomerService,
            private fb : FormBuilder,
            private router : Router){

}

ngOnInit(){

  this.postCustomerForm = this.fb.group({
    name : [null, Validators.required],
    email : [null, Validators.required, Validators.email],
    phone : [null, Validators.required],

  })

}

  postCustomer(){
    console.log(this.postCustomerForm.value);
    this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res) => {
    console.log(res); 
    this.router.navigateByUrl('/');
    })
  }



}
