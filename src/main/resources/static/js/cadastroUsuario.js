function putUser () {
    let cpf = document.getElementById('cpfCadastro');
    let fone = document.getElementById('foneCadastro');
    let nome = document.getElementById('nomeCadastro');
    let email = document.getElementById('emailCadastro');
    let senha = document.getElementById('senhaCadastro');
    let num_ap = document.getElementById('numApCadastro');



    let xhr = new XMLHttpRequest ();
    // xhr.onload = exibeMaisFilmes;
    xhr.open ('POST', 'http://localhost:8080/usuarios');
    xhr.setRequestHeader()

    xhr.send ();
}
