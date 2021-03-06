<%-- 
    Document   : index
    Created on : 17 de jul. de 2022, 19:52:37
    Author     : lieds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Help Me!</title>
    <script src="javaScript.JS"> </script>

    <link rel="stylesheet" href="Style.css">
</head>
<body id="oi">
    
    <%String error = request.getParameter("error");
    %>

    <form method="post" action="CadastroServlet">
        <div class="popup-wrapper_cadastro" id="hello"> 
            <div class="popup_cadastro">
                <div class="popup-close_cadastro" onclick="offcadastro()">X</div>

                <div class="popup-content_cadastro">

                    <h1>Crie sua conta, e deixe a gente dá um Help em você.</h1>
                    <div class="input_info_geral">
                        <input type="text" name="cadastro_nome" placeholder="Nome Completo" id="cm">
                        <input type="password" name="cadastro_senha" placeholder="Senha" id="cs">
                        <input type="password" name="cadastro_repita_senha" placeholder="Repita a senha" id="crs">
                        <input type="date" name="cadastro_data_nasc" placeholder=" Data de Nascimento" id="cdn">
                    </div>
                    <h1>Dados de Contato:</h1>
                    <div class="input_email">
                        <input type="text" name="cadastro_email" placeholder="E-mail" id="ce">
                        <input type="text" name="cadastro_celular" placeholder="Telefone/celular" id="cct">
                    </div>

                    <h1>Você é aluno ou professor</h1>
                    <div class="opcao">                        
                        <select name="cargo"  id="cc">
                            <option value="qual">Tipo de Conta</option>
                            <option value="aluno">Aluno</option>
                            <option value="prof">Professor</option>
                        </select>                        
                    </div>
                    <p name="error" id="error-message"><%=error %></p> <!-- Organizar as mensagens de erro no formulário -->
                    <button type="submit" id="confirma_log">Cadastrar</button>
                </div>
            </div>
        </div> 
    </form>


    <form method="post" action="LoginServelet">
        <div class="popup-wrapper" id="olamundo" >
            <div class="popup">
                <div class="popup-close" onclick="fechar()">X</div>

                <div class="popup-content" >
                    <img src="imgs/Rectangle 17.svg" alt="img11">
                    <h1>Faça seu login</h1>
                    <div class="input_info">
                        <input type="text" name="login_email" placeholder="E-mail" id="le">
                        <input type="password" name="login_senha" placeholder="Senha" id="ls">
                    </div>
                    <button type="submit" id="confirma_log">Login</button>
                    <div class="n_login">
                        <a href=""><p>Esqueci minha senha</p></a>
                        <a href=""><p>Não tenho Cadastro</p></a>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <header>
        <nav>
            <a href="#Home" class="botao_home" id="link-home">Home</a>
    
            <div id="cl">
                <button onclick="aperta()" id="lg">
                    Login
                </button>
                <button onclick="oncadastro()" id="cadastro">
                    Cadastro
                </button>
            </div>
        </nav>

        <div id="cabecalho">
            <div class="instruindo">
                <h1>Me Explica?</h1>
                <p>Busque professores para te ajuda </p>
                <a href="#BuscaAgora" class="botao" id="pesquise_butt">Busque Agora</a>
            </div>

            <div class="tres"></div>

            <div class="imgprime">
                
                <img src="imgs/Image.svg" alt="img1">
            
            </div>
        </div>

    </header>
   

    <section id="Serviços">
        <h1>FAZEMOS A PONTE!</h1>
        

        <div class="clientes">

            
                <div class="img_aluno">
                    <img src="imgs/Rectangle 10.svg" alt="img2">
                    
                    <div class="paragrafo1">
                        <h3> Estudantes</h3>
                        <p>Encontre professores disponíveis para te ensinar qualquer conteúdo por preços acessíveis.</p>
                    </div>   
                    <a href="#BD_Aluno" class="botao">Confira agora</a>

                </div>

                <div class="img_prof">
                    <img src="imgs/Rectangle 10-1.svg" alt="img3">   
        
                    <div class="paragrafo2">
                        <h3>Professores</h3>
                        <p>Ofereça seu serviço e garanta uma uma agenda cheia e ainda ganhe uma renda extra</p>
                    </div>
                    <a href="#BD_Professor" class="botao">Cadastre-se</a>
                    
                </div>    
            

        </div>

    </section>

    <section id="info">
        
        <h1>A PESSOA CERTA NA HORA CERTA!</h1>

        <div class="conteudo">
            <div class="paragrafo3">
                <div class="p1">
                    <p>Você pode encontrar um profissional com que seja especialista na sua situação...</p>
                </div>
            
                <div class="p2">
                    <p>Seja por dificuldade ou condição especial, a gente te ajuda a encontrar a pessoa certa!</p>
                </div>
            </div>

            
            <img src="imgs/Rectangle 13.svg" alt="img4">
               
        </div>
    </section>

    <section id="Contato">
        
        <h1>Acompanhe a gente</h1>
        
        <div class="info_contato">
            <div class="cont_loja">
                <div class="imgs_cont">
                    <img src="imgs/akar-icons_instagram-fill.svg" alt="img6" link>
            
            
                    <a href="https://www.youtube.com/watch?v=MHwyRNtjXIY"><img src="imgs/Group.svg" class="oi" alt="img7"></a>
        
            
                    <a href=""><img src="imgs/akar-icons_twitter-fill.svg" alt="img8"></a>
                </div>

                <img class="logo" src="imgs/Rectangle 17.svg" alt="img9">

                <div class="paragrafo4">
                    <p>Somo um site que buscar ligar profissinais da educação com alunos que precisam de um 
                        reforço escolar, seja por dificuldade particular ou entendimento.
                    </p>
                </div>

            </div>

           
        </div>  

        <h2 class="duvidas">MANDE SUAS DÚVIDAS!</h2>

        
        <form action="#">
            <input type="text" name="nome" placeholder="Nome" id="name1">
            <input type="text" name="e_mail" placeholder="e_mail" id="mail">

            <div class="ola">
                <textarea  name="mensagem" id="ola" cols="30" rows="10"> Digite aqui suas frustrações</textarea>
            </div>
        </form>
       
    </section> 

</body>
</html>
