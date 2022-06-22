
function aperta(){
        var element = document.getElementById("olamundo");
        var element2 = document.getElementById("oi");
        var element3 = document.getElementById("Serviços");
        element3.classList.add("sumir")
        element2.classList.add("xau");
        element.classList.add("aperta");
        console.log(element);
}

function gambiara(){
        var element = document.getElementById("hello");
}

function fechar(){
        var element = document.getElementById("olamundo");
        var element2 = document.getElementById("oi");
        var element3 = document.getElementById("Serviços");
        element3.classList.remove("sumir")
        element2.classList.remove("xau");
        element.classList.remove("aperta");
}

function oncadastro(){
        var element = document.getElementById("hello");
        var element2 = document.getElementById("oi");
        var element3 = document.getElementById("Serviços");
        element3.classList.add("sumir")
        element2.classList.add("xau");
        element.classList.add("aperta");
        console.log(element);
        console.log("click");
}

function offcadastro(){
        var element = document.getElementById("hello");
        var element2 = document.getElementById("oi");
        var element3 = document.getElementById("Serviços");
        element3.classList.remove("sumir")
        element2.classList.remove("xau");
        element.classList.remove("aperta");

}

/*gambiara*/

function fechaModal(){
        var element = document.getElementById("modal");
        element.classList.remove("mostraModal");
        document.getElementById("formAdota").style.display = "block";
        document.getElementById("formDoa").style.display = "block";
}

function ocultarAdota() {
        document.getElementById("formAdota").style.display = "none";
}

function ocultarDoa() {
        document.getElementById("formDoa").style.display = "none";
}