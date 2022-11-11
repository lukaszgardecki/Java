function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

Person.prototype.fullName = function() {
    return this.firstName + " " + this.lastName;
}

// Wszystkie osoby pochodzą z polski:
Person.prototype.country = "Poland";


let p1 = new Person("Jan", "Kowalski");
let p2 = new Person("Jan", "Kowalski");

//w tym miejscu nie modyfikujemy country
// tylko DODAJEMY WŁASNOŚĆ COUNTRY
// Ustawiony wcześniej prototyp ma nadal wartość "Poland"
p1.country = "Gernany";
p2.country = "France";



console.log(p1.fullName === p2.fullName);
console.log(p2.fullName() === p2.fullName());
console.log(p1.__proto__ === Person.prototype);

console.log("p1.country = " + p1.country);
console.log("p1.__proto__.country = " + p1.__proto__.country);

console.log("p2.country = " + p2.country);
console.log("p2.__proto__.country = " + p2.__proto__.country);



console.log("-----------------------------------------------")



function Person2(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

Person2.prototype.fullName = function() {
    return this.firstName + " " + this.lastName;
}

function Student(fn, ln, id) {
    Person.call(this, fn, ln);
    this.id = id;
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.fullInfo = function() {
    return this.firstName + " " + this.lastName + " " + this.id;
}


let person1 = new Person("Jan", "Kowalski");
console.log(person1.fullName());

let student1 = new Student("Karolina", "Zalewska", "12345");
console.log(student1.fullInfo());