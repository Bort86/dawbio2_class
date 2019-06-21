import {ClothesType} from "./clothesType";

export class Clothes
{
	id: number;
	clothesType: ClothesType;
	colour: string;
	expeditionDate: any;
	price: number

	//Methods declaration
	constructor (id: number,clothesType: ClothesType,colour: string,expeditionDate: any, price: number)
	{
		this.id=id;
		this.clothesType=clothesType;
		this.colour=colour;
		this.expeditionDate=expeditionDate;
		this.price=price;
	}

	setId (id: number): void{this.id=id;}
	setClothesType (clothesType: ClothesType):void{this.clothesType=clothesType;}
	setColour (colour: string):void{this.colour=colour;}
	setExpeditionDate (expeditionDate):void{this.expeditionDate=expeditionDate;}
	setPrice (price: number):void{this.price=price;}



	getId (): number {return this.id;}
	getClothesType () : ClothesType {return this.clothesType;}
	getColour (): string {return this.colour;}
	getExpeditionDate (): any {return this.expeditionDate;}
	getPrice (): number {return this.price;}
}
