// const word = "HELLO WORLD";
// let time = 200;

// for (let i = 0; i <= word.length; i++) {
//     setTimeout(() => {
//         let header = document.getElementById("hello");
//         header.innerHTML = word.substring(0, i);
//     }, time);
//     time += 200;
// }

function createHeading() {
    const text = "HELLO WORLD";
    const textContainer = document.getElementById("hello");
    simulateTextMachine(textContainer, text);
}

function simulateTextMachine(element, text) {
    for (let i = 0; i < text.length; i++) {
        const letter = text.charAt(i);
        setTimeout(() => element.append(letter), (i+1) * 200);
    }
}

createHeading();
