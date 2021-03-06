<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Gangplank</title>
    <r:require modules="gangplank"/>
  </head>
  <body>

   <div class="container-fluid">

     <h1>List of registered schemas</h1>

     <table class="table table-bordered table-striped">
       <thead>
         <tr>
           <td>Schema name</td>
         </tr>
       </thead>
       <tbody>
         <g:each in="${schemas}" var="s">
           <tr>
             <td><g:link controller="schema" action="show" id="${s.id}">${s.name}</g:link></td>
           </tr>
         </g:each>
       </tbody>
     </table>
   </div>
  
  </body>
</html>
