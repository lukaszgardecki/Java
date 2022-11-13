
//Sposób 1: w kodzie HTML, do button dodajemy własność onclick i przypisujemy tę funkcję:
// function incrementCounter() {
//     document.getElementById('counter').innerHTML++;
// }

//Sposób 2: w kodzie HTML nie piszemy nic, tutaj łapiemy button po ID i przypisujemy funkcję. W ten sposób możemy zarejestrować tylko jednego słuchacza (fukncję):
// function registerButton() {
//     let button = document.getElementById("counter-button");
//     button.onclick = function() {
//         document.getElementById("counter").innerHTML++;
//     }
// }
// registerButton();

//Sposób 3: w kodzie HTML nie piszemy nic, tutaj łapiemy button po ID i przypisujemy słuchacza .addEventListener():
// function regisretButton1() {
//     let button = document.getElementById("counter-button");
//     button.addEventListener("click", () => document.getElementById("counter").innerHTML++);
// }
// regisretButton1();

function registerEnableButton() {
    let enableButton = document.getElementById("enable-button");
    enableButton.onclick = function() {
        let counterButton = document.getElementById("counter-button");
        counterButton.addEventListener("click", incrementCounter);
    }
}

function registerDisableButton() {
    let disableButton = document.getElementById("disable-button");
    disableButton.onclick = function() {
        let counterButton = document.getElementById("counter-button");
        counterButton.removeEventListener("click", incrementCounter);
    }
}

function incrementCounter() {
    document.getElementById("counter").innerHTML++;
}

registerEnableButton();
registerDisableButton();