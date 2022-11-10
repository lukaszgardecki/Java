let isLeap = function(year) {
   return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
} 

function isYearLeapAndPrint(year) {
    const yearType = isLeap(year) ? "Przestępny" : "Nieprzestępny";
    console.log(year + " jest " + yearType);
}

isYearLeapAndPrint(1934);
isYearLeapAndPrint(1988);
isYearLeapAndPrint(2012);