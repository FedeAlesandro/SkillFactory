# Exercise 6

6) Crear una clase ClubMember con los siguientes atributos:
	name: String
	id: UUID
	phone: String
	age: Integer
	
Redefinir equals(), hashCode() y toString()● Los socios deben tener la posibilidad de ser comparados por su nombre

	● Crear una clase Club en donde los ClubMember van a tener la posibilidad de hacerse socios, votar y renunciar.
	● Entre los mismos socios se votan entre ellos para elegir presidente, la unica condicion es que no se pueden votar a ellos mismos.
	● Por reglamento del club tampoco se puede votar 2 veces, si esto ocurre se descalifica al socio quitándole la posibilidad de ser
votado por el resto.
	● Cada voto debe ir acompañado del id del socio que votó, si no ingresa su id, a este socio que votó, se le resta un voto, siempre y
cuando tenga votos, sino, no se le resta.
	● El club mes a mes va publicando una lista actualizada de sus socios, ordenada por orden alfabético (investigar cómo ayudar a la
colección a comparar objetos).
	● Si desea, puede agregar más funcionalidades y reglas.