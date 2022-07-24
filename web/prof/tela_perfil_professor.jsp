<%-- 
    Document   : tela_perfil_professor
    Created on : 20 de jul. de 2022, 13:42:37
    Author     : lieds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="controller.CreateUsuarioPerfil"
        import="model.database.entities.Professor" import="model.database.entities.Ferramenta"
        import="model.database.entities.Disciplina" import="model.database.entities.CapacitacaoEspecial"
        import="model.database.entities.ProfessorHorario"%>
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
                <% for(CapacitacaoEspecial condicao : professor.getCapacitacaoEspecialList()) { %>
                    <p><%=condicao.getNome_capacitEspecial()%></p>                
                <% } %>
                <p></p>
                <!-- <h3><img src="help me/mais.svg" alt=""> Edita Disciplina</h3> -->
                
            </div>

            <div class="diciplinas">
                <h2><img src="imgs//livro.svg" alt="">diciplinas </h2>
                <% for(Disciplina disciplina : professor.getDisciplinasList()) { %>
                    <p><%=disciplina.getNome_disciplina()%></p>                
                <% } %>
                <p></p>
                <!-- <h3><img src="help me/mais.svg" alt=""> Edita Disciplina</h3> -->
        
            </div>

            <div class="ferramentas">
                <h2><img src="imgs//ferramentas.svg" alt=""> Ferramentas</h2>
                <% for(Ferramenta ferramenta : professor.getFerramentasList()) { %>
                    <p><%=ferramenta.getNome_ferramenta()%></p>                
                <% } %>
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
                
                <%for (ProfessorHorario horario : professor.getProfHorarioList()) {%>
                    <tr>
                        <td ><%=horario.getDia_semana() %></td>
                        <td><%=horario.getDisciplina().getNome_disciplina() %></td>
                        <td><%=horario.getHora_inicio() %></td>
                        <td><%=horario.getHora_fim() %></td>
                        <td><%=horario.getForma_ensino() %></td>
                    </tr>  
                <% } %>

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