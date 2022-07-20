<%-- 
    Document   : tela_perfil_professor
    Created on : 20 de jul. de 2022, 13:42:37
    Author     : lieds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="controller.CreateUsuarioPerfil"
        import="model.database.entities.Professor"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pefil do professor</title>
    <link rel="stylesheet" href="./Style_telaprof.css">
    
</head>
<body>    
    
    <%
      int id = Integer.parseInt(request.getParameter("id"));      
      Professor professor = new CreateUsuarioPerfil().createProfessorById(id); %>
    
    <header>
        <nav>
            <img src="imgs/Foto Perfil.svg" alt="img1">
            <div class="info_primaria">

                <h1><%=professor.getNome_completo()%> <img src="imgs/" alt="picel"></h1>
                <p><%=professor.getAutodescricao()%></p>
                <button>Entrar em contato</button>
            </div>
            
            <h1 class="nota_avaliativa">4,8</h1>
        </nav>
    </header>

    <section class="info_geral">
        <div class="meios">
            <div class="capacitacao">
                <h2><img src="imgs//maos.svg" alt="">Capacitação </h2>                
                <p>Braile</p>
                <p>Libras</p>
                <p>Sindrome de Down</p>
                <p></p>
                <!-- <h3><img src="help me/mais.svg" alt=""> Edita Disciplina</h3> -->
                
            </div>

            <div class="diciplinas">
                <h2><img src="imgs//livro.svg" alt="">diciplinas </h2>
                <p>Lingua Inglesa</p>
                <p>Lingua Portuguesa</p>
                <p>Lingua Espanhola</p>
                <p></p>
                <!-- <h3><img src="help me/mais.svg" alt=""> Edita Disciplina</h3> -->
        
            </div>

            <div class="ferramentas">
                <h2><img src="imgs//ferramentas.svg" alt=""> Ferramentas</h2>
                <p>Google Meet</p>
                <p>Slack</p>
                <p>Google Classroom</p>
                <p></p>
                <!-- <h3><img src="help me/mais.svg" alt=""> Edita Disciplina</h3> -->

            </div>
        </div>

    </section>

    <section class="grade">

        <div class="horario">

            <h2><img src="imgs//calendario.svg" alt=""> Horários</h2>

            <table >
                <tr class="one">
                    <td>Dia da Semana</td>
                    <td>Disciplina</td>
                    <td>Hora Inicio</td>
                    <td>Hora Fim</td>
                    <td>Ensino</td>
                </tr>

                <tr>
                    <td >Segunda</td>
                    <td>Lingua Portuguesa</td>
                    <td>08:40</td>
                    <td>10:40</td>
                    <td>Presencial</td>
                </tr>

                <tr>
                    <td>Segunda</td>
                    <td>Lingua Inglesa</td>
                    <td>18:00</td>
                    <td>20:00</td>
                    <td>Remoto</td>
                </tr>

                <tr>
                    <td>Quinta</td>
                    <td>Lingua Espanhola</td>
                    <td>9:00</td>
                    <td>12:00</td>
                    <td>Remoto</td>
                </tr>

                

            </table>

            <h3><img src="imgs//mais.svg" alt="img5">Ver Grade Completa</h3>
        </div>

    </section>

    <section class="formas_pagamento">
        <h1><img src="imgs//dinheiro.svg" alt="im4">Formas de Pagamento</h1>
        
        <div class="info_pagar">
            
            <div class="pix">
                <img src="imgs//pix.svg" alt="im9">
                <p>Pix</p>
            </div>

            <div class="cartao">
                <img src="imgs//cartao.svg" alt="img7">
                <p>Cartão de Crédito/Debitos</p>
            </div>

            <div class="dinheiro">
                <img src="imgs//dinheiro1.svg" alt="img11">
                <p>Dinheiro</p>
            </div> 
            
        </div>
        <!-- <h2><img src="help me/mais.svg" alt="img12"> Edita Forma de Pagamento</h2> -->
        <div class="interesse">
            <button class="contato_prof">Entrar em Contato</button>
            <button class="avalia_prof">Avaliar Professor</button>
        </div>
    </section>
    
</body>
</html>