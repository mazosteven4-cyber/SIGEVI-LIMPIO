```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>SIGEVI - Resultado</title>
</head>
<body>
    <h1>Resultado del registro</h1>

    <p><strong>Nombre:</strong>
        <%= escapar(request.getAttribute("nombre")) %></p>

    <p><strong>Precio:</strong>
        <%= escapar(request.getAttribute("precio")) %></p>

    <p><strong>Cantidad:</strong>
        <%= escapar(request.getAttribute("cantidad")) %></p>

    <p>Los datos fueron recibidos mediante POST.</p>
    <a href="index.html">Volver al inicio</a>
</body>
</html>

<%!
    private String escapar(Object valor) {
        if (valor == null) return "";

        return valor.toString()
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
%>
```