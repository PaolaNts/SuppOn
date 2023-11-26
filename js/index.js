function loginHandler(event) {
    event.preventDefault(); // Impedir o envio do formulário

    const emailElement = document.getElementById("email");
    const passwordElement = document.getElementById("password");

    const emailValue = emailElement.value;
    const passwordValue = passwordElement.value;

    const formData = {
        useremail: emailValue,
        password: passwordValue
    };

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error("Erro durante a solicitação:", error);
    });
}

const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", loginHandler);
