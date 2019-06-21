export class ClothesType
{
	id: number;
	type: string;
	//Methods declaration
	constructor (id: number,type: string)
	{
		this.setId(id);
		this.setType(type);
	}

	setId (id: number): void {this.id=id;}
	setType (type: string): void {this.type=type;}


	getId (): number {return this.id;}
	getType () : string  {return this.type;}
}
