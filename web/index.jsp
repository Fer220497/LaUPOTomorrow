<%-- 
    Document   : login
    Created on : 17-may-2018, 11:28:30
    Author     : Juanma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="es">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheet.css">
    <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">

    <title>UPO Tomorrow</title>
</head>

<body>
    <div class="container-fluid DarkBlue">
        <div class="container">
            <div class="row">
                <div class="col-md-4 text-center align-self-end">
                    <img class="rounded my-4" src='http://placekitten.com/88/88' alt='' />
                </div>
                <div class="col-md-4">
                    <h1 class="text-center font-weight-bold pt-1">
                        <span class="align-middle">
                            LA UPO
                            <span class="Orange">TOMORROW</span>
                        </span>
                    </h1>
                    <p class="text-center font-italic pb-1">Tu medio de desinformaci&oacute;n preferido</p>
                </div>
                <div class="col-md-4 text-center align-self-end">
                    <div class="btn-group align-bottom mb-4">
                        
                        <s:form action="irLogin"><button type="submit" class="btn btn-light">Login</button></s:form>
                         <s:form action="irRegistro"><button type="submit" class="btn btn-dark">Registro</button></s:form>
                    </div>
                </div>

            </div>
        </div>
    </div>
    
    <h1>AAAAA    </h1>
    
    
</body>
