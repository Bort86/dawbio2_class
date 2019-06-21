import { Component, OnInit } from '@angular/core';

// importing models
import {Clothes} from '../model/clothes';
import {ClothesType} from '../model/clothesType';

@Component({
  selector: 'app-clothes-management',
  templateUrl: './clothes-management.component.html',
  styleUrls: ['./clothes-management.component.css']
})
export class ClothesManagementComponent implements OnInit {

  //Attributes
  clothes: Clothes[]=[];
  clotheTypes: ClothesType[]=[];
  clothFiltered: Clothes[]=[];
  colours: string[]=[];

  //Pagination properties
  itemsPerPage: number;
  currentPage: number;
  totalItems: number;

  //Filter properties
  priceFilter: number;
  colourFiltered: string;

  constructor() { }

  /*
  @name= ngOnInit()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= it will generate set of colours, clothe types and random cloth objects
  Also will set a couple of attributes for pagination
  @date= 05/04/2019
  @params =
  @ returns =
*/
  ngOnInit() {

    this.generateColours();
    this.generateClotheTypes();
    this.generateRandomClothes();

    //Pagination and Filter properties' initialization
    this.itemsPerPage = 10;
    this.currentPage = 1;
    this.totalItems = this.clothes.length;


    this.priceFilter = 100;
    this.clothFiltered = this.clothes;
  }

  /*
  @name= generateColours()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= simple funciton to generate colour options for select
  @date= 05/04/2019
  @params =
  @ returns =
*/
  generateColours() {
    this.colours.push("White");
    this.colours.push("Red");
    this.colours.push("Black");
  }

  /*
  @name= generateClotheTypes()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= it will generate clothetype objects and push them to the controller
  clothe type array attribute
  @date= 05/04/2019
  @params =
  @ returns =
*/

  generateClotheTypes(){
    let type1 = new ClothesType(1, "Dress");
    let type2 = new ClothesType(2, "Skirt");
    let type3 = new ClothesType(3, "Pants");
    this.clotheTypes.push(type1);
    this.clotheTypes.push(type2);
    this.clotheTypes.push(type3);
  }

  /*
  @name= generateRandomClothes()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= it will generate 100 random cloth objects and push them to the controller
  array attribute
  @date= 05/04/2019
  @params =
  @ returns =
*/
  generateRandomClothes(){
    let randomId: number;
    let randomClothestype: ClothesType;
    let randomColour: string;
    let randomDate: any;
    let randomPrice: number;
    let today = new Date();

    for (let i = 0; i < 100; i++){
      randomId = i;
      randomPrice = Math.floor(Math.random()*99);
      let randNumber= Math.floor(Math.random()*3);
      randomClothestype = this.clotheTypes[randNumber];
      randomColour = this.colours[randNumber];
      randomDate = today.getFullYear() + "-" + today.getMonth()+1 + "-" +  today.getDate();

      let cloth = new Clothes(randomId, randomClothestype, randomColour, randomDate, randomPrice);
      this.clothes.push(cloth);
    }
  }
  /*
  @name= filter()
  @authors=Pablo Rodriguez
  @version= 1.0
  @description= filters clothes per price. It filters by price and colour
  If the colour selected is "All", gets all the colours
  @date= 05/04/2019
  @params =
  @ returns =
*/
  filter(): void {
    this.clothFiltered= this.clothes.filter(
      clothes => {
        let priceValid = false;
        let colourValid = false;

        priceValid = clothes.getPrice() <= this.priceFilter;
        colourValid = clothes.getColour() <= this.colourFiltered;

        if (this.colourFiltered == "All"){
          colourValid = true;
        } else {
           colourValid= clothes.getColour() .toLowerCase().indexOf(this.colourFiltered.toLowerCase())!=-1;
        }
        return ( priceValid && colourValid)
      }
    );
  }


}
