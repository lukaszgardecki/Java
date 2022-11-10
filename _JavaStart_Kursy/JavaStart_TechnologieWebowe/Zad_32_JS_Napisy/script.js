let str1 = "To jest napis";
let str2 = 'To jest napis';
let str3 = `To jest napis`;

let str4 = "To jest \"cytat\" sławnego człowieka";
let str5 = 'To jest \'cytat\' sławnego człowieka';

let name = "Piotr";
let age = 20;

let intro = `${name} za rok będzie miał ${age + 1} lat`;
console.log(intro);

let sqlQuery = `
SELECT * FROM
    employees
WHERE
    gender = 'M' AND hire_date >= '1990-01-01'
ORDER BY
    hire_date
LIMIT
    10
`;
console.log(sqlQuery);


let str = new String("This Works!");

console.log(typeof "example"); //string
console.log(typeof new String("example")); //object

// charAt(string)
let str6 = "Ala ma kota";
console.log(str6.charAt(2)); //a

// concat(string)
let str7 = "Ala".concat(" ma ").concat("kota");
console.log(str7); //Ala ma kota

// includes(string)
let str8 = "Ala ma kota";
if (str8.includes("kot")) {
  console.log("Napis zawiera słowo kot");
}

//endsEith(string)
let str9 = "Ala ma kota";
if (str9.endsWith("kota")) {
  console.log("Napis kończy się słowem 'kota'");
}

// indexOf(string)
let str10 = "Ala ma kota";
console.log(str10.indexOf("ma")); //4

// lastIndexOf(string)
let str11 = "Ala ma kota, a kot ma Alę";
console.log(str11.lastIndexOf("kot")); //15

//repeat(number)
let str12 = "Witam ".repeat(5);
console.log(str12); //Witam Witam Witam Witam Witam 

//replace(strin, string)
let str13 = "Ala ma kota";
str13 = str13.replace("kota", "psa");
console.log(str13); //Ala ma psa

//replaceAll
let str14 = "Ala ma kota i Piotr też ma kota";
str14 = str14.replaceAll("kota", "psa");
console.log(str14); //Ala ma psa i Piotr też ma psa

// slice(numIN, numOUT) - odpowiednik SUBSTRING w JAVIE
let str15 = "Ala ma kota i Piotr też ma kota";
str15 = str15.slice(14, 23);
console.log(str15); //Piotr też

//split(string)
let str16 = "Ala ma kota";
console.log(str16.split(" ")); //["Ala", "ma", "kota"]

//startsWith(string)
let str17 = "Ala ma kota";
if (str17.startsWith("Ala")) { //true
  console.log("Napis zaczyna się słowem 'Ala'");
}

// substr(startIndex, length) / substring(startIndex, endIndex)
let str18 = "Ala ma kota";
console.log(str18.substr(4, 2)); //"ma"
console.log(str18.substring(4, 6)); //"ma"

// toLowerCase() / toUpperCase()
let str19 = "Ala ma kota";
console.log(str19.toUpperCase()); //ALA MA KOTA
console.log(str19.toLowerCase()); //ala ma kota

// trim() / trimStart() / trimEnd()
let str20 = "   Ala ma kota   ";
console.log(str20.trim()); //"Ala ma kota"
console.log(str20.trimStart()); //"Ala ma kota   "
console.log(str20.trimEnd()); //"   Ala ma kota"






