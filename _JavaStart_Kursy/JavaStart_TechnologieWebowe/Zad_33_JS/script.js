const title = "Kurs programowania";
const h1 = "Kurs programowania w JavaScript";
const p = "Ucz się na praktycznych przykładach, rozwiązując dziesiątki zadań.";
const price = 299;

let html = 
`
  <html>
      <head>
          <title>${title}</title>
      </head>
      <body>
          <h1>${h1}</h1>
          <p>${p}</p>
          <p>Cena kursu: ${price}</p>
      </body>
  </html>
`;

console.log(html);