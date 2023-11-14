import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'

@Component({
  selector: 'app-update-customers',
  templateUrl: './update-customers.component.html',
  styleUrls: ['./update-customers.component.css']
})
export class UpdateCustomersComponent {

  id : number = this.activateRoute.snapshot.params['id'];

  updateCustomerForm!  : FormGroup;

  constructor(private activateRoute : ActivatedRoute,
    private service : CustomerService,
    private fb : FormBuilder,
    private router : Router){

    }

    ngOnInit(){
      this.updateCustomerForm = this.fb.group({
        name : [null, Validators.required],
        email : [null, Validators.required, Validators.email],
        phone : [null, Validators.required],
      })
      this.getCustomerById();
    }

    getCustomerById(){
      this.service.getCustomerById(this.id).subscribe( (res) => {
        console.log(res);
      this.updateCustomerForm.patchValue({
        name : res.name,
        email : res.email,
        phone : res.phone,
      });
      })
    }

    updateCustomer(){
      this.service.updateCustomer(this.id, this.updateCustomerForm.value).subscribe((res) =>{
        console.log(res);
        this.router.navigateByUrl("/");
      })
    }

}
