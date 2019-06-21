import { Directive } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl } from '@angular/forms';

@Directive({
  selector: '[appItemValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: ItemValidatorDirective, multi: true}]
})
export class ItemValidatorDirective {

  constructor() { }

  /*
  @name= validate()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= it should try to validate if items per page is a number, but it doesn't
  @date= 05/04/2019
  @params = formFieldToValidate
  @ returns = a key and its value with the error in case there is any
*/
  validate(formFieldToValidate: AbstractControl): {[key: string] : any}{

    let validInput : boolean = false;
    
    if (formFieldToValidate.value!=undefined && !isNaN(formFieldToValidate.value)){
      if (formFieldToValidate.value> 0){
        validInput = true;
        } else{
          return validInput?null:{'OutofRange':true}
        }
      } else {
        return validInput?null:{'IsNotNumber': true};
      }
    }
}
