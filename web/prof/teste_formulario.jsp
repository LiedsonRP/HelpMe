<%-- 
    Document   : teste_formulario
    Created on : 19 de jul. de 2022, 17:20:54
    Author     : lieds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="model.database.dao.DisciplinaDAO" import="model.database.entities.Disciplina"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>                
        
        <div>
            <h1>DELETAR CELULAR</h1>
            <form method="post" action="EmailUpdateServelet">
                <select placeholder="E-mail" name="numero">
                    <%for (Disciplina disciplina : new DisciplinaDAO().selectAllDisciplinas()) { %>
                        <option><%=disciplina.getNome_disciplina()%></option>
                    <% } %>
                </select>
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
